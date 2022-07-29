package io.ehcache.demo.Ehcache.utils;

import lombok.extern.slf4j.Slf4j;
import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;

@Slf4j
public class CacheEventLogger implements CacheEventListener<Object, Object> {
    @Override
    public void onEvent(CacheEvent<?, ?> cacheEvent) {
        log.info("Cached element key:{} Cached element old value:{} Cached element new value:{}"
                , cacheEvent.getKey(), cacheEvent.getOldValue(), cacheEvent.getNewValue());
    }
}