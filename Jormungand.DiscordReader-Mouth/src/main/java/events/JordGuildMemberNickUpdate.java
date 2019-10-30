package events;

public class JordGuildMemberNickUpdate implements GenericEvent {
    String oldNick="";
    String newNick="";
    String guildName="";
    String guildId="";
    String username="";
    String userId="";

    public JordGuildMemberNickUpdate(String oldNick, String newNick, String guildName, String guildId, String username, String userId) {
        this.oldNick = oldNick;
        this.newNick = newNick;
        this.guildName = guildName;
        this.guildId = guildId;
        this.username = username;
        this.userId = userId;
    }
}
