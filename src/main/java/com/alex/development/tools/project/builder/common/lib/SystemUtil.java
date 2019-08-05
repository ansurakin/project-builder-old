package com.alex.development.tools.project.builder.common.lib;

import java.io.File;

public class SystemUtil {
    
    //Разделитель пути к файлам
    public static final String pathSeparator = File.separator;

    //Откуда запущена команда
    public static String getCurrentDir() {
       return System.getProperty("user.dir");
    }
    
}
