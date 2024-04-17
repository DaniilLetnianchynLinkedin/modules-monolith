package com.modules.module.shop.core

import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Service

@Service
class Mediator(
    private val commands: MutableList<Command<Payload, Result>>,
    private val handlers: MutableList<Handler<Payload, Result>>
) {

    @PostConstruct
    fun init() {
        commands.size
    }

    fun send(command: Command<Payload, Result>, payload: Payload?): Result? {
        return handlers.firstOrNull { it.type == command.type }?.let {
            return it.handle(payload)
        }
    }

    fun getCommandByType(type: String): Command<Payload, Result>? {
        return commands.firstOrNull { it.type == type }
    }
}