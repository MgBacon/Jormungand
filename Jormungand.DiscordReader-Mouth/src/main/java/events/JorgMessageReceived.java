package events;

import entities.JorgUser;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.List;

public class JorgMessageReceived {
    private String rawMessageContent;
    private List<JorgUser> mentions;
    private String channelId;
    private ChannelType channelType;
    private JorgUser author;

    public JorgMessageReceived(MessageReceivedEvent event){
        this.rawMessageContent = event.getMessage().getContentRaw();
        for(Member member : event.getMessage().getMentionedMembers()){
            User user = member.getUser();
            JorgUser ju = new JorgUser(user);
            assert false;
            this.mentions.add(ju);
        }
        this.channelId = event.getChannel().getId();
        this.channelType = event.getChannelType();
        this.author = new JorgUser(event.getAuthor());
    }
}
