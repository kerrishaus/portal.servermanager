package com.kerrishaus.portal.servermanager;

import com.kerrishaus.portal.servermanager.servers.minecraft.MinecraftServer;
import com.kerrishaus.portal.servermanager.websockets.WebSocketServer;

import java.net.InetSocketAddress;

public class ServerManager
{
    public static void main(String[] args)
    {
        //MinecraftServer s = new MinecraftServer();

        String host = "localhost";
        int port = 8887;

        WebSocketServer server = new WebSocketServer(new InetSocketAddress(host, port));
        server.run();
    }
}
