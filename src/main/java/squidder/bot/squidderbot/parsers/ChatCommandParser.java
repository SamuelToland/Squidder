package squidder.bot.squidderbot.parsers;

import squidder.bot.squidderbot.chatCommands.ChatCommand;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ChatCommandParser {
    // Holds the prefix used to identify the command in a message
    String prefix = "/";

    // Holds if the chat message is a valid command or not
    Boolean isCommand = false;

    // Holds the first chat argument, usually being the command the user is calling
    String command;

    // Holds the chat message seperated by space
    List<String> arguments;

    public ChatCommandParser(String chatMessage) {
        if (chatMessage.startsWith(this.prefix)) {
            // Splitting the message by space to read arguments
            List<String> messageSplit = Arrays.asList(chatMessage.split(" "));
            // Setting command is true and getting the command and arguments given
            this.isCommand = true;
            command = messageSplit.get(1);
            arguments = messageSplit.subList(1, messageSplit.size());
        }
    }

    public Boolean isCommand() {
        return this.isCommand;
    }

    public String getCommand() {
        return this.command;
    }
}


