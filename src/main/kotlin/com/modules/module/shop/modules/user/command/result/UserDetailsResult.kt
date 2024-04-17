package com.modules.module.shop.modules.user.command.result

import com.modules.module.shop.core.Result

class UserDetailsResult(
    val userName: String,
    val email: String
) : Result