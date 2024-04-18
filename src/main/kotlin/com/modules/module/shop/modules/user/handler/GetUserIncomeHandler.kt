package com.modules.module.shop.modules.user.handler

import com.modules.module.shop.contracts.user.GetUserIncomeCommand
import com.modules.module.shop.contracts.user.GetUserIncomePayload
import com.modules.module.shop.contracts.user.UserIncomeResult
import com.modules.module.shop.core.handler.InternalHandler
import com.modules.module.shop.modules.user.UserService
import org.springframework.stereotype.Component

@Component
class GetUserIncomeHandler<P : GetUserIncomePayload?, R : UserIncomeResult?>(
  private val userService: UserService
) : InternalHandler<GetUserIncomePayload, UserIncomeResult>() {
    override val type: String = GetUserIncomeCommand.name

    override fun handle(payload: GetUserIncomePayload?): UserIncomeResult? {
        return userService.getUserIncome(payload!!.id)
    }
}