package runner;


import client.SlackClient;
import data.DataParser;
import importer.SlackImporter;
import tokeninput.InputReader;

public class Runner {

    public static void main(String[] args) {

        SlackClient slackClient = new SlackClient(
                "https://slack.com/api/conversations.history?token=",
                System.getenv("workspaceToken"),
                System.getenv("channelId")
        );

        final DataParser dataParser = new DataParser();

        SlackImporter slackImporter = new SlackImporter(
                new InputReader(slackClient, dataParser)
        );
            slackImporter.run();
    }
}
