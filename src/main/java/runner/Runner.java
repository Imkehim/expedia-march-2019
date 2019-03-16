package runner;

// TODO 'workspaceToken', 'channelId' and 'user' have to be set as environment variables in order to run app as is.


import client.SlackConversationClient;
import client.SlackMembersClient;
import client.SlackUserInfoClient;
import importer.SlackImporter;
import tokeninput.InputConversationsReader;
import tokeninput.InputMembersReader;
import tokeninput.InputUserInfoReader;

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

        SlackUserInfoClient slackUserInfoClient = new SlackUserInfoClient(
                "https://slack.com/api/users.info?token=",
                System.getenv("workspaceToken"),
                System.getenv("user")
        );

        SlackImporter slackImporter = new SlackImporter(
                new InputConversationsReader(slackConversationClient),
                new InputMembersReader(slackMembersClient),
                new InputUserInfoReader(slackUserInfoClient)
        );
        slackImporter.run();
    }
}
