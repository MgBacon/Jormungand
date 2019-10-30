package events;

import net.dv8tion.jda.api.events.guild.GuildBanEvent;

public class JorgGuildBan {
    private String userId;
    private String username;
    private String guildName;

    public JorgGuildBan(GuildBanEvent event) {
        this.userId = event.getUser().getId();
        this.username = event.getUser().getName();
        this.guildName = event.getGuild().getName();
    }
}
