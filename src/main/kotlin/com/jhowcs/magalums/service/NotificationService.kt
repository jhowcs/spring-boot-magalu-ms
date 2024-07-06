package com.jhowcs.magalums.service

import com.jhowcs.magalums.controller.dto.ScheduleNotificationDTO
import com.jhowcs.magalums.entity.Notification
import com.jhowcs.magalums.entity.StatusType.*
import com.jhowcs.magalums.repository.NotificationRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.time.OffsetDateTime
import java.util.*

@Service
class NotificationService(
    private val repository: NotificationRepository
) {
    fun scheduleNotification(notificationDTO: ScheduleNotificationDTO) {
        repository.save(notificationDTO.toNotification())
    }

    fun findById(id: Long): Optional<Notification> {
        return repository.findById(id)
    }

    fun cancelNotification(id: Long) {
        val notification = repository.findById(id)

        if (notification.isPresent) {
            notification.get().status = CANCELED.toStatus()

            repository.save(notification.get())
        }
    }

    @Transactional
    fun checkAndSend(datetime: OffsetDateTime) {
        val notifications = repository.findByStatusInAndDateTimeBefore(
            listOf(PENDING.toStatus(), ERROR.toStatus()), datetime
        )

        notifications.forEach { notification ->
            notification.status = SUCCESS.toStatus()
        }

        repository.saveAll(notifications)
    }
}