package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientHandler extends Thread {
    private final Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private String name;

    private static final Logger logger = Logger.getLogger(ClientHandler.class.getName());

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    public void run() {
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader((new InputStreamReader(clientSocket.getInputStream())));
            name = "client-" + (Server.clients.size() + 1);

            System.out.println(name + " connected");
            Server.broadcast("[SERVER] " + name + " connected.");

            String inputLine = in.readLine();
            while (true) {
                if ("-exit".equals(inputLine)) {
                    System.out.println("Client disconnected");
                    break;
                } else if (inputLine == null) {
                    System.out.println("Client disconnected");
                    Server.remoteClient(this);
                    break;
                } else if (inputLine.startsWith("-file ")) {
                    String filePath = inputLine.substring(6).trim();
                   // saveFile(clientSocket.getInputStream(), filePath);
                    System.out.println("File received and saved: " + filePath);
                } else {
                    Server.broadcast(name + ": " + inputLine);
                }
            }

            Server.remoteClient(this);
            System.out.println(name + " disconnected");
            Server.broadcast("[SERVER] " + name + " disconnected.");
            in.close();
            out.close();
            clientSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) in.close();
                if (out != null) out.close();
                if (clientSocket != null) clientSocket.close();
            } catch (IOException e) {
                logger.log(Level.SEVERE, "An error occurred while closing resources.", e);
            }
        }
    }

    public void sendMessage(String message) {
        out.println(message);
    }
}
