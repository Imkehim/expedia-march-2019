package runner;

import dataextraction.InputConversationsReader;
import dataextraction.InputMembersReader;
import dataextraction.InputUserInfoReader;

public class Runner {

    private final InputConversationsReader inputConversationsReader;
    private final InputMembersReader inputMembersReader;
    private InputUserInfoReader inputUserInfoReader;

    public Runner(InputConversationsReader inputConversationsReader, InputMembersReader inputMembersReader, InputUserInfoReader inputUserInfoReader) {
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
