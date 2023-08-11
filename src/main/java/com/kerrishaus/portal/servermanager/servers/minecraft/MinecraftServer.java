package com.kerrishaus.portal.servermanager.servers.minecraft;

import com.kerrishaus.portal.servermanager.servers.Server;

import java.io.File;
import java.io.IOException;

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
}
