package com.jhowcs.magalums.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.IDENTITY
import jakarta.persistence.Id

@Entity
data class Status(
    @Id
    @GeneratedValue(strategy = IDENTITY)
    var id: Long? = null,
    val description: String
)

enum class StatusType(private val id: Long, private val description: String) {
    PENDING(1L, "PENDING"),
    SUCCESS(2L, "SUCCESS"),
    ERROR(3L, "ERROR"),
    CANCELED(4L, "CANCELED");

    fun toStatus(): Status {
        return Status(id, description)
    }
}
