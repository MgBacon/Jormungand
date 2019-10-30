package entities;

import net.dv8tion.jda.api.entities.User;

public class JorgUser {
    String id;
    String username;
    String discriminator;
    String avatarUrl;

    public JorgUser(User user) {
        id=user.getId();
        username=user.getName();
        discriminator=user.getDiscriminator();
        avatarUrl=user.getAvatarUrl();
    }
}
