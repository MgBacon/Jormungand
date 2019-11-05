package entities;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;

import java.util.ArrayList;

public class JorgMember {
    private JorgUser user;
    private ArrayList<JorgRole> roles; //Strings of JDA role names, role colours doesn't matter

    public JorgMember(Member member){
        this.user = new JorgUser(member.getUser());
        this.roles = new ArrayList<JorgRole>();
        for(Role role : member.getRoles()){
            JorgRole jr = new JorgRole(role);
            this.roles.add(jr);
        }
    }
}
