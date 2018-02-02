package com.zam.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;
import java.util.List;

public class Party {
    private Date date;
    private String location;
    private Integer amount;
//    private List<Participant> participants;
    private String message;

    public Date getPartyDate() {
        return date;
    }

    public void setPartyDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

//    public List<Participant> getParticipants() {
//        return participants;
//    }
//
//    public void setParticipants(List<Participant> participants) {
//        this.participants = participants;
//    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("date", date)
                .append("location", location)
                .append("amount", amount)
//                .append("participants", participants)
                .append("message", message)
                .toString();
    }
}
