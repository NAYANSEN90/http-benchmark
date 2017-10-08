package com.example.springboot.undertow;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by stb.
 */
@RestController
public class RestApiController {

    @RequestMapping("/ping")
    String ping() {
        return "pong";
    }
}
