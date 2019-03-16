package data;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

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
        String[] split = datePosted.split("\\.");
        Long dateInMillis = Long.parseLong(split[0]);
        Instant instant = Instant.ofEpochMilli(dateInMillis * 1000);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        return localDateTime.toString();
    }
}