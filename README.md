# HTTP Cache Control Spring Boot Starter

A simple Spring Boot starter that provides the `@HttpCache` annotation to easily add HTTP cache headers to your REST controller responses.

## Usage

1. Add the dependency to your `pom.xml`:
   ```xml
   <dependency>
       <groupId>com.jeevision.spring.http</groupId>
       <artifactId>cache-control</artifactId>
       <version>1.0.2</version>
   </dependency>
   ```

2. Annotate your REST controller methods:
   ```java
   @RestController
   public class MyController {
       
       @HttpCache
       @GetMapping("/api/data")
       public String getData() {
           return "ok";
       }
   }
   ```

3. The response will automatically include `Cache-Control: public, max-age=300` header.

## Annotation Properties

- `cachePublic` (boolean, default: true) - Sets "public" or "private" in Cache-Control
- `maxAgeSeconds` (int, default: 300) - Sets the max-age value in seconds