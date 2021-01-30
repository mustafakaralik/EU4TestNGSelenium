package com.cybertek.utilities;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * reads the properties file configuration.properties
 */
public class ConfigurationReader {

    private static Properties properties; //object okuduğumuz prpoperties içindeki verileri çekmeye yarıcak
                //Properties Class içinde olusturlan properties objesi--
    static {

        try {
            // what file to read-->//when we right click and copy path only cofig.prop adresini buraya alıyoruz
            String path = "configuration.properties";//dikkat edilirse direk EU4Test altında ana bir dosya o yüzden path kısa
            // read the file into java, finds the file using the string path
            FileInputStream input = new FileInputStream(path);
            // properties --> class that store properties in key / value format
            properties = new Properties();
            // the values from the file input is loaded / fed in to the properties object
            properties.load(input);
            input.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    //properties objectini oluşturma nedenimiz sadece bu metod içine çağırabilmek OOP consept ana amacı
    public static String get(String keyName) { //bu methodun görevi properties.file içindeki keyName leri properties objecti içine almak
    //keyname burada config.properties içindekii browser,url,driver_username vs
        return properties.getProperty(keyName);
    //son satırda properties.file içindeki keyName leri properties objecti içine alıyor-with getProperty
    }

}