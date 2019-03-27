package dataextraction;

import client.SlackConversationClient;
import data.ConversationHistoryData;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class InputConversationsReader {

    private final SlackConversationClient slackConversationClient;

    public InputConversationsReader(SlackConversationClient slackConversationClient) {
        this.slackConversationClient = slackConversationClient;
    }

    public Object readConversations() {
        String jsonData = slackConversationClient.getJsonData();

        JSONObject topLevelJsonObject = new JSONObject(jsonData);
        JSONArray deeperObject = (JSONArray) topLevelJsonObject.get("messages");

        List<ConversationHistoryData> messages = new ArrayList<>();

        IntStream.range(0, deeperObject.length()).mapToObj(
                i -> (JSONObject) deeperObject.get(i)).filter(
                        object -> object.has("user")).forEachOrdered(
                                object -> {
            String user = object.getString("user");
            String text = object.getString("text");
            String timeStamp = object.getString("ts");
            ConversationHistoryData conversationHistoryData = new ConversationHistoryData(user, text, timeStamp);
            messages.add(conversationHistoryData);
        });

        IntStream.range(0, messages.size()).forEachOrdered(i -> {
            System.out.println("date = " + messages.get(i).datePosted());
            System.out.println("user id = " + messages.get(i).memberName());
            System.out.println("message = " + messages.get(i).message() + "\n");
        });

        return messages;
    }
}