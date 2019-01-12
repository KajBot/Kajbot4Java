package support.kajstech.kajbot.command.commands;

import net.dv8tion.jda.core.OnlineStatus;
import support.kajstech.kajbot.Bot;
import support.kajstech.kajbot.Language;
import support.kajstech.kajbot.command.Command;
import support.kajstech.kajbot.command.CommandEvent;

public class Status extends Command {
    public Status() {
        this.name = "status";
    }

    @Override
    public void execute(CommandEvent e) {
        if (e.getArgsSplit().get(0).length() < 1) return;


        if (e.getArgsSplit().get(0).equalsIgnoreCase("dnd"))
            e.getArgsSplit().set(0, OnlineStatus.DO_NOT_DISTURB.toString());
        if (!(e.getArgsSplit().get(0).equalsIgnoreCase(OnlineStatus.INVISIBLE.toString()) || e.getArgsSplit().get(0).equalsIgnoreCase(OnlineStatus.ONLINE.toString()) || e.getArgsSplit().get(0).equalsIgnoreCase(OnlineStatus.DO_NOT_DISTURB.toString()) || e.getArgsSplit().get(0).equalsIgnoreCase(OnlineStatus.IDLE.toString())))
            return;


        Bot.jda.getPresence().setStatus(OnlineStatus.valueOf(e.getArgsSplit().get(0).toUpperCase()));
        e.getEvent().getChannel().sendMessage((Language.getMessage("Status.SET")).replace("%STATUS%", e.getArgsSplit().get(0).toUpperCase())).queue();
    }
}