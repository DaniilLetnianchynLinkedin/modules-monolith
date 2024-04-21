package com.modules.module.shop.modules.user.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.IDENTITY
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "users")
class User(
    @Id
    @GeneratedValue(strategy = IDENTITY)
    var id: Long = 0,
    @Column
    var email: String,
    @Column(name = "sallary_income")
    var sallaryIncome: Int
) {
    constructor() : this(0, "", 0)
}