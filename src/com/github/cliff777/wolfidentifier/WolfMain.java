package com.github.cliff777.wolfidentifier;

import org.bukkit.plugin.java.JavaPlugin;

public class WolfMain extends JavaPlugin {
	public static WolfMain plugin;
	static int id;
	
	public void onEnable() {
		plugin = this;
		FileStuffs fs = new FileStuffs();
		id = fs.getID();
		getServer().getPluginManager().registerEvents(new WolfListener(), this);
	}
	
	public void onDisable() {
		
	}
	
	public void out(String s) {
		getLogger().info(s);
	}

}
