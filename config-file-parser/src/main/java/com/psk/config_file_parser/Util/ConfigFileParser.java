package com.psk.config_file_parser.Util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ConfigFileParser {
    public static Map<String, Map<String, Object>> parse(String path) throws IOException {
        Map<String, Map<String, Object>> result = new HashMap<>();

        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        String currentSection = null;

        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;

            if (!line.contains("=")) {
                currentSection = line;
                result.putIfAbsent(currentSection, new HashMap<>());
            } else {
                String[] parts = line.split("=", 2);
                String key = parts[0].trim();
                String value = parts[1].trim();

                Object finalValue = value.contains(",")
                        ? Arrays.stream(value.split(","))
                        .map(String::trim)
                        .toList()
                        : value;

                result.get(currentSection).put(key, finalValue);
            }
        }
        return result;
    }
}
