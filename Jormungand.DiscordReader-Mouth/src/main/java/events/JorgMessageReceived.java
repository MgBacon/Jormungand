package events;

import entities.JorgUser;
import net.dv8tion.jda.api.entities.ChannelType;
import java.util.List;

public class JorgMessageReceived {
    String rawMessageContent;
    List<JorgUser> mentions;
    String channelId;
    ChannelType channelType;
    JorgUser author;

    public JorgMessageReceived(String rawMessageContent, List mentions, String channelId, ChannelType channelType, JorgUser author) {
        this.rawMessageContent = rawMessageContent;
        this.mentions = mentions;
        this.channelId = channelId;
        this.channelType = channelType;
        this.author = author;
    }
}
