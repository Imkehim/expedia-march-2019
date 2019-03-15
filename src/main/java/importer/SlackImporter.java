package importer;

import data.ConversationHistoryData;
import tokeninput.InputReader;

import java.util.ArrayList;

public class SlackImporter {

    private final InputReader inputReader;

    public SlackImporter(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    public void run() {
        Object conversations = inputReader.readConversations();
        System.out.println("conversation Details: " + conversations);
        outputInterestingData();
    }

    private void outputInterestingData() {
        ArrayList<ConversationHistoryData> data = new ArrayList<>();

        System.out.println("data = " + data.get(0).toString());

    }
}
