package com.alex.development.tools.project.builder.common.lib;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.apache.commons.io.FileUtils;

public class FileUtil {
    
    private static final String[] JAR_EXTENSION = {"jar"};
    
    private static final boolean RECURSIVE_SUBDIR_FALSE = false;
    
    private static final String DEFAULT_ENCODING = StandardCharsets.UTF_8.name();
    
    public static void createDir(String path) throws IOException{
        File directory = new File(path);
        FileUtils.forceMkdir(directory);
    }

    public static void cleanDirectory(String path) throws IOException{
        File directory = new File(path);
        FileUtils.cleanDirectory(directory);
    }
    
    public static List<String> getSubDirectoryNames(String path){
        File directory = new File(path);
        String[] directories = directory.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir, name).isDirectory();
            }
        });
        return Arrays.asList(directories);
    }
    
    public static List<File> getJarFiles(String dirPath) throws IOException{
        File dir = new File(dirPath);
        Collection<File> collection = FileUtils.listFiles(dir, JAR_EXTENSION, RECURSIVE_SUBDIR_FALSE);
        return new ArrayList<>(collection);
    }
    
    public static void copyFile(String srcFilePath, String destFilePath) throws IOException{
        File srcFile = new File(srcFilePath);
        File destFile = new File(destFilePath);
        FileUtils.copyFile(srcFile, destFile);
    }
    
    public static void copyFileToDirectory(String srcFilePath, String destFilePath) throws IOException{
        File srcFile = new File(srcFilePath);
        File destDir = new File(destFilePath);
        FileUtils.copyFileToDirectory(srcFile, destDir);
    }
    
    //TODO Кодировка файла не работает
    public static void writeStringToFile(String fullFileName, String content) throws IOException{
        File file = new File(fullFileName);
        FileUtils.writeStringToFile(file, content, DEFAULT_ENCODING, false);
    }
    
}
