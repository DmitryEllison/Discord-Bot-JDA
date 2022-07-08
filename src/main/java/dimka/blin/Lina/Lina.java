package dimka.blin.Lina;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Lina {
    private static String token = "OTkzOTk3Njg2NzQ1MzQxOTYy.GjFeYq.iQ6BsmvKzw8EIvKxHNdbNTXoF9zwyEkdET_SNE";
    private JDA bot;

    public Lina(String token, OnlineStatus status) throws LoginException {
        try{
            this.bot = JDABuilder.createDefault(token).
                    setActivity(Activity.playing("NO GAME")).
                    setStatus(status).
                    build();
        } catch (LoginException e){
            System.out.println("Incorrect token");
        }

    }

    public static void main(String[] args) throws LoginException {
        Lina bot = new Lina(token, OnlineStatus.IDLE);
    }
}
