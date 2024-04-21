package com.modules.module.shop.modules.product.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.IDENTITY
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "product")
data class Product(
    @Id
    @GeneratedValue(strategy = IDENTITY)
    var id: Long = 0,
    @Column
    var name: String,
    @Column
    var price: Double
) {
    constructor() : this(0, "", 0.0)
}
