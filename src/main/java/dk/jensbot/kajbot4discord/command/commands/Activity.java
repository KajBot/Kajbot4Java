package dk.jensbot.kajbot4discord.command.commands;

import dk.jensbot.kajbot4discord.command.Command;
import dk.jensbot.kajbot4discord.command.CommandEvent;
import dk.jensbot.kajbot4discord.utils.Language;
import net.dv8tion.jda.api.entities.Activity.ActivityType;

public class Activity extends Command {
    public Activity() {
        this.name = "activity";
        this.adminCommand = true;
    }

    @Override
    public void execute(CommandEvent e) {
        if (e.getArgsSplit().get(0).length() < 1) return;

        if (e.getArgsSplit().get(0).equalsIgnoreCase("playing"))
            e.getArgsSplit().set(0, ActivityType.DEFAULT.toString());
        if (!(e.getArgsSplit().get(0).equalsIgnoreCase(ActivityType.DEFAULT.toString()) || e.getArgsSplit().get(0).equalsIgnoreCase(ActivityType.LISTENING.toString()) || e.getArgsSplit().get(0).equalsIgnoreCase(ActivityType.WATCHING.toString()) || e.getArgsSplit().get(0).equalsIgnoreCase(ActivityType.STREAMING.toString())))
            return;

        e.getJDA().getPresence().setActivity(net.dv8tion.jda.api.entities.Activity.of(ActivityType.valueOf(e.getArgsSplit().get(0).toUpperCase()), e.getJDA().getPresence().getActivity() == null ? "N/A" : e.getJDA().getPresence().getActivity().getName()));
        e.reply((Language.lang.getProperty("Status.SET")).replace("%STATUS%", e.getArgsSplit().get(0).toUpperCase()));
    }
}