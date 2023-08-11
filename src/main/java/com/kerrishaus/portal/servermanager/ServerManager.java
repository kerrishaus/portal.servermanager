package com.kerrishaus.portal.servermanager;

import java.io.*;

public class ServerManager
{
    public    File workingDirectory = new File(System.getProperty("user.home") + "/.portal/servermanager");
    protected File configuration    = this.workingDirectory;

    public ServerManager() throws IOException
    {
        System.out.println("Starting ServerManager...");

        try
        {
            if (!this.configuration.exists())
            {
                System.out.println("Working directory does not exist, creating it.");

                if (!this.configuration.mkdirs())
                    throw new IOException("Failed to create parent directories for configuration file.");
                else
                    System.out.println("Created working directory");
            }
            else
                System.out.println("Working directory exists: " + this.workingDirectory.getAbsolutePath());

            System.out.println("Loading configuration");

            if (configuration.createNewFile())
                System.out.println("Configuration file created: " + configuration.getName());
            else
                System.out.println("Configuration file already exists.");
        }
        catch(IOException exception)
        {
            System.out.println("ERROR: Failure loading config: " + exception.getMessage());
        }

        System.out.println("ServerManager is ready.");
    }

    public static void main(String[] args) throws IOException
    {
        ServerManager sm = new ServerManager();
    }
}
