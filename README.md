# HTTP Cache Control Spring Boot Starter

A simple Spring Boot starter that provides the `@HttpCache` annotation to easily add HTTP cache headers to your REST controller responses.

## Usage

1. Add the dependency to your `pom.xml`:
   ```xml
   <dependency>
       <groupId>com.jeevision.spring.http</groupId>
       <artifactId>cache-control</artifactId>
       <version>0.0.1-SNAPSHOT</version>
   </dependency>
   ```

2. Annotate your REST controller methods:
   ```java
   @RestController
   public class MyController {
       
       @HttpCache(cachePublic = true, maxAgeSeconds = 300)
       @GetMapping("/api/data")
       public String getData() {
           return "ok";
       }
   }
   ```

3. The response will automatically include `Cache-Control: public, max-age=300` header.

## Annotation Properties

- `cachePublic` (boolean, default: true) - Sets "public" or "private" in Cache-Control
- `maxAgeSeconds` (int, default: 0) - Sets the max-age value in seconds