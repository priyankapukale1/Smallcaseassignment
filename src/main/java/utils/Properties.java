package utils;

public class Properties {

    private static final PropertiesReader propertiesReader = new PropertiesReader();
    public static final String FLIPKART_BASE_URL = propertiesReader.getFlipKartBaseUrl();
    public static final String AMAZON_BASE_URL = propertiesReader.getAmazonBaseUrl();
    public static final String PRODUCT_NAME = propertiesReader.getProductName();



}
