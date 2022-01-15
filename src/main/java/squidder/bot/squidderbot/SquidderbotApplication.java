package squidder.bot.squidderbot;

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
        // Spring Boot Init
        SpringApplication.run(SquidderbotApplication.class, args);

        // Discord Bot Login
        DiscordClient client = DiscordClient.create(System.getenv("squidder-bot-token"));
        Mono<Void> login = client.withGateway((GatewayDiscordClient gateway) ->
            gateway.on(ReadyEvent.class, event ->
                Mono.fromRunnable(() -> {
                    final User self = event.getSelf();
                    System.out.printf("Logged in as %s#%s%n", self.getUsername(), self.getDiscriminator());
                })
            )
        );
        login.block();
    }

}
