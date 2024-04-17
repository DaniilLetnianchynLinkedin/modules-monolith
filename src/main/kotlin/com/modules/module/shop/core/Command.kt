package com.modules.module.shop.core

interface Command<P : Payload, R : Result?> {
    val type: String
}