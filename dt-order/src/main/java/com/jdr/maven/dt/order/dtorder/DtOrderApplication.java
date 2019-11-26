package com.jdr.maven.dt.order.dtorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DtOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DtOrderApplication.class, args);
    }

    @Bean
    public RestTemplate initRestTemplate() {
        return new RestTemplate();
    }
}
