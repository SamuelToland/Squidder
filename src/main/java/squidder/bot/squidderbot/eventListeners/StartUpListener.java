package squidder.bot.squidderbot.eventListeners;

import discord4j.core.event.domain.lifecycle.ReadyEvent;
import discord4j.core.object.entity.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class StartUpListener implements EventListener<ReadyEvent> {
    @Override
    public Class<ReadyEvent> getEventType() {
        return ReadyEvent.class;
    }

    @Override
    public Mono<Void> execute(ReadyEvent event) {
        User self = event.getSelf();
        System.out.printf("Logged in as %s#%s%n", self.getUsername(), self.getDiscriminator());
        return Mono.empty();
    }
}
