package by.cryptoidf.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableFeignClients("by.cryptoidf.client")
@ComponentScan("by.cryptoidf")
@EnableScheduling
public class AppConfig {
}
