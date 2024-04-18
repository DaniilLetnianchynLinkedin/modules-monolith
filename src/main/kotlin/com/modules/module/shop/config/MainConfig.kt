package com.modules.module.shop.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
@ComponentScan(basePackages = ["com.modules.module.shop.core", "com.modules.module.shop.contracts"])
class MainConfig {

    @Bean
    fun createRestTemplate() = RestTemplate()
}