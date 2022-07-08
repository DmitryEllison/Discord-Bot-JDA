package dimka.blin.Lina.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BotProperties {
    private String token;
    private String ID;
    private String logChannelID;
    private String serverID;

    private Properties info = new Properties();

    public BotProperties(String botPropertiesURL){
        try{
            info.load(new FileInputStream(botPropertiesURL));
            this.token = info.getProperty("token");
            this.ID = info.getProperty("ID");
            this.logChannelID = info.getProperty("logChannelID");
            this.serverID = info.getProperty("serverID");
        } catch (IOException e) {
            System.out.println("Cannot find a token file.");
            e.printStackTrace();
            System.exit(0);
        }
    }

    public String getID() {
        return ID;
    }

    public String getToken() {
        return token;
    }

    public String getLogChannelID(){
        return logChannelID;
    }

    public String getServerID(){
        return serverID;
    }
}
