package com.modules.module.shop.core

import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.LoggerFactory
import org.springframework.http.HttpEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/cross-module-communication")
@RestController
class CrossModuleCommunicationController(
    val mediator: Mediator,
    val objectMapper: ObjectMapper
) {

    @PostMapping
    fun handleCommand(
        @RequestParam("type") type: String,
        httpEntity: HttpEntity<String>
    ): IResult? {
        logger.info("Received crossmodulecommunication request with type $type")
        val json = httpEntity.body
        val command = mediator.getCommandByType(type)
        val payload = objectMapper.readValue(json, command?.payloadType())
        return mediator.send(command!!, payload)
    }

    companion object {
        val logger = LoggerFactory.getLogger(CrossModuleCommunicationController::class.java)
    }
}