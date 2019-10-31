package events;

import net.dv8tion.jda.api.events.user.update.UserUpdateOnlineStatusEvent;

public class JorgUserUpdateOnlineStatus {
    private String userId;
    private String username;

    public JorgUserUpdateOnlineStatus(UserUpdateOnlineStatusEvent event){
        this.userId = event.getUser().getId();
        this.username = event.getUser().getName();
    }
}
