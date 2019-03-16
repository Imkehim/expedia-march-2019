package data;

public class UserData {
    private final String memberId;

    public UserData(String memberId) {
        this.memberId = memberId;
    }

    public String memberName() {
        return memberId;
    }
}