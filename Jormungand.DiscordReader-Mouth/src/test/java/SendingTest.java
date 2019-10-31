import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeoutException;

public class SendingTest {
    @Test
    void SendMessage() throws IOException, TimeoutException {
        String EXCHANGE_NAME = "discord_events";
        ConnectionFactory factory = new ConnectionFactory();

        List<String> content = Files.readAllLines(Paths.get("config.txt"));
        String host = content.get(1);
        String username = content.get(2);
        String password = content.get(3);

        factory.setUsername(username);
        factory.setPassword(password);
        factory.setHost(host);
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.exchangeDeclare(EXCHANGE_NAME, "topic");
            String routingKey = "jormungand.guild.join";
            String message = "I joined X";
            channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + routingKey + "':'" + message + "'");
        }
    }
}
