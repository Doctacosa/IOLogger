package com.interordi.iologger;

import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.java.JavaPlugin;


public class IOLogger extends JavaPlugin {

	public void onEnable() {
		new ChatListener(this);
		
		//Enable metrics
		@SuppressWarnings("unused")
		Metrics metrics = new Metrics(this, 32026);

		getLogger().info("IOLogger enabled");
	}
	
	
	public void onDisable() {
		getLogger().info("IOLogger disabled");
	}
}
