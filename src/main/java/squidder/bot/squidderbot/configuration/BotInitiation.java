package squidder.bot.squidderbot.configuration;

import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.Event;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import squidder.bot.squidderbot.eventListeners.EventListener;

import java.util.List;

@Configuration
public class BotInitiation {
    @Bean
    public <T extends Event> GatewayDiscordClient gatewayDiscordClient(List<EventListener<T>> eventListeners) {

        // Logging into the Bot
        GatewayDiscordClient client = DiscordClientBuilder.create(System.getenv("squidder-bot-token"))
                .build()
                .login()
                .block();

        // Subscribing to all events we have event listeners for
        for(EventListener<T> listener : eventListeners) {
            client.on(listener.getEventType())
                    .flatMap(listener::execute)
                    .onErrorResume(listener::handleError)
                    .subscribe();
        }

        return client;
    }
}
