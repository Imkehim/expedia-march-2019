package runner;

// TODO workspaceToken and channelId have to be set as environment variables


import client.SlackClient;
import importer.SlackImporter;
import tokeninput.InputReader;

public class Runner {

    public static void main(String[] args) {

        SlackClient slackClient = new SlackClient(
                "https://slack.com/api/conversations.history?token=",
                System.getenv("workspaceToken"),
                System.getenv("channelId")
        );

        SlackImporter slackImporter = new SlackImporter(
                new InputReader(slackClient)
        );
            slackImporter.run();
    }
}
