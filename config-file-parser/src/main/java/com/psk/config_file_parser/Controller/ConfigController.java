package com.psk.config_file_parser.Controller;

import com.psk.config_file_parser.Service.ConfigService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/config")
public class ConfigController {
    private final ConfigService service;

    public ConfigController(ConfigService service) {
        this.service = service;
    }

    @GetMapping
    public Map<String, Object> getConfig(@RequestParam String section) {
        return service.getBySection(section);
    }
}
