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

public class Jormungandr extends ListenerAdapter {

    public static void main(String[] args) throws LoginException, InterruptedException {
        try (Stream<String> stream = Files.lines(Paths.get("config.txt"))) {
            String token = stream.findFirst().get();
            JDA jda = new JDABuilder(token)
                    .addEventListeners(new Jormungandr())
                    .build();
            jda.awaitReady();
        } catch (IOException e) {
            System.out.println("file missing");
            e.printStackTrace();
        }
    }
    //TODO: add senders, see SendingTest for more info, exchanges should follow the structure jormungand.guild.<eventname> for guild events, jormungand.message for generic messages
    private Gson gson = new Gson();

    //next three are mess around listeners, gonna get wiped once this step is done
    //genericEvent doesn't really have any use anyway but provides general info on what events you'd receive
    public void onGenericEvent(GenericEvent event) {
        System.out.print(event.getResponseNumber());
        System.out.print(": ");
        System.out.print(event.getClass().getName());
        System.out.print(" - ");
        System.out.print(LocalTime.now());
    }

    public void onGuildJoin(GuildJoinEvent event) {
        JorgJoinEvent gje = new JorgJoinEvent(event);
        String queueObject = gson.toJson(gje);
        System.out.println(queueObject);
    }

    public void onGuildReady(GuildReadyEvent event) {
        JorgReadyEvent jre = new JorgReadyEvent(event);
        System.out.println(gson.toJson(jre));
    }

    public void onGuildMemberUpdateNickname(GuildMemberUpdateNicknameEvent event) {
        JordGuildMemberNickUpdate jgmn = new JordGuildMemberNickUpdate(event);
        System.out.println(gson.toJson(jgmn));
    }

    public void onGuildLeave(GuildLeaveEvent event) {
        JorgGuildLeaveEvent jgle = new JorgGuildLeaveEvent(event);
        System.out.println(gson.toJson(jgle));
    }

    public void onGuildMemberLeave(GuildMemberLeaveEvent event) {
        JorgGuildMemberLeave jgml = new JorgGuildMemberLeave(event);
        System.out.println(gson.toJson(jgml));
    }

    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        JorgGuildMemberJoin jgmj = new JorgGuildMemberJoin(event);
        System.out.println(gson.toJson(jgmj));
    }

    public void onGuildBan(GuildBanEvent event) {
        JorgGuildBan jgb = new JorgGuildBan(event);
        System.out.println(gson.toJson(jgb));
    }

    public void onGuildUnban(GuildUnbanEvent event) {
        JorgGuildUnban jgu = new JorgGuildUnban(event);
        System.out.println(gson.toJson(jgu));
    }

    public void onTextChannelDelete(TextChannelDeleteEvent event) {
        JorgTextChannelDelete jtcd = new JorgTextChannelDelete(event);
        System.out.println(gson.toJson(jtcd));
    }

    public void onUserUpdateOnlineStatus(UserUpdateOnlineStatusEvent event) {
        JorgUserUpdateOnlineStatus juuos = new JorgUserUpdateOnlineStatus(event);
        System.out.println(gson.toJson(juuos));
    }

    //main command pipeline
    public void onMessageReceived(MessageReceivedEvent event){
        JorgMessageReceived jmr = new JorgMessageReceived(event);
        System.out.println(gson.toJson(jmr));
    }
}