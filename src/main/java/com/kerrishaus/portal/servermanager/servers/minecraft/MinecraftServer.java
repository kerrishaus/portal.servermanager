package com.kerrishaus.portal.servermanager.servers.minecraft;

import com.kerrishaus.portal.servermanager.servers.Server;
import com.kerrishaus.portal.servermanager.servers.ServerLog;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;

public class MinecraftServer extends Server
{
    private String gameVersion = null;
    private String software = null;

    public MinecraftServer()
    {
        super();

        this.setDirectory("/users/kennymccormick/servers/minecraft");

        try
        {
            System.out.println("Loading server configuration...");

            File serverManagerConfiguration = new File(this.directory + "/.portal/server.conf");

            // if the .portal directory doesn't exist
            if (serverManagerConfiguration.getParentFile() == null)
                if (!serverManagerConfiguration.getParentFile().mkdirs())
                    throw new IOException("Failed to create parent directories for configuration file.");

            if (serverManagerConfiguration.createNewFile())
                System.out.println("File created: " + serverManagerConfiguration.getName());
            else
                System.out.println("File already exists.");

            System.out.println("Loading server files...");

            for (File file : getServerFiles())
            {
                String filename = file.getName();

                if (filename.indexOf(".jar") > 0)
                {
                    System.out.println("Server Software: " + filename);
                    this.software = filename;
                }
            }
        }
        catch (IOException e)
        {
            System.out.println("Exception occurred gathering server information: " + e.getMessage());
        }
    }

    public HashSet<String> getWorlds()
    {
        return new HashSet<>();
    }

    public HashSet<String> getPlugins()
    {
        return new HashSet<>();
    }

    public boolean installPlugin(String pluginUrl)
    {
        return false;
    }

    public boolean hasPlugins()
    {
        return false;
    }

    public HashSet<ServerLog> getLogs()
    {
        return new HashSet<>();
    }
}
