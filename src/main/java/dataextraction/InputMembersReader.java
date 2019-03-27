package dataextraction;

import client.SlackMembersClient;
import data.MemberIdData;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
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

        List<MemberIdData> memberIds = new ArrayList<>();
        String memberId = "";

        IntStream.range(0, jsonArray.length())
                .mapToObj(i -> "member id " + (i + 1) + " = " + jsonArray.get(i))
                .forEachOrdered(System.out::println);

        MemberIdData memberIdData = new MemberIdData(memberId);
        memberIds.add(memberIdData);

        return memberIds;
    }
}