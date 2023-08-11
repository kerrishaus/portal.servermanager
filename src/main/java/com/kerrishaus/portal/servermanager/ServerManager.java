package com.kerrishaus.portal.servermanager;

import com.kerrishaus.portal.servermanager.servers.minecraft.MinecraftServer;
import com.kerrishaus.portal.servermanager.websockets.WebSocketServer;

import java.io.*;
import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.Scanner;

// https://stackoverflow.com/questions/18903549/writing-to-inputstream-of-a-java-process
// https://stackoverflow.com/questions/5711084/java-runtime-getruntime-getting-output-from-executing-a-command-line-program
// https://stackoverflow.com/questions/12869175/run-another-java-program-from-within-a-java-program-and-get-outputs-send-inputs

public class ServerManager
{
    public static void main(String[] args) throws IOException, InterruptedException
    {
        ProcessBuilder pb = new ProcessBuilder("java", "-jar", "BuildTools.jar");
        pb.directory(new File("/Users/kennymccormick/IdeaProjects/BuildTools/"));
        pb.redirectErrorStream();

        InputStream is = null;
        try {

            Process process = pb.start();
            is = process.getInputStream();

            int value;
            while ((value = is.read()) != -1) {

                char inChar = (char)value;
                System.out.print(inChar);

            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
