package entities;

import net.dv8tion.jda.api.entities.User;

public class JorgUser {
    private boolean isBot;
    private String id;
    private String username;
    private String discriminator;
    private String avatarUrl;

    public JorgUser(User user) {
        this.isBot = user.isBot();
        this.id = user.getId();
        this.username = user.getName();
        this.discriminator = user.getDiscriminator();
        this.avatarUrl = user.getAvatarUrl();
    }
}
