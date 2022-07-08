package dimka.blin.Lina.util;

import dimka.blin.Lina.Lina;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.time.Instant;

public class MessageLog extends ListenerAdapter {
    Lina bot;

    public MessageLog(Lina bot){
        this.bot = bot;
    }

    @Override
    public void onMessageReceived(final MessageReceivedEvent event){

        String channelId = event.getChannel().getId();
        String member = event.getAuthor().getAsTag();
        String message = event.getMessage().getContentRaw();
        String messageId = event.getMessageId();
        String jumpURL = event.getJumpUrl();

        // not allow to log itself
        if (event.getChannel().getId().equals(this.bot.getBP().getLogChannelID())) return;

        // send message
        EmbedBuilder log = new EmbedBuilder();

        log.setTimestamp(Instant.now());
        log.setColor(new Color(149, 192, 255, 255));
        log.setTitle("Message log");
        log.addField("Channel", "<#"+channelId+">", false);
        log.addField("Member", member, false);
        log.addField("Message", message, false);
        log.addField("Message ID", messageId, false);
        log.addField("Jump", "[Click to jump to message]("+jumpURL+")", false);

        event.getJDA().getGuildById(this.bot.getBP().getServerID()).
                getTextChannelById(this.bot.getBP().getLogChannelID()).
                sendMessageEmbeds(log.build()).queue();
        log.clear();
    }
}
