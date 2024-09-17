package com.rosoa0475.limits.configuration;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "limits-service") //msaproject.() ()와 일치하는 형태를 변수에 할당 이때 setter 필요함
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Configuration {
    private int minimum;
    private int maximum;
}
