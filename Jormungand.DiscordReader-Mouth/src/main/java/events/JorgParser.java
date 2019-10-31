package events;

import com.google.gson.Gson;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.channel.text.TextChannelDeleteEvent;
import net.dv8tion.jda.api.events.guild.*;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.api.events.guild.member.update.GuildMemberUpdateNicknameEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.user.update.UserUpdateOnlineStatusEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.time.LocalTime;

public class JorgParser extends ListenerAdapter {
    private String guildId;

    //TODO: add senders, see SendingTest for more info, exchanges should follow the structure jormungand.guild.<eventname> for guild events, jormungand.message for generic messages
    private Gson gson = new Gson();

    //next three are mess around listeners, gonna get wiped once this step is done
    //genericEvent doesn't really have any use anyway but provides general info on what events you'd receive
    public void onGenericEvent(GenericEvent event) {
        System.out.printf("%d: %s - %s\n",
                event.getResponseNumber(),
                event.getClass().getName(),
                LocalTime.now()
        );
    }

    public void onGuildJoin(GuildJoinEvent event) {
        JorgJoinEvent gje = new JorgJoinEvent(event);
    }

    public void onGuildReady(GuildReadyEvent event) {
        JorgReadyEvent jre = new JorgReadyEvent(event);
    }

    public void onGuildMemberUpdateNickname(GuildMemberUpdateNicknameEvent event) {
        JordGuildMemberNickUpdate jgmn = new JordGuildMemberNickUpdate(event);
    }

    public void onGuildLeave(GuildLeaveEvent event) {
        JorgGuildLeaveEvent jgle = new JorgGuildLeaveEvent(event);
    }

    public void onGuildMemberLeave(GuildMemberLeaveEvent event) {
        JorgGuildMemberLeave jgml = new JorgGuildMemberLeave(event);
    }

    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        JorgGuildMemberJoin jgmj = new JorgGuildMemberJoin(event);
    }

    public void onGuildBan(GuildBanEvent event) {
        JorgGuildBan jgb = new JorgGuildBan(event);
    }

    public void onGuildUnban(GuildUnbanEvent event) {
        JorgGuildUnban jgu = new JorgGuildUnban(event);
    }

    public void onTextChannelDelete(TextChannelDeleteEvent event) {
        JorgTextChannelDelete jtcd = new JorgTextChannelDelete(event);
    }

    public void onUserUpdateOnlineStatus(UserUpdateOnlineStatusEvent event) {
        JorgUserUpdateOnlineStatus juuos = new JorgUserUpdateOnlineStatus(event);
    }

    //main command pipeline
    public void onMessageReceived(MessageReceivedEvent event){
        JorgMessageReceived jmr = new JorgMessageReceived(event);
    }
}