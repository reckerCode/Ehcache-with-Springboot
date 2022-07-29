package io.ehcache.demo.Ehcache.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
public class NumberService {

    @Cacheable(value = "squareCache",
            key = "#number",
            condition = "#number>10")
    public BigDecimal square(Long number){
        BigDecimal bigDecimalSquare = BigDecimal.valueOf(number).multiply(BigDecimal.valueOf(number));
        log.info("Square of {} is {}",number,bigDecimalSquare);
        return bigDecimalSquare;
    }
}
