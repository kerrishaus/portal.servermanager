package com.kerrishaus.portal.servermanager.utility;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

// https://stackoverflow.com/questions/18903549/writing-to-inputstream-of-a-java-process
// https://stackoverflow.com/questions/5711084/java-runtime-getruntime-getting-output-from-executing-a-command-line-program
// https://stackoverflow.com/questions/12869175/run-another-java-program-from-within-a-java-program-and-get-outputs-send-inputs

public class ProcessRunner
{
    public static boolean run(String directory, String[] args) throws IOException, InterruptedException
    {
        ProcessBuilder pb = new ProcessBuilder(args);
        pb.directory(new File(directory));
        pb.redirectErrorStream();

        InputStream is = null;
        try
        {
            Process process = pb.start();
            is = process.getInputStream();

            int value;
            while ((value = is.read()) != -1)
            {
                char inChar = (char)value;
                System.out.print(inChar);
            }
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }

        return true;
    }
}
