package com.jhowcs.magalums.controller

import com.jhowcs.magalums.controller.dto.ScheduleNotificationDTO
import com.jhowcs.magalums.entity.Notification
import com.jhowcs.magalums.service.NotificationService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/notifications")
class NotificationController(
    private val service: NotificationService
) {
    @PostMapping
    fun scheduleNotification(@RequestBody notificationDTO: ScheduleNotificationDTO): ResponseEntity<Void> {
        service.scheduleNotification(notificationDTO)
        return ResponseEntity.accepted().build()
    }

    @GetMapping("/{id}")
    fun getNotification(@PathVariable("id") id: Long): ResponseEntity<Notification> {
        val notification = service.findById(id)

        if (notification.isEmpty) {
            return ResponseEntity.notFound().build()
        }

        return ResponseEntity.ok(notification.get())
    }

    @DeleteMapping("/{id}")
    fun cancelNotification(@PathVariable("id") id: Long): ResponseEntity<Void> {
        service.cancelNotification(id)
        return ResponseEntity.noContent().build()
    }
}