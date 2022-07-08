package dimka.blin.Lina;

import dimka.blin.Lina.util.BotProperties;
import dimka.blin.Lina.util.MessageLog;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Lina {
    private JDA bot;
    private BotProperties BP;

    public Lina(String botPropertiesURL, String gameName, OnlineStatus status) throws LoginException {
        BP = new BotProperties(botPropertiesURL);
        try{
            this.bot = JDABuilder.createDefault(BP.getToken()).
                    setActivity(Activity.playing(gameName)).
                    setStatus(status).
                    setAutoReconnect(true).
                    addEventListeners(new MessageLog(this)).
                    build();
        } catch (LoginException e){
            System.out.println("Incorrect token");
        }


    }

    public BotProperties getBP() {
        return BP;
    }
}
