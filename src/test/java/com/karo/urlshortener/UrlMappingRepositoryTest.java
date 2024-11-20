package com.karo.urlshortener;


import com.karo.urlshortener.Entity.UrlMapping;
import com.karo.urlshortener.Repository.UrlMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UrlMappingRepositoryTest {
    @Autowired
    private UrlMappingRepository urlMappingRepository;

    public void testSaveandFindByShortUrl() {
        UrlMapping urlMapping = new UrlMapping();
        urlMapping.setShortUrl("short");
        urlMapping.setOriginalUrl("original");
        urlMapping.setCreatedAt(LocalDateTime.now());

        UrlMapping saved = urlMappingRepository.save(urlMapping);
        UrlMapping found = urlMappingRepository.findByShortUrl("short");

        assertThat(found).isNotNull();
        assertThat(found.getOriginalUrl()).isEqualTo("original");
        assertThat(found.getShortUrl()).isEqualTo("short");
    }
}
