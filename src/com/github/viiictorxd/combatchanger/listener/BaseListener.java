package com.github.viiictorxd.combatchanger.listener;

import com.github.viiictorxd.combatchanger.CombatChanger;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class BaseListener implements Listener {

    private final CombatChanger combatChanger;

    public BaseListener(CombatChanger combatChanger) {
        this.combatChanger = combatChanger;
    }

    @EventHandler(priority = EventPriority.LOWEST)
    private void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().setMaximumNoDamageTicks(combatChanger.getConfig().getInt("combat.hit_delay", 10));
    }
}
