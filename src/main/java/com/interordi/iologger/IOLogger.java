package com.interordi.iologger;

import org.bukkit.plugin.java.JavaPlugin;


public class IOLogger extends JavaPlugin {

	public void onEnable() {
		new ChatListener(this);
		
		getLogger().info("IOLogger enabled");
	}
	
	
	public void onDisable() {
		getLogger().info("IOLogger disabled");
	}
}
