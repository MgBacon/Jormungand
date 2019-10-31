package entities;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;

import java.util.List;

public class JorgMember {
    User user;
    List<Role> roles; //Strings of JDA role names, role colours doesn't matter

    public JorgMember(Member member){
        this.user = member.getUser();
        this.roles = member.getRoles();
    }
}
