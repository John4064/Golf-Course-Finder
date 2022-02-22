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
            // get the property value and save it 0 golfURL 1 KEY 2 SECRET KEY 3 zipURL
            propArr[0]= prop.getProperty("GOLFURL");
            propArr[1]= prop.getProperty("APIKEY");
            propArr[2] = prop.getProperty("SECRETKEY");
            propArr[3] = prop.getProperty("zipURL");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return propArr;
    }

}
