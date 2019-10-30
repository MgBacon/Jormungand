package events;

import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;

public class JorgGuildMemberJoin {
    private String guildId;
    private String userId;
    private String username;

    public JorgGuildMemberJoin(GuildMemberJoinEvent event){
        this.guildId = event.getGuild().getId();
        this.userId = event.getUser().getId();
        this.username = event.getUser().getName();
    }
}
