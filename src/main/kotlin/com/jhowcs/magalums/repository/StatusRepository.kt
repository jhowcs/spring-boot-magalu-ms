package com.jhowcs.magalums.repository

import com.jhowcs.magalums.entity.Status
import org.springframework.data.jpa.repository.JpaRepository

interface StatusRepository : JpaRepository<Status, Long> {
}