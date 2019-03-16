package client;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class SlackUserInfoClient {
    private final String baseUrl;
    private final String workspaceToken;
    private String userId;

    public SlackUserInfoClient(String baseUrl, String workspaceToken, String userId) {
        this.baseUrl = baseUrl;
        this.workspaceToken = workspaceToken;
        this.userId = userId;
    }

    public String getJsonData() {

        try {
            final HttpResponse<String> httpResponse = Unirest.get(baseUrl)
                    .queryString("token", workspaceToken)
                    .queryString("user", userId)
                    .queryString("pretty", 1)
                    .asString();
            System.out.println("user info httpResponse = " + httpResponse.getBody());
            return httpResponse.getBody();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return "";
    }

        //TODO iterate through all memberIds and recursively make call for each of them to replace hardcoded userId.
}
