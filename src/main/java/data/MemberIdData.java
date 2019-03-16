package data;

public class MemberIdData {
    private final String memberId;

    public MemberIdData(String memberId) {
        this.memberId = memberId;
    }

    public String memberName() {
        return memberId;
    }
}