package org.emirozturk;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.nio.file.Paths;

public class FileOps {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static Squad readFile(String filepath) {
        try {
            return mapper.readValue(new File(getFilePath(filepath)), Squad.class);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public static void writeFile(Squad squad, String filepath) {
        try {
            mapper.writeValue(new File(getFilePath(filepath)), squad);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static String getFilePath(String filename) {
        File currentDirFile = new File(".");
        String helper = currentDirFile.getAbsolutePath();
        return Paths.get(helper.substring(0, helper.length() - 1), "Uygulama3", filename).toString();
    }
}