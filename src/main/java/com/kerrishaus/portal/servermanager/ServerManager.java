package com.kerrishaus.portal.servermanager;

import com.kerrishaus.portal.servermanager.servers.minecraft.MinecraftServer;
import com.kerrishaus.portal.servermanager.websockets.WebSocketServer;

import java.io.*;
import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.Scanner;

// https://stackoverflow.com/questions/18903549/writing-to-inputstream-of-a-java-process
// https://stackoverflow.com/questions/5711084/java-runtime-getruntime-getting-output-from-executing-a-command-line-program

public class ServerManager
{
    public static void main(String[] args) throws IOException, InterruptedException
    {
        ProcessBuilder builder = new ProcessBuilder("java", "-Xms1G", "-Xmx6G", "-Dlog4j.configurationFile=log4j2.xml", "-jar", "paper-1.18.2-277.jar", "nogui");
        builder.directory(new File("/Users/kennymccormick/servers/minecraft"));
        Process process = builder.start();

        OutputStream stdin = process.getOutputStream();
        InputStream stdout = process.getInputStream();

        Scanner scanner = new Scanner(stdout);
        while (scanner.hasNextLine())
        {
            System.out.println(scanner.nextLine());
        }

        /*
        try
        {
            ProcessBuilder builder = new ProcessBuilder("java", "-Xms1G", "-Xmx6G", "-Dlog4j.configurationFile=log4j2.xml", "-jar", "Users/kennymccormick/servers/minecraft/paper.jar", "nogui");
            Process process = builder.start();

            OutputStream stdin = process.getOutputStream();
            InputStream stdout = process.getInputStream();

            //BufferedReader reader = new BufferedReader(new InputStreamReader(stdout));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(stdin));

            writer.write("Sup buddy\n");
            writer.flush();

            Scanner scanner = new Scanner(stdout);
            while (scanner.hasNextLine())
            {
                System.out.println(scanner.nextLine());
            }
        }
        catch (IOException exception)
        {
            System.out.println("Exception: " + exception.getMessage());

            for (StackTraceElement message : exception.getStackTrace())
                System.out.println(message);
        }
         */

        /*
        //MinecraftServer s = new MinecraftServer();

        String host = "localhost";
        int port = 8887;

        WebSocketServer server = new WebSocketServer(new InetSocketAddress(host, port));
        server.run();
        */
    }
}
