package com.rookies4.myspringboot.config;

import com.rookies4.myspringboot.config.vo.CustomVO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("prod") // 프로파일이 prod인 경우에만 활성화
@Configuration
public class ProdConfig {
    @Bean
    public CustomVO customVO(){
        return CustomVO.builder() //CustomV0Builder
                .mode("운영모드")
                .rate(1.5)
                .build(); //CustomV0
    }
}
