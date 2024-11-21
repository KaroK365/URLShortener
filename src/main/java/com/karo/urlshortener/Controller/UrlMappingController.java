package com.karo.urlshortener.Controller;

import com.karo.urlshortener.Service.UrlMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gg")
public class UrlMappingController {
    @Autowired
    private UrlMappingService urlMappingService;

    @PostMapping("/generate")
    public ResponseEntity<String> generateShortUrl(@RequestBody String originalUrl) {
        String shortUrl = urlMappingService.generateShortUrl(originalUrl);
        urlMappingService.saveUrlMapping(originalUrl, shortUrl);
        return ResponseEntity.ok(shortUrl);
    }

    @GetMapping("/original/{shortUrl}")
    public ResponseEntity<String> getOriginalUrl(@PathVariable String shortUrl) {
        String originalUrl = urlMappingService.getOriginalUrl(shortUrl);
        return ResponseEntity.ok(originalUrl);
    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity<String> redirectToOriginalUrl(@PathVariable String shortUrl) {
        String originalUrl = urlMappingService.getOriginalUrl(shortUrl);
        return ResponseEntity.status(302).header("Location", originalUrl).build();
    }
}
