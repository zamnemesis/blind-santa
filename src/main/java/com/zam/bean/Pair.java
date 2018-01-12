package com.zam.bean;

/**
 * author tarasenko
 * since  12.01.2018
 */
public class Pair {
    private Participant receiver; //получатель
    private Participant sender;   //отправитель

    public Pair() {
    }

    public Pair(Participant receiver, Participant sender) {
        this.receiver = receiver;
        this.sender = sender;
    }

    public Participant getReceiver() {
        return receiver;
    }

    public void setReceiver(Participant receiver) {
        this.receiver = receiver;
    }

    public Participant getSender() {
        return sender;
    }

    public void setSender(Participant sender) {
        this.sender = sender;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pair{");
        sb.append("receiver=").append(receiver);
        sb.append(", sender=").append(sender);
        sb.append('}');
        return sb.toString();
    }
}
