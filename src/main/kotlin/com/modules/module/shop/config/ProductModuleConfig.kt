package com.modules.module.shop.config

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@Profile("product | all")
@Configuration
@ComponentScan(basePackages = ["com.modules.module.shop.modules.product"])
class ProductModuleConfig {
}