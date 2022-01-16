package squidder.bot.squidderbot.eventListeners;

import discord4j.core.event.domain.Event;
import reactor.core.publisher.Mono;

public interface EventListener<T extends Event> {
    Class<T> getEventType();
    Mono<Void> execute(T event);

    default Mono<Void> handleError (Throwable error) {
        System.out.println("\nERROR: Unable to process "+getEventType().getSimpleName()+ "\n"+error);
        return Mono.empty();
    }
}
