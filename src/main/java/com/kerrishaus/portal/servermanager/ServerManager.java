package com.kerrishaus.portal.servermanager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;

public class ServerManager
{
    public static File workingDirectory  = new File(System.getProperty("user.home") + "/.portal/servermanager");
    protected     File configurationFile = new File(ServerManager.workingDirectory.toPath() + "/config.json");
    protected JSONObject configuration;

    public ServerManager() throws IOException
    {
        System.out.println("Starting ServerManager...");

        try
        {
            if (!this.configurationFile.exists())
            {
                System.out.println("Configuration file does not exist, creating one...");

                if (!ServerManager.workingDirectory.mkdirs())
                    throw new IOException("Failed to create working directories for configuration file.");
                else
                    System.out.println("Created working directory.");

                if (this.configurationFile.createNewFile())
                    System.out.println("Configuration file created: " + this.configurationFile.getName());
                else
                    System.out.println("Configuration file already exists? I don't think this should be possible.");
            }
            else if (!this.configurationFile.canRead() || !this.configurationFile.canWrite())
                throw new IOException("Cannot read/write to configuration file.");
            else
                System.out.println("Configuration file exists and is read/writable. Location: " + this.configurationFile.getAbsolutePath());

            System.out.println("Loading configuration...");

            // this will throw JSONException if it fails
            this.configuration = new JSONObject(Files.readString(this.configurationFile.toPath()));
        }
        catch (Exception exception)
        {
            throw new IOException("Failed to create or load configuration file: " + exception.getMessage());
        }

        try
        {
            JSONArray servers = this.configuration.getJSONArray("servers");

            for (Object o: servers.toList())
            {
                System.out.println(o.toString());
            }
        }
        catch (Exception exception)
        {
            throw new JSONException("Failed to servers from configuration.");
        }

        System.out.println("ServerManager is ready.");
    }

    public static void main(String[] args) throws IOException
    {
        ServerManager sm = new ServerManager();
    }
}
