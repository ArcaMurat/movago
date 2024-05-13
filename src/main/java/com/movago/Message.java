package com.movago;

import com.movago.User;
import java.util.Date;

public class Message {
    private String sender;
    private String receiver;
    private String messageText;
    private Date sentTime;

    public Message(String sender, String receiver, String messageText) {
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

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }
}

