package com.kerrishaus.portal.servermanager.servers;

import com.kerrishaus.portal.servermanager.utility.FileUtility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Server
{
    protected String directory = null;

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
