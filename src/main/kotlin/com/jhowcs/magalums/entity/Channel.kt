package com.jhowcs.magalums.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.IDENTITY
import jakarta.persistence.Id

@Entity
data class Channel(
    @Id
    @GeneratedValue(strategy = IDENTITY)
    var id: Long? = null,
    val description: String
)

enum class ChannelType(private val id: Long, private val type: String) {
    EMAIL(1L, "EMAIL"),
    SMS(2L, "SMS"),
    PUSH(3L, "PUSH"),
    WHATSAPP(4L, "WHATSAPP");

    fun toChannel(): Channel {
        return Channel(id, type)
    }
}
