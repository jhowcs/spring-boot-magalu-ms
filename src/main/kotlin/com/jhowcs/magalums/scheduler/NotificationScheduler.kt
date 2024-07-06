package com.jhowcs.magalums.scheduler

import com.jhowcs.magalums.service.NotificationService
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.concurrent.TimeUnit.MINUTES

@Component
class NotificationScheduler(private val service: NotificationService) {

    private val logger = LoggerFactory.getLogger(NotificationScheduler::class.java)

    @Scheduled(fixedDelay = 10, timeUnit = MINUTES)
    fun runTasks() {
        val datetime = OffsetDateTime.now()
        logger.info("Started tasks at ${datetime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))}")
        service.checkAndSend(datetime)
    }
}