package events;

import net.dv8tion.jda.api.events.guild.member.GuildMemberLeaveEvent;

public class JorgGuildMemberLeave {
    private String guildId;
    private String userId;
    private String username;

    public JorgGuildMemberLeave(GuildMemberLeaveEvent event){
        this.guildId = event.getGuild().getId();
        this.userId = event.getUser().getId();
        this.username = event.getUser().getName();
    }
}
