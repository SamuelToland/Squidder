package squidder.bot.squidderbot.chatCommands;

import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import reactor.core.publisher.Mono;

public interface ChatCommand {
    String getCommand();
    Mono<Void> runCommand(MessageCreateEvent messageEvent);
}
