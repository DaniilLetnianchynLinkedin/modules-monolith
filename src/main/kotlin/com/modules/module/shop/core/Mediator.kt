package com.modules.module.shop.core

import com.modules.module.shop.contracts.Command
import com.modules.module.shop.core.handler.CrossModuleHandler
import com.modules.module.shop.core.handler.Handler
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class Mediator(
    private val restTemplate: RestTemplate,
    private val commands: List<Command<IPayload, IResult>>,
    private val handlers: List<Handler<IPayload, IResult>>
) {

    fun send(command: Command<IPayload, IResult>, payload: IPayload?): IResult? {
        logger.info("Sending command ${command.type}")
        return handlers.firstOrNull { it.type == command.type }?.let {
            logger.info("Handler found for command ${command.type} protocol ${it.protocol}")
            when (it.protocol) {
                CommunicationProtocols.INTERNAL -> it.handle(payload)
                CommunicationProtocols.HTTP -> handleWithHttpProtocol(
                    command,
                    it as CrossModuleHandler,
                    payload
                )
            }
        } ?: throw IllegalStateException("Handler not found for command ${command.type}")
    }

    fun getCommandByType(type: String): Command<IPayload, IResult>? {
        return commands.firstOrNull { it.type == type }
    }

    private fun handleWithHttpProtocol(
        command: Command<IPayload, IResult>,
        handler: CrossModuleHandler<IPayload, IResult>,
        payload: IPayload?
    ): IResult? {
        logger.info("Sending crossmodulecommunication request to ${handler.address} with type ${command.type}")
        return restTemplate.postForObject(
            "${handler.address}/cross-module-communication?type=${command.type}",
            payload,
            command.resultType()
        )
    }

    companion object{
        val logger = LoggerFactory.getLogger(Mediator::class.java)
    }
}