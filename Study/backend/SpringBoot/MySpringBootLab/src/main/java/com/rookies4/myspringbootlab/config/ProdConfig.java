package com.rookies4.myspringbootlab.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("prod") // 프로파일이 prod인 경우에만 활성화
@Configuration
public class ProdConfig {

    @Bean
    public MyEnvironment myEnvironment() {
        return MyEnvironment.builder()
                .mode("운영환경")
                .build();
    }
}
