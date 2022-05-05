package com.kerrishaus.portal.servermanager.servers.minecraft;

import com.kerrishaus.portal.servermanager.utility.FileUtility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MinecraftServer extends Server
{
    private String gameVersion = "1.18.2";
    private String software = "Paper";

    public MinecraftServer()
    {
        super();

        this.setDirectory("/users/kennymccormick/servers/minecraft");

        try
        {
            for (File file : getDirectoryContents())
            {
                System.out.println(file.getName());
            }
        }
        catch (IOException e)
        {
            System.out.println("Exception occurred gathering file information." + e.getMessage());
        }
    }

    public ArrayList<File> getDirectoryContents() throws IOException
    {
        return FileUtility.scanDirectory(this.directory);
    }
}
