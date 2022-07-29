package io.ehcache.demo.Ehcache.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Here we annotated method with Cacheable do that Spring
 * will handle the caching. As a result of this annotation,
 * Spring will create a proxy of the NumberService to intercept
 * calls to the square method and call Ehcache.
 */
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
