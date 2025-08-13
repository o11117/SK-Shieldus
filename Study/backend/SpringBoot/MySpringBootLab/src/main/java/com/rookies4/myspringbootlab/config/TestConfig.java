package com.rookies4.myspringbootlab.config;

import lombok.Builder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("test") // 프로파일이 prod인 경우에만 활성화
@Configuration
public class TestConfig {

    @Bean
    public MyEnvironment myEnvironment() {
        return MyEnvironment.builder()
                .mode("테스트환경")
                .build();
    }
}
