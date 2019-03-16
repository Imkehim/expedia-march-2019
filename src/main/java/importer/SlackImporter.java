package importer;

import tokeninput.InputConversationsReader;
import tokeninput.InputMembersReader;

public class SlackImporter {

    private final InputConversationsReader inputConversationsReader;
    private final InputMembersReader inputMembersReader;

    public SlackImporter(InputConversationsReader inputConversationsReader, InputMembersReader inputMembersReader) {
        this.inputConversationsReader = inputConversationsReader;
        this.inputMembersReader = inputMembersReader;
    }

    public void run() {
        inputConversationsReader.readConversations();
        inputMembersReader.readUsersList();
    }
}
