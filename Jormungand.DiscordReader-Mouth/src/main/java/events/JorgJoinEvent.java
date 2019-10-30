package events;

import net.dv8tion.jda.api.events.guild.GuildJoinEvent;

public class JorgJoinEvent implements GenericEvent{
    long joinDateLong=0;
    String guildName="";
    String guildId="";

    public JorgJoinEvent(GuildJoinEvent event) {
        this.joinDateLong = event.getGuild().getSelfMember().getTimeJoined().toEpochSecond();
        this.guildName = event.getGuild().getName();
        this.guildId = event.getGuild().getId();
    }
}
