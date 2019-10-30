import com.google.gson.Gson;
import entities.JorgUser;
import events.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.channel.text.TextChannelDeleteEvent;
import net.dv8tion.jda.api.events.guild.*;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.api.events.guild.member.update.GuildMemberUpdateNicknameEvent;
import net.dv8tion.jda.api.events.guild.update.GuildUpdateIconEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.user.update.UserUpdateOnlineStatusEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

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
        //System.out.println(event.getClass().getName());
        //System.out.println(event.getResponseNumber());
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
    //TODO for ALL: move this all
    public void onGuildMemberUpdateNickname(GuildMemberUpdateNicknameEvent event) {
        JordGuildMemberNickUpdate jgmn = new JordGuildMemberNickUpdate(event);
        System.out.println(gson.toJson(jgmn));
    }

    public void onGuildLeave(GuildLeaveEvent event) {
        JorgGuildLeaveEvent jgle = new JorgGuildLeaveEvent(event);
        System.out.println(gson.toJson(jgle));
    }
    //Those 4 send the same data, thinking about how to merge them
    //info: guildId, userId, username
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

    }
    //thinking if I even want to keep this one
    public void onGuildUpdateIcon(GuildUpdateIconEvent event) {
    }
    //needed to see if subs have to be cleared, needed info: channelId
    public void onTextChannelDelete(TextChannelDeleteEvent event) {

    }
    //more of a friend service to scream at him when his bot is down
    public void onUserUpdateOnlineStatus(UserUpdateOnlineStatusEvent event) {

    }
    //main command pipeline
    public void onMessageReceived(MessageReceivedEvent event){
        JorgMessageReceived jmr=new JorgMessageReceived(
                event.getMessage().getContentRaw(),
                event.getMessage().getMentionedMembers(), //TODO: doesn't really work here, have to cast JDA Members into JorgMembers
                event.getChannel().getId(),
                event.getChannelType(),
                new JorgUser(event.getAuthor())
        );
    }
}