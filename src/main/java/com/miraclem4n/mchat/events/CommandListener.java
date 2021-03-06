package com.miraclem4n.mchat.events;

import com.miraclem4n.mchat.MChat;
import com.miraclem4n.mchat.configs.ConfigUtil;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.TreeSet;

public class CommandListener implements Listener {
    MChat plugin;

    public CommandListener(MChat instance) {
        plugin = instance;
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
        String msg = event.getMessage();
        String command = msg.split(" ")[0].replace("/", "");

        TreeSet<String> commands = new TreeSet<String>();

        commands.add("mchat");
        commands.add("mchatme");
        commands.add("mchatuser");
        commands.add("mchatgroup");
        commands.add("mchatwho");
        commands.add("mchatlist");
        commands.add("mchatsay");
        commands.add("mchatafk");
        commands.add("mchatafkother");
        commands.add("mchatshout");
        commands.add("mchatmute");
        commands.add("mchatmessageprefix");
        commands.add("pmchat");
        commands.add("pmchatreply");
        commands.add("pmchatinvite");
        commands.add("pmchataccept");
        commands.add("pmchatdeny");
        commands.add("mchannel");

        for (String oCommand : commands.descendingSet())
            for (String string : ConfigUtil.getConfig().getStringList("aliases." + oCommand))
                if (command.equalsIgnoreCase(string)) {
                    event.setMessage(msg.replaceFirst("/" + string, "/" + oCommand));
                    return;
                }
    }
}
