package io.ehcache.demo.Ehcache.controller;


import io.ehcache.demo.Ehcache.service.NumberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/number",consumes = MediaType.APPLICATION_JSON_VALUE)
public class NumberController {

    @Autowired
    public NumberService numberService;

    public String getSquare(@PathVariable Long number){
        log.info("Calling NumberService to get the square of number {}", number);
        return String.format("{\"square\": %s}", numberService.square(number));
    }
}
