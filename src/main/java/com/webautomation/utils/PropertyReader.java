package com.webautomation.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    public static String getData(String key){
        FileInputStream fi = null;
        Properties properties = null;
        try {
            fi = new FileInputStream("src/main/resources/data.properties");
            properties = new Properties();
            properties.load(fi);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (fi != null) {
                    fi.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (properties != null) {
            return properties.getProperty(key);
        }

        return null;
    }
}
