package com.kerrishaus.portal.servermanager;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

public class SimpleServer extends WebSocketServer
{
    private Server server = null;

    public SimpleServer(InetSocketAddress address)
    {
        super(address);

        this.server = new Server();
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake)
    {
        conn.send("You are connected! My system time is: Y-m-d H:i:s T.");
        conn.send("Here is your server directory:");

        try {
            conn.send(server.getDirectoryContents().toString());
        } catch (IOException e) {
            conn.send("There was an error retrieving the file contents.");
        }

        System.out.println("New connection established: " + conn.getRemoteSocketAddress());
    }
    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote)
    {
        System.out.println("closed " + conn.getRemoteSocketAddress() + " with exit code " + code + " additional info: " + reason);
    }

    @Override
    public void onMessage(WebSocket conn, String message)
    {
        conn.send("You said '" + message + "'");
        System.out.println("received message from "	+ conn.getRemoteSocketAddress() + ": " + message);
    }

    @Override
    public void onMessage(WebSocket conn, ByteBuffer message)
    {
        System.out.println("received ByteBuffer from "	+ conn.getRemoteSocketAddress());
    }

    @Override
    public void onError(WebSocket conn, Exception ex)
    {
        System.err.println("an error occurred on connection " + conn.getRemoteSocketAddress()  + ":" + ex);
    }

    @Override
    public void onStart()
    {
        System.out.println("Server started successfully.");

        server.SetDirectory("/users/kennymccormick/servers/minecraft");
    }
}