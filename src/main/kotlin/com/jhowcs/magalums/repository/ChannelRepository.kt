package com.jhowcs.magalums.repository

import com.jhowcs.magalums.entity.Channel
import org.springframework.data.jpa.repository.JpaRepository

interface ChannelRepository : JpaRepository<Channel, Long> {
}