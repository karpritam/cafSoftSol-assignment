package com.psk.config_file_parser.Service;

import com.psk.config_file_parser.Util.ConfigFileParser;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
public class ConfigService {
    private final Map<String, Map<String, Object>> configData;

    public ConfigService() throws IOException {
        this.configData = ConfigFileParser.parse(
                "src/main/resources/config/app-config.txt"
        );
    }

    public Map<String, Object> getBySection(String section) {
        if (!configData.containsKey(section)) {
            throw new RuntimeException("Section not found");
        }
        return configData.get(section);
    }
}

