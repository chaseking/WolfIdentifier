package com.github.cliff777.wolfidentifier;

import org.bukkit.ChatColor;
import org.bukkit.entity.Tameable;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class WolfListener implements Listener {
	
	@EventHandler
	public void onEntityInteract(PlayerInteractEntityEvent event) {
		if(event.getRightClicked() instanceof Wolf && 
			event.getPlayer().getItemInHand().getAmount() == 1 && 
			event.getPlayer().getItemInHand().getTypeId() == WolfMain.id &&
			event.getPlayer().hasPermission("wolfidentifier.use")) {
			
			event.getPlayer().sendMessage( ChatColor.GREEN + "Owner: " + ChatColor.BLUE + ((Tameable) event.getRightClicked()).getOwner().getName());
			event.setCancelled(true);
		}
	}

}
