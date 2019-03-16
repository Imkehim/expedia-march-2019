package importer;

import tokeninput.InputReader;

public class SlackImporter {

    private final InputReader inputReader;

    public SlackImporter(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    public void run() {
        inputReader.readConversations();
    }
}
