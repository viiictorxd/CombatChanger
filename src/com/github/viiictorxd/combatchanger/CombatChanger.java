package com.github.viiictorxd.combatchanger;

import com.github.viiictorxd.combatchanger.command.CommandCombat;
import com.github.viiictorxd.combatchanger.listener.BaseListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class CombatChanger extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();

        registerCommand();
        registerListener();

        updateAll();
    }

    private void registerCommand() {
        getCommand("combat").setExecutor(new CommandCombat(this));
    }

    private void registerListener() {
        Bukkit.getPluginManager().registerEvents(new BaseListener(this), this);
    }

    public void updateAll() {
        for (Player onlinePlayer : Bukkit.getOnlinePlayers())
            onlinePlayer.setMaximumNoDamageTicks(getConfig().getInt("combat.hit_delay", 10));
    }
}
