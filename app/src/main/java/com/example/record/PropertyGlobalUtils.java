package com.example.record;

import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;

/**
 * renamed from BuildProperties
 */
public class PropertyGlobalUtils {
    private final Properties properties;

    public boolean isEmpty() {
        return properties.isEmpty();
    }

    public int size() {
        return properties.size();
    }

    public Collection<Object> values() {
        return properties.values();
    }

    public static PropertyGlobalUtils newInstance() throws IOException {
        return new PropertyGlobalUtils();
    }

    private PropertyGlobalUtils() throws IOException {
        properties = new Properties();  
        properties.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
    }  
  
    public String getProperty(final String name, final String defaultValue) {
        return properties.getProperty(name, defaultValue);  
    }

  

}  