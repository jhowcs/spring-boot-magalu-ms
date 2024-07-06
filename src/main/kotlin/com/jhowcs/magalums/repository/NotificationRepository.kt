package com.jhowcs.magalums.repository

import com.jhowcs.magalums.entity.Notification
import com.jhowcs.magalums.entity.Status
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.time.OffsetDateTime

interface NotificationRepository : JpaRepository<Notification, Long> {
    @Query(
        """SELECT n FROM Notification n
            JOIN FETCH n.channel 
            JOIN FETCH n.status
            WHERE n.status IN :statuses
            AND n.dateTime < :dateTime"""
    )
    fun findByStatusInAndDateTimeBefore(
        @Param("statuses") statuses: List<Status>,
        @Param("dateTime") dateTime: OffsetDateTime
    ): List<Notification>
}