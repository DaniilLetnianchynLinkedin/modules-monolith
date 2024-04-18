package com.modules.module.shop.config

import com.modules.module.shop.contracts.user.GetUserIncomeCommand
import com.modules.module.shop.core.IPayload
import com.modules.module.shop.core.IResult
import com.modules.module.shop.core.handler.CrossModuleHandler
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
//
@Profile("user | all")
@Configuration
@ComponentScan(basePackages = ["com.modules.module.shop.modules.user"])
class UserModuleConfig {
}

@Profile("!user & !all")
@Configuration
class HandlerConfig {

    @Bean
    fun initHandler(
        @Value("\${module.config.user.address}") address: String
    ) = CrossModuleHandler<IPayload, IResult>(
        type = GetUserIncomeCommand.name,
        address = address
    )
}