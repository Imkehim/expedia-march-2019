package tokeninput;

import client.SlackClient;
import data.ConversationHistoryData;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class InputReader {

    private final SlackClient slackClient;

    public InputReader(SlackClient slackClient) {
        this.slackClient = slackClient;
    }

    public Object readConversations() {
        String jsonData = slackClient.getJsonData();

        JSONObject topLevelJsonObject = new JSONObject(jsonData);
        JSONArray deeperObject = (JSONArray) topLevelJsonObject.get("messages");

        List<ConversationHistoryData> messageList = new ArrayList<>();

        for (int i = 0; i < deeperObject.length(); i++) {
            JSONObject object = (JSONObject) deeperObject.get(i);
            if (object.has("user")) {
                String user = object.getString("user");
                String text = object.getString("text");
                String timeStamp = object.getString("ts");
                ConversationHistoryData conversationHistoryData = new ConversationHistoryData(user, text, timeStamp);
                messageList.add(conversationHistoryData);

            }
        }
        for (int i = 0; i < messageList.size(); i++) {
            System.out.println("Date = " + messageList.get(i).datePosted());
            System.out.println("user id = " + messageList.get(i).memberName());
            System.out.println("message = " + messageList.get(i).message() + "\n");
        }

        return messageList;
    }
}
