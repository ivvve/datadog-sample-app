package com.example.springddagent

import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
class SpringDdAgentApplication(
    private val keyValueRepository: KeyValueRepository,
) {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @GetMapping("/status/{status}")
    fun status(@PathVariable status: Int): ResponseEntity<Any> {
        this.logger.info("Request status is {}", status)

        if ((status < 100) || (600 <= status)) {
            logger.error("Not valid status: {}", status)
            throw IllegalArgumentException("Not valid status for HTTP: $status")
        }

        return ResponseEntity.status(status)
            .body(mapOf("result" to "ok"))
    }

    @GetMapping("/db")
    fun db(@RequestParam("key") key: String, @RequestParam("value") value: String): ResponseEntity<List<KeyValue>> {
        this.keyValueRepository.save(KeyValue(key, value))
        return ResponseEntity.ok(this.keyValueRepository.findAll())
    }
}

fun main(args: Array<String>) {
    runApplication<SpringDdAgentApplication>(*args)
}
