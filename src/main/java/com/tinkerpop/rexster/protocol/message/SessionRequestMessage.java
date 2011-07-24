package com.tinkerpop.rexster.protocol.message;

import com.tinkerpop.rexster.protocol.BitWorks;

import java.util.UUID;

public class SessionRequestMessage extends RexProMessage {

    /**
     * The console session is one that returns all values as string representations,
     * with its primary expected use being a remote console application.
     */
    public static final byte FLAG_NEW_CONSOLE_SESSION = 0;

    /**
     * Destroy a session.
     */
    public static final byte FLAG_KILL_SESSION = 1;

    public SessionRequestMessage(RexProMessage message) {
        super(message.getVersion(), message.getType(), message.getFlag(),
                message.getSession(), message.getRequest(), message.getBody());

        if (this.getType() != MessageType.SESSION_REQUEST) {
            throw new IllegalArgumentException("The message is not of type SESSION_REQUEST");
        }
    }

    public SessionRequestMessage(byte flag) {
        super(RexProMessage.CURRENT_VERSION, MessageType.SESSION_REQUEST, flag,
                BitWorks.convertUUIDToByteArray(EMPTY_SESSION),
                BitWorks.convertUUIDToByteArray(UUID.randomUUID()),
                new byte[0]);
    }
}