package com.jhowcs.magalums.controller.dto

import com.jhowcs.magalums.entity.ChannelType
import com.jhowcs.magalums.entity.Notification
import com.jhowcs.magalums.entity.StatusType
import java.time.OffsetDateTime

data class ScheduleNotificationDTO(
    val dateTime: OffsetDateTime,
    val destination: String,
    val message: String,
    val channelType: ChannelType
) {
    fun toNotification(): Notification {
        return Notification(
            dateTime = dateTime,
            destination = destination,
            message = message,
            channel = channelType.toChannel(),
            status = StatusType.PENDING.toStatus()
        )
    }
}
