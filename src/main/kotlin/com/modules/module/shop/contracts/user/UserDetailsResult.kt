package com.modules.module.shop.contracts.user

import com.modules.module.shop.core.IResult

class UserDetailsResult(
    val userName: String,
    val email: String
) : IResult