package com.movago;

import com.movago.User;
import java.util.ArrayList;

public class MessageManager {
    private ArrayList<Message> messages;

    // Constructor initializes the message manager with an empty ArrayList of messages
    public MessageManager() {
        this.messages = new ArrayList<>();
    }

    // Add a message to the manager
    public void addMessage(Message message) {
        this.messages.add(message);
    }

    // Retrieve all messages between two specific users
    public ArrayList<Message> getAllMessagesBetweenUsers(User user1, User user2) {
        ArrayList<Message> filteredMessages = new ArrayList<>();
        for (Message message : messages) {
            if ((message.getSender().equals(user1) && message.getReceiver().equals(user2)) ||
                (message.getSender().equals(user2) && message.getReceiver().equals(user1))) {
                filteredMessages.add(message);
            }
        }
        return filteredMessages;
    }

    // Display all messages for debugging or user interface display
    public void displayAllMessages() {
        for (Message message : messages) {
            System.out.println("From: " + message.getSender().getUserName() +
                               " To: " + message.getReceiver().getUserName() +
                               " Text: " + message.getMessageText() +
                               " Sent: " + message.getSentTime());
        }
    }
    
    // Additional methods to support message management, like deleting or archiving messages
}
