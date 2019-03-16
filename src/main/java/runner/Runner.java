package runner;

// TODO workspaceToken and channelId have to be set as environment variables


import client.SlackConversationClient;
import client.SlackMembersClient;
import importer.SlackImporter;
import tokeninput.InputConversationsReader;
import tokeninput.InputMembersReader;

public class Runner {

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

        SlackImporter slackImporter = new SlackImporter(
                new InputConversationsReader(slackConversationClient),
                new InputMembersReader(slackMembersClient)
        );
        slackImporter.run();
    }
}
