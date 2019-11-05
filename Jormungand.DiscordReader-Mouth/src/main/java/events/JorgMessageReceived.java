package events;

import entities.JorgUser;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.ArrayList;

public class JorgMessageReceived {
    private String rawMessageContent;
    private ArrayList<JorgUser> mentions;
    private String channelId;
    private ChannelType channelType;
    private JorgUser author;

    public JorgMessageReceived(MessageReceivedEvent event){
        this.rawMessageContent = event.getMessage().getContentRaw();
        this.mentions = new ArrayList<JorgUser>();
        for(Member member : event.getMessage().getMentionedMembers()){
            JorgUser ju = new JorgUser(member.getUser());
            this.mentions.add(ju);
        }
        this.channelId = event.getChannel().getId();
        this.channelType = event.getChannelType();
        this.author = new JorgUser(event.getAuthor());
    }
}
