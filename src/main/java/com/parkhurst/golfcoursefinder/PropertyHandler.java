package com.parkhurst.golfcoursefinder;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

/**
 * @author John parkhurst
 * @brief handles the properties files
 */
public class PropertyHandler {
    String result = "";
    InputStream inputStream;
    public String getPropValues() throws IOException {
        try {
            Properties prop = new Properties();
            String propFileName = "/config.properties";


            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            // get the property value and print it out
            String user = prop.getProperty("username");
            String pass = prop.getProperty("password");
            System.out.println(this.result+ " by user=" + user);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return this.result;
    }

}
