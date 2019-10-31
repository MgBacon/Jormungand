package entities;

import net.dv8tion.jda.api.entities.Guild;

public class JorgGuild {
    String guildId;
    String guildName;
    String guildIconUrl;

    public JorgGuild(Guild guild){
        this.guildId = guild.getId();
        this.guildName = guild.getName();
        this.guildIconUrl = guild.getIconUrl();
    }
}
