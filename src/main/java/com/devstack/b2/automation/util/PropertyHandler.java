package com.devstack.b2.automation.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyHandler {
    private static Properties properties = new Properties();

    static {
        try(InputStream inputStream = PropertyHandler.class.getClassLoader().
                getResourceAsStream("config.properties")){
            if (inputStream==null){
                System.out.println("config file not found");
            }
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
