package com.jeevision.spring.http.cachecontrol;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @HttpCache(cachePublic = true, maxAgeSeconds = 300)
    @GetMapping("/test/cache")
    public ResponseEntity<String> getCachedData() {
        return ResponseEntity.ok("cached data");
    }

    @HttpCache(cachePublic = false, maxAgeSeconds = 600)
    @GetMapping("/test/private-cache")
    public ResponseEntity<String> getPrivateCachedData() {
        return ResponseEntity.ok("private cached data");
    }

    @GetMapping("/test/no-cache")
    public ResponseEntity<String> getNoCacheData() {
        return ResponseEntity.ok("no cache data");
    }
}