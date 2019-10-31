package entities;

import net.dv8tion.jda.api.entities.Guild;

public class JorgGuild {
    private String guildId;
    private String guildName;
    private String guildIconUrl;

    public JorgGuild(Guild guild){
        this.guildId = guild.getId();
        this.guildName = guild.getName();
        this.guildIconUrl = guild.getIconUrl();
    }
}
