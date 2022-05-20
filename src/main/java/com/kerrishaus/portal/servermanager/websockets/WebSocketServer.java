package com.kerrishaus.portal.servermanager.websockets;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;

import com.kerrishaus.portal.servermanager.servers.minecraft.MinecraftServer;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.json.JSONObject;

public class WebSocketServer extends org.java_websocket.server.WebSocketServer
{
    private MinecraftServer server = null;

    public WebSocketServer(InetSocketAddress address)
    {
        super(address);

        this.server = new MinecraftServer();
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake)
    {
        conn.send("You are connected! My system time is: Y-m-d H:i:s T.");

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
        if (message.equals("logs"))
            conn.send("{\"cmd\": \"logs\"}");
        else if (message.equals("files"))
        {
            try
            {
                JSONObject response = new JSONObject();
                response.put("cmd", "files");
                response.put("files", server.getServerFiles());
                conn.send(response.toString());
            }
            catch (IOException e)
            {
                conn.send("There was an error retrieving the file contents.");
            }
        }

        System.out.println(conn.getRemoteSocketAddress() + ": " + message);
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

        server.setDirectory("/users/kennymccormick/servers/minecraft");
    }
}