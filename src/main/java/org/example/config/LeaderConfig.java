package org.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.integration.leader.event.DefaultLeaderEventPublisher;
import org.springframework.integration.support.leader.LockRegistryLeaderInitiator;
import org.springframework.integration.support.locks.LockRegistry;

@Configuration
public class LeaderConfig {

    @Autowired
    LeaderCandidate leaderCandidate;

    @Bean
    @Scope("singleton")
    public LockRegistryLeaderInitiator leaderInitiator(
            LockRegistry lockRegistry, ApplicationEventPublisher applicationEventPublisher) {
        LockRegistryLeaderInitiator initiator = new LockRegistryLeaderInitiator(lockRegistry, leaderCandidate);
        initiator.setLeaderEventPublisher(
                new DefaultLeaderEventPublisher(applicationEventPublisher));
        return initiator;
    }
}
