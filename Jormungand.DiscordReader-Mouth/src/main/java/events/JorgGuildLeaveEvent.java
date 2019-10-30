package events;

import net.dv8tion.jda.api.events.guild.GuildLeaveEvent;

public class JorgGuildLeaveEvent {
    private String name;
    private long responseNumber;

    public JorgGuildLeaveEvent(GuildLeaveEvent event){
        this.name = event.getGuild().getName();
        this.responseNumber = event.getResponseNumber();
    }
}
