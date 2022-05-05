package com.kerrishaus.portal.servermanager;

import org.java_websocket.server.WebSocketServer;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.util.ArrayList;

public class ServerManager
{
    public static void main(String[] args)
    {
        String host = "localhost";
        int port = 8887;

        WebSocketServer server = new SimpleServer(new InetSocketAddress(host, port));
        server.run();
    }
}
