import events.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Jormungandr {

    public static void main(String[] args) {
        botLogin();
    }

    static void botLogin(){
        try (Stream<String> stream = Files.lines(Paths.get("config.txt"))) {
            String token = stream.findFirst().get();
            JDA jda = new JDABuilder(token)
                    .addEventListeners(new JorgParser())
                    .build();
            jda.awaitReady();
        } catch (IOException ioe) {
            System.out.println("file missing");
            ioe.printStackTrace();
        } catch (LoginException le) {
            System.out.println("Can't login");
            le.printStackTrace();
        } catch (InterruptedException ie) {
            System.out.println("Bot Stopped");
            ie.printStackTrace();
        }
    }
}