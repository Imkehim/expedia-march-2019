package tokeninput;

import client.SlackClient;
import data.ConversationHistoryData;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

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

        IntStream.range(0, deeperObject.length()).mapToObj(
                i -> (JSONObject) deeperObject.get(i)).filter(
                        object -> object.has("user")).forEachOrdered(
                                object -> {
            String user = object.getString("user");
            String text = object.getString("text");
            String timeStamp = object.getString("ts");
            ConversationHistoryData conversationHistoryData = new ConversationHistoryData(user, text, timeStamp);
            messageList.add(conversationHistoryData);
        });

        IntStream.range(0, messageList.size()).forEachOrdered(i -> {
            System.out.println("date = " + messageList.get(i).datePosted());
            System.out.println("user id = " + messageList.get(i).memberName());
            System.out.println("message = " + messageList.get(i).message() + "\n");
        });

        return messageList;
    }
}
