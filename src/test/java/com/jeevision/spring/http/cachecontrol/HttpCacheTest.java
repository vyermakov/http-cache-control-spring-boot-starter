package com.jeevision.spring.http.cachecontrol;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = TestApplication.class)
public class HttpCacheTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Test
    public void testHttpCacheAnnotationAddsPublicCacheHeader() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mockMvc.perform(get("/test/cache"))
                .andExpect(status().isOk())
                .andExpect(header().string("Cache-Control", "public, max-age=300"));
    }

    @Test
    public void testHttpCacheAnnotationAddsPrivateCacheHeader() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mockMvc.perform(get("/test/private-cache"))
                .andExpect(status().isOk())
                .andExpect(header().string("Cache-Control", "private, max-age=600"));
    }

    @Test
    public void testNoCacheHeaderWhenAnnotationNotPresent() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mockMvc.perform(get("/test/no-cache"))
                .andExpect(status().isOk())
                .andExpect(header().doesNotExist("Cache-Control"));
    }
}