package com.parkhurst.golfcoursefinder;
import java.io.FileInputStream;
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

    public static String[] getPropValues() throws IOException {
        String[] propArr = new String[5];
        try (InputStream input = new FileInputStream("src/main/resources/com/parkhurst/golfcoursefinder/config.properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println(prop.getProperty("GOLFURL"));
            System.out.println(prop.getProperty("APIKEY"));
            System.out.println(prop.getProperty("SECRETKEY"));
            System.out.println(prop.getProperty("zipURL"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }


        return propArr;
    }

}
