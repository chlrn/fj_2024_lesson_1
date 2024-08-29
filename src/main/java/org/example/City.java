package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {
    private String slug;
    private Coords coords;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Coords {
        private double lat;
        private double lon;
    }

    public static City fromJson(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File(filePath), City.class);
        } catch (IOException e) {
            System.err.println("Error parsing JSON file: " + e.getMessage());
            return null;
        }
    }

    public String toXML() {
        return "<City>\n" +
                "    <slug>" + slug + "</slug>\n" +
                "    <coords>\n" +
                "        <lat>" + coords.getLat() + "</lat>\n" +
                "        <lon>" + coords.getLon() + "</lon>\n" +
                "    </coords>\n" +
                "</City>";
    }

    public void saveToXML(String filePath) {
        try (PrintWriter out = new PrintWriter(filePath)) {
            out.println(toXML());
        } catch (IOException e) {
            System.err.println("Error saving XML file: " + e.getMessage());
        }
    }
}
