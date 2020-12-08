package com.github.viiictorxd.combatchanger.command;

import com.github.viiictorxd.combatchanger.CombatChanger;
import com.github.viiictorxd.combatchanger.CombatChangerUtil;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandCombat implements CommandExecutor {

    private final CombatChanger combatChanger;

    public CommandCombat(CombatChanger combatChanger) {
        this.combatChanger = combatChanger;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof Player
                && !commandSender.hasPermission("combatchanger.command.use")) {
            commandSender.sendMessage(
                    ChatColor.translateAlternateColorCodes('&', combatChanger.getConfig().getString("message.no_permission")));
            return false;
        }

        if (args.length == 0) {
            commandSender.sendMessage(
                    ChatColor.translateAlternateColorCodes('&', combatChanger.getConfig().getString("message.no_argument")));
            return false;
        }

        int newDelay = CombatChangerUtil.getInteger(args[0]);
        if (newDelay <= -1) {
            commandSender.sendMessage(
                    ChatColor.translateAlternateColorCodes('&', combatChanger.getConfig().getString("message.error_min_delay")));
            return false;
        }

        combatChanger.getConfig().set("combat.hit_delay", newDelay);
        combatChanger.saveConfig();

        combatChanger.updateAll();

        commandSender.sendMessage(
                ChatColor.translateAlternateColorCodes('&', combatChanger.getConfig().getString("message.delay_changed")
                    .replace("{delay}", String.valueOf(newDelay))));
        return false;
    }
}
