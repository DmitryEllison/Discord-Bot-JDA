import dimka.blin.Lina.Lina;
import net.dv8tion.jda.api.OnlineStatus;

import javax.security.auth.login.LoginException;
public class main {
    private static String botProperties = "src\\main\\resources\\src\\token.properties";
    private static String gameName = "NO GAME";

    public static void main(String[] args) throws LoginException{
        Lina bot = new Lina(botProperties, gameName, OnlineStatus.ONLINE);
    }
}
