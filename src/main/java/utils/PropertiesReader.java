package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

class PropertiesReader {
    private Properties prop = new Properties();

    PropertiesReader() {
        String environment = System.getProperty("env");
        String propertiesFilePath = environment + ".properties";
        InputStream inputStream;
        inputStream = getInputStream(propertiesFilePath);

        try {
            prop.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private InputStream getInputStream(String propertiesFilePath) {
        return this.getClass().getClassLoader().getResourceAsStream(propertiesFilePath);
    }

    String getFlipKartBaseUrl() {
        return prop.getProperty("flipkart_baseUrl");
    }


    String getAmazonBaseUrl() {
        return prop.getProperty("amazon_base_url");
    }

    String getProductName() {
        return prop.getProperty("prodct_name");
    }




}
