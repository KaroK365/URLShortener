package com.karo.urlshortener.Service;


import com.karo.urlshortener.Entity.UrlMapping;
import com.karo.urlshortener.Repository.UrlMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UrlMappingService {

    @Autowired
    private UrlMappingRepository urlMappingRepository;

    public String generateShortUrl(String originalUrl) {
        return UUID.randomUUID().toString().substring(0,6);
    }

    public UrlMapping saveUrlMapping(String originalUrl, String shortUrl) {
        UrlMapping urlMapping = new UrlMapping();
        urlMapping.setOriginalUrl(originalUrl);
        urlMapping.setShortUrl(shortUrl);
        return urlMappingRepository.save(urlMapping);
    }

    public String getOriginalUrl(String shortUrl) {
        UrlMapping urlMapping = urlMappingRepository.findByshortUrl(shortUrl);
        if(urlMapping != null) {
            return urlMapping.getOriginalUrl();
        }
        throw new IllegalArgumentException("Short Url Not Found");
    }
}
