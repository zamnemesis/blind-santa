package com.zam.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Participant {
    private String participantName;
    private String participantEmail;

    public String getParticipantName() {
        return participantName;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

    public String getParticipantEmail() {
        return participantEmail;
    }

    public void setParticipantEmail(String participantEmail) {
        this.participantEmail = participantEmail;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("participantName", participantName)
                .append("participantEmail", participantEmail)
                .toString();
    }
}
