package tokeninput;

import client.SlackMembersClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.stream.IntStream;

public class InputMembersReader {

    private SlackMembersClient slackMembersClient;

    public InputMembersReader(SlackMembersClient slackMembersClient) {
        this.slackMembersClient = slackMembersClient;
    }

    public Object readUsersList() {
        String jsonData = slackMembersClient.getJsonData();

        JSONObject membersList = new JSONObject(jsonData);
        JSONArray jsonArray = (JSONArray) membersList.get("members");

        IntStream.range(0, jsonArray.length())
                .mapToObj(i -> "member id " + (i + 1) + " = " + jsonArray.get(i))
                .forEachOrdered(System.out::println);
        return jsonArray;
    }
}