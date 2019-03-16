package importer;

import tokeninput.InputConversationsReader;
import tokeninput.InputMembersReader;
import tokeninput.InputUserInfoReader;

public class SlackImporter {

    private final InputConversationsReader inputConversationsReader;
    private final InputMembersReader inputMembersReader;
    private InputUserInfoReader inputUserInfoReader;

    public SlackImporter(InputConversationsReader inputConversationsReader, InputMembersReader inputMembersReader, InputUserInfoReader inputUserInfoReader) {
        this.inputConversationsReader = inputConversationsReader;
        this.inputMembersReader = inputMembersReader;
        this.inputUserInfoReader = inputUserInfoReader;
    }

    public void run() {
        inputConversationsReader.readConversations();
        inputMembersReader.readUsersList();
        inputUserInfoReader.readUserInfo();
    }
}
