package com.psk.config_file_parser.util;

import com.psk.config_file_parser.Util.ConfigFileParser;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConfigFileParserTest {
    @Test
    void shouldParseConfigFile() throws Exception {
        Map<String, Map<String, Object>> data =
                ConfigFileParser.parse("src/main/resources/config/app-config.txt");

        assertTrue(data.containsKey("Order Service"));
        assertEquals("https://orbroker.in",
                data.get("Order Service").get("broker"));
    }
}
