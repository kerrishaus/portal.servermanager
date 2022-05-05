package com.kerrishaus.portal.servermanager;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

public class Server
{
    private String directory = null;

    public Server()
    {

    }

    // Sets the working directory for the server to manage.
    // Returns:
    //  True on success, false otherwise.
    public boolean SetDirectory(final String directory)
    {
        this.directory = directory;

        return true;
    }

    public JSONObject getDirectoryContents() throws IOException
    {
        JSONObject obj = new JSONObject();
        ArrayList<String> files = new ArrayList<String>();

        Files.list(new File(this.directory).toPath())
                .forEach(path -> {
                    files.add(path.toString());
                });

        obj.put("files", files);
        return obj;
    }
}
