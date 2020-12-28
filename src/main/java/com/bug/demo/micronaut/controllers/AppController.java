package com.bug.demo.micronaut.controllers;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/health")
public class AppController {

    @Get
    public String isItHealthy() {
        return "Healthy AF";
    }
}
