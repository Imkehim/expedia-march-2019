package client;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class SlackMembersClient {
    private final String baseUrl;
    private final String workspaceToken;
    private String channelId;

    public SlackMembersClient(String baseUrl, String workspaceToken, String channelId) {
        this.baseUrl = baseUrl;
        this.workspaceToken = workspaceToken;
        this.channelId = channelId;
    }

    public String getJsonData() {
        try {
            final HttpResponse<String> httpResponse = Unirest.get(baseUrl)
                    .queryString("token", workspaceToken)
                    .queryString("channel", channelId)
                    .queryString("pretty", 1)
                    .asString();
            System.out.println("members httpResponse = " + httpResponse.getBody());
            return httpResponse.getBody();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return "";
    }
}
