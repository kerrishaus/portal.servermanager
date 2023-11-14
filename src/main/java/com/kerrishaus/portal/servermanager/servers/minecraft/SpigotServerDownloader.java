package com.kerrishaus.portal.servermanager.servers.minecraft;

// Downloads BuildTools and builds the specified Spigot server jar.
public class SpigotServerDownloader extends ServerDownloader
{
    public SpigotServerDownloader()
    {
        super();
    }

    public boolean getBuildTools()
    {
        //download from https://hub.spigotmc.org/jenkins/job/BuildTools/lastBuild/

        return false;
    }
}
