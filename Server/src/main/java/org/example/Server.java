package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    protected static List<ClientHandler> clients = new ArrayList<>();
    private static final Object lock = new Object();

    private static final Logger logger = Logger.getLogger(Server.class.getName());

    public static void broadcast(String message) {
        synchronized (lock) {
            for (ClientHandler clientHandler : clients) {
                clientHandler.sendMessage(message);
            }
        }
    }

    public static void remoteClient(ClientHandler client) {
        clients.remove(client);
    }

    public static void saveFile(InputStream inputStream, String fileName) throws IOException {
       try (FileOutputStream outputStream = new FileOutputStream(fileName)) {
          byte[] buffer = new byte[1024];
          int bytesRead;
          while ((bytesRead = inputStream.read(buffer)) != -1) {
              outputStream.write(buffer, 0, bytesRead);
          }
       }
    }
        public static void main(String[] args) {
            int PORT = 8080;

            try(ServerSocket serverSocket = new ServerSocket(PORT)) {
                System.out.println("Server started on port " + PORT);

                while (true) {
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("New client connected");
                    ClientHandler clientHandler = new ClientHandler(clientSocket);
                    clients.add(clientHandler);
                    clientHandler.start();
                }
            }catch (IOException e) {
                logger.log(Level.SEVERE, "An error occurred while handing the request.", e);
            }
        }
}
