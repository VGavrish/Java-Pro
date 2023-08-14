package org.example;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {
    private static final Logger logger = Logger.getLogger(Client.class.getName());

    public static void main(String[] args) {

        String serverAddress = "localhost";
        int serverPort = 8080;

        try (Socket socket = new Socket(serverAddress, serverPort);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            System.out.println("Connected to server at " + serverAddress + ":" + serverPort);
            Scanner scanner = new Scanner(System.in);

            Thread messageReceiver = new Thread(() -> {
                String inputLine;
                try {
                    while ((inputLine = in.readLine()) != null) {
                        out.println(inputLine);
                        //break;
                    }
                }catch (IOException e) {
                    logger.log(Level.SEVERE, "You put empty message");
                    e.printStackTrace();
                }
            });
            messageReceiver.start();

            String userInput;
            while (!(userInput = scanner.nextLine()).equals("-exit")) {
                out.println(userInput);
                break;
            }

            messageReceiver.interrupt();
             } catch (IOException e) {
            logger.log(Level.SEVERE, "An error occurred while communicating with the server. ", e);
            throw new RuntimeException(e);
        }
    }

    public static void sendFile(Socket socket, String filePath) throws IOException {
        File file = new File(filePath);
        try (BufferedInputStream fileInputStream = new BufferedInputStream(new FileInputStream(file));
             OutputStream outputStream = socket.getOutputStream()) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }
    }
}
