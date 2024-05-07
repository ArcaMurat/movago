import java.util.ArrayList;

public class User {
    private String userName;
    private String profilePhotoString;
    private String bio;
    private ArrayList<Trip> ownedTrips;
    private ArrayList<Trip> joinedTrips;
    private ArrayList<Message> sendedMessages;
    private ArrayList<Message> receivedMessages;
    private ArrayList<Boolean> answers; // Stores answers to questions for matching purposes
    private String password;

    // Constructor to initialize a new user with their details and an empty list for trips and messages
    public User(String userName, String profilePhotoString, String bio, ArrayList<Boolean> answers, String password) {
        this.userName = userName;
        this.profilePhotoString = profilePhotoString;
        this.bio = bio;
        this.password = password;
        this.answers = new ArrayList<>(answers);
        this.ownedTrips = new ArrayList<>();
        this.joinedTrips = new ArrayList<>();
        this.sendedMessages = new ArrayList<>();
        this.receivedMessages = new ArrayList<>();
    }

    // Sends a message from this user to another user and updates both sender's and receiver's message lists
    public void sendMessageToUser(User receiver, String messageText) {
        Message message = new Message(this, receiver, messageText);
        this.sendedMessages.add(message);
        receiver.receivedMessages.add(message);
    }

    // Creates a new trip owned by this user
    public void createTrip(String title, int participantsLimit) {
        Trip newTrip = new Trip(this, title, participantsLimit);
        this.ownedTrips.add(newTrip);
    }

    // Adds this user to a trip if they are not already a participant and if there is room
    public void joinTrip(Trip trip) {
        if (!this.joinedTrips.contains(trip) && trip.getParticipants().size() < trip.getParticipantsLimit()) {
            this.joinedTrips.add(trip);
            trip.addParticipant(this);
        }
    }

    // Removes this user from a trip
    public void disguardFromOneTrip(Trip trip) {
        this.joinedTrips.remove(trip);
        trip.removeParticipant(this);
    }

    // Displays all trips owned by this user
    public void displayOwnedTrips() {
        for (Trip trip : ownedTrips) {
            System.out.println(trip.getTitle());
        }
    }

    // Calculates the matching ratio between this user and another user based on their answers to questions
    public double calculateMatchRatio(User otherUser) {
        int totalQuestions = Math.min(this.answers.size(), otherUser.answers.size());
        int similarAnswers = 0;

        for (int i = 0; i < totalQuestions; i++) {
            if (this.answers.get(i).equals(otherUser.answers.get(i))) {
                similarAnswers++;
            }
        }

        return (double) similarAnswers / totalQuestions;
    }
    
    public String getUserName(){
        return userName;
    }
}
