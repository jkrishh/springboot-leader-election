package org.example.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.leader.Context;
import org.springframework.integration.leader.DefaultCandidate;
import org.springframework.stereotype.Component;

@Component
public class LeaderCandidate extends DefaultCandidate {

    private static Logger logger = LoggerFactory.getLogger(LeaderCandidate.class);

    public LeaderCandidate() {
    }

    @Override
    public void onGranted(Context ctx) {
        logger.info("Granted leadership..");
        super.onGranted(ctx);
    }

    @Override
    public void onRevoked(Context ctx) {
        logger.info("Revoked leadership..");
        super.onRevoked(ctx);
    }
}
