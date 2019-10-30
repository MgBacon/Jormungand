package events;

public class JorgJoinEvent implements GenericEvent{
    long joinDateLong=0;
    String guildName="";
    String guildId="";

    public JorgJoinEvent(long joinDateLong, String guildName, String guildId) {
        this.joinDateLong = joinDateLong;
        this.guildName = guildName;
        this.guildId = guildId;
    }
}
