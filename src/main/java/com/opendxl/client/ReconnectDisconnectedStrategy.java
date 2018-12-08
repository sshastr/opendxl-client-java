/*---------------------------------------------------------------------------*
 * Copyright (c) 2018 McAfee, LLC - All Rights Reserved.                     *
 *---------------------------------------------------------------------------*/

package com.opendxl.client;

import org.apache.log4j.Logger;

/**
 * A disconnect strategy that attempts to reconnect to the server
 */
public class ReconnectDisconnectedStrategy implements DisconnectedStrategy {
    /**
     * The logger
     */
    private static Logger logger = Logger.getLogger(ReconnectDisconnectedStrategy.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDisconnect(final DxlClient client) {
        try {
            client.reconnect();
        } catch (Exception ex) {
            logger.error("Unable to reconnect", ex);
        }
    }
}
