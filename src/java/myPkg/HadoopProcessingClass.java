/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myPkg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author raxton
 */
public class HadoopProcessingClass {
    
    protected String startprocess(String startProcess) {

        StringBuilder output = new StringBuilder();

        Process pStart;
        try {
            String[] envp = {"PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/games:/usr/local/games:/home/raxton/bin:/usr/local/java/jdk1.7.0_91/bin:/home/raxton/bin:/usr/local/java/jre1.8.0_66/bin:/usr/lib/jvm/java-7-openjdk-amd64/bin:/usr/local/hadoop/bin:/usr/local/hadoop/sbin:/usr/local/hive/bin:/usr/lib/sqoop/bin"};

            Runtime rtime = Runtime.getRuntime();
            pStart = rtime.exec(startProcess, envp);
           
            pStart.waitFor();

            BufferedReader reader = new BufferedReader(new InputStreamReader(pStart.getInputStream()));

            String line = "";
            while ((line = reader.readLine()) != null) {
                if (!line.contains("Warning")) {
                    output.append(line).append("<br/>");
                }
            }

        } catch (IOException | InterruptedException e) {
            System.out.print(e);
        }

        return output.toString();
    }
}
