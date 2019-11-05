package events;

import net.dv8tion.jda.api.events.guild.member.update.GuildMemberUpdateNicknameEvent;

public class JordGuildMemberNickUpdate implements GenericEvent {
    private String oldNick = "";
    private String newNick = "";
    private String guildName = "";
    private String guildId = "";
    private String username = "";
    private String userId = "";

    public JordGuildMemberNickUpdate(GuildMemberUpdateNicknameEvent event) {
        this.oldNick = event.getOldNickname();
        this.newNick = event.getNewNickname();
        this.guildName = event.getGuild().getName();
        this.guildId = event.getGuild().getId();
        this.username = event.getUser().getName();
        this.userId = event.getUser().getId();
    }
}
