package squidder.bot.squidderbot;

import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.lifecycle.ReadyEvent;
import discord4j.core.object.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import discord4j.core.DiscordClient;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class SquidderbotApplication {

    public static void main(String[] args) {
        SpringApplication.run(SquidderbotApplication.class, args);
    }

}
