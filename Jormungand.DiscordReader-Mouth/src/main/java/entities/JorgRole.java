package entities;

import net.dv8tion.jda.api.entities.Role;

public class JorgRole {
    private String roleName;
    private JorgPerms jorgPerms;

    public JorgRole(Role role){
        this.roleName = role.getName();
        this.jorgPerms = new JorgPerms(role.getPermissionsRaw());
    }
}
