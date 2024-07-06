package com.jhowcs.magalums

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class MagaluMsApplication

fun main(args: Array<String>) {
    runApplication<MagaluMsApplication>(*args)
}
