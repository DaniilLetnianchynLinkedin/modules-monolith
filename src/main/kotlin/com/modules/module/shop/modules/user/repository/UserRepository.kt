package com.modules.module.shop.modules.user.repository

import com.modules.module.shop.modules.user.domain.User
import org.springframework.data.repository.CrudRepository


interface UserRepository : CrudRepository<User, Long>