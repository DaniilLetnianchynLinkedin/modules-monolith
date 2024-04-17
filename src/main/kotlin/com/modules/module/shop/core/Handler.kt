package com.modules.module.shop.core

interface Handler<P : Payload, R : Result?> {
    val type: String
    val module: Module
    fun handle(payload: P?): R?
}