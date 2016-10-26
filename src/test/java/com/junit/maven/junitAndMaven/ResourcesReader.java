package com.junit.maven.junitAndMaven;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Andrii_Grygoruk on 10/21/2016.
 */
public class ResourcesReader {
    String result = "";
    InputStream inputStream;

    public String getStackArgument(String arg) throws IOException{
        String argument = "";
        try{
            Properties properties = new Properties();
            String fileLocation = "stack.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(fileLocation);
            if (inputStream != null){
                properties.load(inputStream);
            }else {
                throw new FileNotFoundException(fileLocation + " not found");
            }
            argument = properties.getProperty(arg);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            inputStream.close();
        }
        return argument;
    }

    public String getCalculatorArgument(String arg) throws IOException{
        String argument = "";
        try{
            Properties properties = new Properties();
            String fileLocation = "calculator.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(fileLocation);
            if (inputStream != null){
                properties.load(inputStream);
            }else {
                throw new FileNotFoundException(fileLocation + " not found");
            }
            argument = properties.getProperty(arg);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            inputStream.close();
        }
        return argument;
    }

}
