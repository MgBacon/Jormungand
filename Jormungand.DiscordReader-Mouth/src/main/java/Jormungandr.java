import com.google.gson.Gson;
import events.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.channel.text.TextChannelDeleteEvent;
import net.dv8tion.jda.api.events.guild.*;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.api.events.guild.member.update.GuildMemberUpdateNicknameEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.user.update.UserUpdateOnlineStatusEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.time.LocalTime;

public class Jormungandr {

    public static void main(String[] args) throws LoginException, InterruptedException {
        try (Stream<String> stream = Files.lines(Paths.get("config.txt"))) {
            String token = stream.findFirst().get();
            JDA jda = new JDABuilder(token)
                    .addEventListeners(new JorgParser())
                    .build();
            jda.awaitReady();
        } catch (IOException e) {
            System.out.println("file missing");
            e.printStackTrace();
        }
    }
}