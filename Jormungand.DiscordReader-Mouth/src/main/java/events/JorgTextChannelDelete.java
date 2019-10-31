package events;

import net.dv8tion.jda.api.events.channel.text.TextChannelDeleteEvent;

public class JorgTextChannelDelete {
    private String channelId;

    public JorgTextChannelDelete(TextChannelDeleteEvent event) {
        this.channelId = event.getChannel().getId();
    }

}
