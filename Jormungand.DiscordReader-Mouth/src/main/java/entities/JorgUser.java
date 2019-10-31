package entities;

import net.dv8tion.jda.api.entities.User;

public class JorgUser {
    String id;
    String username;
    String discriminator;
    String avatarUrl;

    public JorgUser(User user) {
        this.id = user.getId();
        this.username = user.getName();
        this.discriminator = user.getDiscriminator();
        this.avatarUrl = user.getAvatarUrl();
    }
}
