package com.kerrishaus.portal.servermanager.utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

public final class FileUtility
{
    public static final ArrayList<File> scanDirectory(final String directoryPath) throws IOException
    {
        ArrayList<File> files = new ArrayList<>();

        Files.list(new File(directoryPath).toPath())
                .forEach(path -> {
                    files.add(new File(path.toString()));
                });

        return files;
    }
}
