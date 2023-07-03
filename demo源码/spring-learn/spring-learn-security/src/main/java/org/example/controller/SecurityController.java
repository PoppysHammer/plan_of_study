package org.example.controller;

import com.alibaba.fastjson2.JSONObject;
import org.example.entity.TestEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
public class SecurityController {

    @PostMapping("/test/1")
    public String abc(@ModelAttribute TestEntity map) {

        return JSONObject.toJSONString(map);
    }

    @PostMapping("/test/2")
    public String bcd(TestEntity map) {

        return JSONObject.toJSONString(map);
    }
}
