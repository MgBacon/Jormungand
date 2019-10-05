import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Jormungandr extends ListenerAdapter {

    public static void main(String[] args) throws LoginException, InterruptedException
    {
        try (Stream<String> stream=Files.lines(Paths.get("config.txt"))) {
            String token=stream.findFirst().get();
            JDA  jda = new JDABuilder(token)
                    .addEventListeners(new Jormungandr())
                    .build();
            jda.awaitReady();
        } catch (IOException e) {
            System.out.println("file missing");
            e.printStackTrace();
        }
    }
    @Override
    public void onGenericEvent(GenericEvent event)
    {
        System.out.println(event.getClass().getName());
    }
}
