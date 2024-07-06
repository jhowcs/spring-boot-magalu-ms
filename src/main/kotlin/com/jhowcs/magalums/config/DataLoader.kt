package com.jhowcs.magalums.config

import com.jhowcs.magalums.entity.ChannelType
import com.jhowcs.magalums.entity.StatusType
import com.jhowcs.magalums.repository.ChannelRepository
import com.jhowcs.magalums.repository.StatusRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Configuration

@Configuration
class DataLoader(
    private val channelRepository: ChannelRepository,
    private val statusRepository: StatusRepository
) : CommandLineRunner {
    override fun run(vararg args: String?) {
        ChannelType.entries.map { type -> type.toChannel() }.also { channelRepository.saveAll(it) }
        StatusType.entries.map { type -> type.toStatus() }.also { statusRepository.saveAll(it) }
    }
}