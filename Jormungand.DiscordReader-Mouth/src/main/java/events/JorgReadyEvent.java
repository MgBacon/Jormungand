package events;

import net.dv8tion.jda.api.events.guild.*;

public class JorgReadyEvent implements GenericEvent {
    private String name;
    private long responsenumber;

    public JorgReadyEvent(GuildReadyEvent event){
        this.name = event.getGuild().getName();
        this.responsenumber = event.getResponseNumber();
    }

    public long getResponsenumber() {
        return responsenumber;
    }

    public String getName() {
        return name;
    }
}
