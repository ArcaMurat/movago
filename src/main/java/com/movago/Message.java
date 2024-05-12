package com.movago;

import com.movago.User;
import java.util.Date;

public class Message {
    private User sender;
    private User receiver;
    private String messageText;
    private Date sentTime;

    public Message(User sender, User receiver, String messageText) {
        this.sender = sender;
        this.receiver = receiver;
        this.messageText = messageText;
        this.sentTime = new Date(); // sets to current time
    }

    public String getMessageText() {
        return messageText;
    }

    public Date getSentTime() {
        return sentTime;
    }

    public User getSender() {
        return sender;
    }

    public User getReceiver() {
        return receiver;
    }
}

