package events;

import net.dv8tion.jda.api.events.guild.GuildUnbanEvent;

public class JorgGuildUnban{
    private String guildId;
    private String userId;
    private String username;

    public JorgGuildUnban(GuildUnbanEvent event){
        this.guildId = event.getGuild().getId();
        this.userId = event.getUser().getId();
        this.username = event.getUser().getName();
    }
}
