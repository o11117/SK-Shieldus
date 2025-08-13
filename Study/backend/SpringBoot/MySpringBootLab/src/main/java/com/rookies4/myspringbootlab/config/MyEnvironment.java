package com.rookies4.myspringbootlab.config;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Builder
@Getter
@ToString
public class MyEnvironment {
    private String mode;
}
