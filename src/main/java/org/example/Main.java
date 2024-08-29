package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Starting JSON parsing");

        City city = City.fromJson("city.json");
        if (city != null) {
            logger.info("Successfully parsed JSON");
            city.saveToXML("city.xml");
            logger.info("XML saved successfully");
        } else {
            logger.error("Failed to parse JSON");
        }

        logger.info("Starting JSON parsing for city-error.json");
        City erroneousCity = City.fromJson("city-error.json");
        if (erroneousCity != null) {
            logger.info("Successfully parsed erroneous JSON");
            erroneousCity.saveToXML("city-error.xml");
            logger.info("Erroneous XML saved successfully");
        } else {
            logger.error("Failed to parse erroneous JSON");
        }
    }
}
