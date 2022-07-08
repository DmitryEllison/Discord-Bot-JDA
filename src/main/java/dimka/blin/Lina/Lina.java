package dimka.blin.Lina;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Lina {
    private static String token;
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

    public static void main(String[] args) throws LoginException, IOException {
        Properties info = new Properties();
        try{
            info.load(new FileInputStream("C:\\Users\\dimka\\IdeaProjects\\Lina\\src\\main\\java\\dimka\\blin\\Lina\\token.cfg"));
            token = info.getProperty("token");
        } catch (IOException e){
            System.out.println("Cannot find a token file.");
            e.printStackTrace();
            System.exit(0);
        }

        Lina bot = new Lina(token, OnlineStatus.IDLE);
    }
}
