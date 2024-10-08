package com.rosoa0475.limits.controller;

import com.rosoa0475.limits.bean.Limits;
import com.rosoa0475.limits.configuration.Configuration;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LimitsController {

    private final Configuration configuration;

    @GetMapping("/limits")
    public Limits retrieveLimits(){
        //return new Limits(1, 1000);
        return new Limits(configuration.getMinimum(), configuration.getMaximum());
    }
}
