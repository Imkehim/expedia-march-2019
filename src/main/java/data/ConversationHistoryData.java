package data;

public class    ConversationHistoryData {
    private final String memberName;
    private final String message;
    private final String datePosted;

    public ConversationHistoryData(String memberName, String message, String datePosted) {
        this.memberName = memberName;
        this.message = message;
        this.datePosted = datePosted;
    }

    public String memberName() {
        return memberName;
    }

    public String message() {
        return message;
    }

    public String datePosted() {
        return datePosted;
    }
}