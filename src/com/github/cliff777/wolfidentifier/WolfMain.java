package com.github.cliff777.wolfidentifier;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class WolfMain extends JavaPlugin {
	public static WolfMain plugin;
	static int id;
	public ItemStack itemNeeded;
	
	public void onEnable() {
		plugin = this;
		FileStuffs fs = new FileStuffs();
		id = fs.getID();
		getServer().getPluginManager().registerEvents(new WolfListener(), this);
		
		try {
			itemNeeded = new ItemStack(Material.STICK, 1);
		} catch (Exception e) {
			out("Config is wrongly formatted! Creating new config...");
			fs.setupConfig();
			getServer().getPluginManager().disablePlugin(this);
		}
	}
	
	public void onDisable() {
		
	}
	
	public static ItemStack itemNeeded() {
		return new ItemStack(Material.getMaterial(id));
	}
	
	public void out(String s) {
		getLogger().info(s);
	}

}
