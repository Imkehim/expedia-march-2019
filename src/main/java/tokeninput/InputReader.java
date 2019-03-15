package tokeninput;

import client.SlackClient;
import data.ConversationHistoryData;
import data.DataParser;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class InputReader {

    private final SlackClient slackClient;
    private final DataParser dataParser;

    public InputReader(SlackClient slackClient, DataParser dataParser) {
        this.slackClient = slackClient;
        this.dataParser = dataParser;
    }

    public Object readConversations() {
        String jsonData = slackClient.getJsonData();

        JSONObject topLevelJsonObject = new JSONObject(jsonData);
        JSONArray deeperObject = (JSONArray)topLevelJsonObject.get("messages");

        List<ConversationHistoryData> messageList = new ArrayList<>();

        for (int i = 0; i < deeperObject.length(); i++) {
            JSONObject object = (JSONObject)deeperObject.get(i);
            if (object.has("user")) {
                String user = object.getString("user");
                String text = object.getString("text");
                String timeStamp = object.getString("ts");
                ConversationHistoryData conversationHistoryData = new ConversationHistoryData(user, text, timeStamp);
                messageList.add(conversationHistoryData);
            }
        }
        return messageList;
    }
}
