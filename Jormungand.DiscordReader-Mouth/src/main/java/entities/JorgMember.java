package entities;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.internal.requests.Route;

import java.util.List;

public class JorgMember {
    User user;
    List<String> roles; //Strings of JDA role names, role colours doesn't matter
}
