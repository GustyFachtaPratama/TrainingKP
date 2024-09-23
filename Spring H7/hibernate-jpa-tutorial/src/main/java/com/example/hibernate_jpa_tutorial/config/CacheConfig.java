package com.example.hibernate_jpa_tutorial.config;

import org.ehcache.jsr107.EhcacheCachingProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cache.jcache.JCacheCacheManager;

import javax.cache.CacheManager;
import javax.cache.Caching;
import java.net.URISyntaxException;

@Configuration
public class CacheConfig {

    @Bean
    public CacheManager cacheManager() throws URISyntaxException {
        EhcacheCachingProvider cachingProvider = (EhcacheCachingProvider) Caching.getCachingProvider();
        return cachingProvider.getCacheManager(
                getClass().getResource("../../resources/ehcache.xml").toURI(),
                getClass().getClassLoader()
        );
    }

    @Bean
    public org.springframework.cache.CacheManager springCacheManager(CacheManager cacheManager) {
        return new JCacheCacheManager(cacheManager);
    }
}
