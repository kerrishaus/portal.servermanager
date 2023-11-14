package com.kerrishaus.portal.servermanager;

import com.kerrishaus.portal.servermanager.servers.Server;

import java.io.*;

public class ServerManager
{
    public File workingDirectory = new File(System.getProperty("user.home") + "/.portal/servermanager");
    public File serversDirectory = new File(this.workingDirectory + "/servers");

    public File configuration    = this.workingDirectory;

    public Server[] servers;

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
        }
        catch(IOException exception)
        {
            System.out.println("ERROR: Failure prepping working directory: " + exception.getMessage());
        }

        System.out.println("ServerManager is ready.");
    }

    public static void main(String[] args) throws Exception
    {
        boolean runOnUnsupportedPlatforms = false;

        if (args.length > 0)
            for (String var : args)
            {
                if (var.equalsIgnoreCase("runOnUnsupportedPlatforms"))
                    runOnUnsupportedPlatforms = true;
            }

        if (!runOnUnsupportedPlatforms)
        {
            final String platform = System.getProperty("os.name").toLowerCase();

            final boolean isLinux = (platform.contains("nix") ||
                                     platform.contains("nux") ||
                                     platform.contains("aix"));

            if (!isLinux)
                throw new Exception("Unsupported platform: " + platform);
        }

        ServerManager manager = new ServerManager();
    }
}
