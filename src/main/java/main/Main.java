package main;

// TODO 'workspaceToken', 'channelId' and 'user' have to be set as environment variables in order to run app as is.


import client.SlackConversationClient;
import client.SlackMembersClient;
import client.SlackUserInfoClient;
import dataextraction.InputConversationsReader;
import dataextraction.InputMembersReader;
import dataextraction.InputUserInfoReader;
import runner.Runner;

public class Main {

    public static void main(String[] args) {

        SlackConversationClient slackConversationClient = new SlackConversationClient(
                "https://slack.com/api/conversations.history?token=",
                System.getenv("workspaceToken"),
                System.getenv("channelId")
        );

        SlackMembersClient slackMembersClient = new SlackMembersClient(
                "https://slack.com/api/conversations.members?token=",
                System.getenv("workspaceToken"),
                System.getenv("channelId")
        );

        SlackUserInfoClient slackUserInfoClient = new SlackUserInfoClient(
                "https://slack.com/api/users.info?token=",
                System.getenv("workspaceToken"),
                System.getenv("user")
        );

        Runner runner = new Runner(
                new InputConversationsReader(slackConversationClient),
                new InputMembersReader(slackMembersClient),
                new InputUserInfoReader(slackUserInfoClient)
        );
        runner.run();
    }
}
