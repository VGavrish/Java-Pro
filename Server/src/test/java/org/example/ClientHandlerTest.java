package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.Socket;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ClientHandlerTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    private ClientHandler clientHandler;
    private Socket mockSocket;

    @BeforeEach
    public void setUpStream() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));

        mockSocket = mock(Socket.class);
        clientHandler = new ClientHandler(mockSocket);
    }

    @AfterEach
    public void restoreStreams() {
        System.setIn(originalIn);
        System.setOut(originalOut);
        System.setErr((originalErr));
    }

    @Test
    void testSendMessage() {
        try {
            OutputStream mockOut = mock(OutputStream.class);
            when(mockSocket.getOutputStream()).thenReturn(mockOut);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        clientHandler.sendMessage("Hello, client!");
        assertEquals("Hello, client!\n", outContent.toString());
    }
}
