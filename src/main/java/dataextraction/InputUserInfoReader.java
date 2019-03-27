package dataextraction;

import client.SlackUserInfoClient;
import data.UserInfoData;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class InputUserInfoReader {

    private final SlackUserInfoClient slackUserInfoClient;

    public InputUserInfoReader(SlackUserInfoClient slackUserInfoClient) {
        this.slackUserInfoClient = slackUserInfoClient;
    }

    public Object readUserInfo() {
        String jsonData = slackUserInfoClient.getJsonData();

        JSONObject topLevelJsonObject = new JSONObject(jsonData);
        JSONObject userObject = (JSONObject) topLevelJsonObject.get("user");
        JSONObject profileObject = (JSONObject) userObject.get("profile");

        List<UserInfoData> userInfo = new ArrayList<>();

        String name = userObject.getString("name");
        String realName = userObject.getString("real_name");

        String emoji = profileObject.getString("status_emoji");
        String firstName = profileObject.getString("first_name");
        String lastName = profileObject.getString("last_name");
        String email = profileObject.getString("email");

        UserInfoData userInfoData = new UserInfoData(name, realName, emoji, firstName, lastName, email);
        userInfo.add(userInfoData);

        IntStream.range(0, userInfo.size()).forEachOrdered(i -> {
            System.out.println("user name = " + userInfo.get(i).name());
            System.out.println("real_name = " + userInfo.get(i).realName());
            System.out.println("status_emoji = " + userInfo.get(i).emoji());
            System.out.println("first_name = " + userInfo.get(i).firstName());
            System.out.println("last_name = " + userInfo.get(i).lastName());
            System.out.println("email = " + userInfo.get(i).email() + "\n");
        });

        return userInfo;
    }
}