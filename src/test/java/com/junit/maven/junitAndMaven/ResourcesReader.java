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

    public String getResources() throws IOException{
        try{
            Properties properties = new Properties();
            String fileLocation = "data.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(fileLocation);

            if (inputStream != null){
                properties.load(inputStream);
            }else {
                throw new FileNotFoundException(fileLocation + " not found");
            }

            String arg1 = properties.getProperty("arg1");
            String arg2 = properties.getProperty("arg2");

            result = arg1 + " " + arg2;
            System.out.println(result);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            inputStream.close();
        }
        return result;
    }

}
