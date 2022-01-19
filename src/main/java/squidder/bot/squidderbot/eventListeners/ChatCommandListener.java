package squidder.bot.squidderbot.eventListeners;

import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import squidder.bot.squidderbot.chatCommands.ChatCommand;
import squidder.bot.squidderbot.parsers.ChatCommandParser;

import java.util.Collection;

@Service
public class ChatCommandListener implements EventListener<MessageCreateEvent> {
    Collection<ChatCommand> chatCommands;

    public ChatCommandListener(Collection<ChatCommand> chatCommands) {
        this.chatCommands = chatCommands;
    }

    @Override
    public Class<MessageCreateEvent> getEventType() {
        return MessageCreateEvent.class;
    }

    @Override
    public Mono<Void> execute(MessageCreateEvent event) {
        Message msg = event.getMessage();
        // Check if sender is not a bot
        if (msg.getAuthor().isPresent() || !msg.getAuthor().get().isBot()) {
            ChatCommandParser command = new ChatCommandParser(msg.getContent());
            if (command.isCommand()) {
                // Loop our chat commands and check if any match the message
                for (ChatCommand availableCommands : chatCommands) {
                    if (availableCommands.getCommand().equalsIgnoreCase(command.getCommand())) {
                        return availableCommands.runCommand(event);
                    }
                }
            }
        }
        return Mono.empty();
    }
}
