package client;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.http.HttpResponse;

public class SlackConversationClient {
    private final String baseUrl;
    private final String workspaceToken;
    private final String channelId;

    public SlackConversationClient(String baseUrl, String workspaceToken, String channelId) {
        this.baseUrl = baseUrl;
        this.workspaceToken = workspaceToken;
        this.channelId = channelId;
    }

    public String getJsonData() {
        try {
            final HttpResponse<String> httpResponse = Unirest.get(baseUrl)
                    .queryString("token", workspaceToken)
                    .queryString("channel", channelId)
                    .queryString("inclusive", 1)
                    .queryString("pretty", 1)
                    .asString();
            System.out.println("conversations httpResponse = " + httpResponse.getBody());
            return httpResponse.getBody();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return "";
    }
}
