package com.karo.urlshortener.Repository;

import com.karo.urlshortener.Entity.UrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlMappingRepository extends JpaRepository<UrlMapping, Integer> {
    UrlMapping findByOriginalUrl(String originalUrl);
    UrlMapping findByShortUrl(String shortUrl);
}
