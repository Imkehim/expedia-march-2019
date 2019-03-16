package data;

public class UserInfoData {
    private final String name;
    private final String realName;
    private final String emoji;
    private final String firstName;
    private final String lastName;
    private final String email;


    public UserInfoData(String name,
                        String realName,
                        String emoji,
                        String firstName,
                        String lastName,
                        String email) {
        this.name = name;
        this.realName = realName;
        this.emoji = emoji;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String name() {
        return name;
    }

    public String realName() {
        return realName;
    }

    public String emoji() {
        return emoji;
    }

    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return lastName;
    }

    public String email() {
        return email;
    }
}