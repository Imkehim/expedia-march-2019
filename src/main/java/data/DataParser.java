package data;

import org.json.JSONObject;

import java.util.List;

public class DataParser {

    public ConversationHistoryData collectDataFrom(List<Object> dataJson) {
        final JSONObject jsonObject = new JSONObject(dataJson);
        return getInterestingData(jsonObject);
    }

    public ConversationHistoryData getInterestingData(Object deeperData) {
        JSONObject jsonObject = new JSONObject(deeperData);

        return new ConversationHistoryData(
                jsonObject.get("user").toString(),
                jsonObject.get("text").toString(),
                jsonObject.get("ts").toString()
        );
    }
}
