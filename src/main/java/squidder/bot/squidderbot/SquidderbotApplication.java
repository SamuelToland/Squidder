package squidder.bot.squidderbot;

import discord4j.core.GatewayDiscordClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import discord4j.core.DiscordClient;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class SquidderbotApplication {

    public static void main(String[] args) {
        // Spring Boot Init
        SpringApplication.run(SquidderbotApplication.class, args);

        // Discord Bot Login
        DiscordClient client = DiscordClient.create(System.getenv("squidder-bot-token"));
        Mono<Void> login = client.withGateway((GatewayDiscordClient gateway) -> Mono.empty());
        login.block();
    }

}
