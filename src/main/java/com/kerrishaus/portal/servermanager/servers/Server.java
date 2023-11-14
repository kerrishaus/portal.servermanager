package com.kerrishaus.portal.servermanager.servers;

import com.kerrishaus.portal.servermanager.utility.FileUtility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Server
{
    public boolean autostart      = false;

    protected boolean running     = false;
    protected String  directory   = null;
    protected String  name        = null;
    protected String  description = null;
    protected Integer ownerId     = null;

    public Server(final String directory)
    {
        this.setDirectory(directory);
    }

    public void setDirectory(final String directory)
    {
        this.directory = directory;
    }

    public String getDirectory()
    {
        return this.directory;
    }

    public ArrayList<File> getServerFiles() throws IOException
    {
        return FileUtility.scanDirectory(this.directory);
    }
}
