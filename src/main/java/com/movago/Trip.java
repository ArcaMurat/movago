import java.util.ArrayList;

public class Trip {
    private User owner;
    private String title;
    private int participantsLimit;
    private ArrayList<User> participants;

    public Trip(User owner, String title, int participantsLimit) {
        this.owner = owner;
        this.title = title;
        this.participantsLimit = participantsLimit;
        this.participants = new ArrayList<>();
    }

    public void addParticipant(User user) {
        if (participants.size() < participantsLimit) {
            participants.add(user);
        }
    }

    public void removeParticipant(User user) {
        participants.remove(user);
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<User> getParticipants() {
        return participants;
    }

    public int getParticipantsLimit() {
        return participantsLimit;
    }
}
