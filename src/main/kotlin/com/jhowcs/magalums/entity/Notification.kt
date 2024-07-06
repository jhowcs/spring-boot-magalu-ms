package com.jhowcs.magalums.entity

import jakarta.persistence.*
import jakarta.persistence.GenerationType.IDENTITY
import java.time.OffsetDateTime

@Entity
data class Notification(
    @Id
    @GeneratedValue(strategy = IDENTITY)
    var id: Long? = null,
    val dateTime: OffsetDateTime,
    val destination: String,
    val message: String,
    @ManyToOne
    @JoinColumn(name = "channel_id")
    val channel: Channel,
    @ManyToOne
    @JoinColumn(name = "status_id")
    var status: Status
)
