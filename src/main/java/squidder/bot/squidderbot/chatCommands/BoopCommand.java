package squidder.bot.squidderbot.chatCommands;

import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import discord4j.core.object.reaction.ReactionEmoji;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class BoopCommand implements ChatCommand {
    @Override
    public String getCommand() {
        return "boop";
    }

    @Override
    public Mono<Void> runCommand(MessageCreateEvent messageEvent) {
        return messageEvent.getMessage().getChannel()
                .flatMap(channel -> channel.createMessage("Boooop"))
                .then();
    }
}
