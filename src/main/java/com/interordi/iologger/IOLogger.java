package com.interordi.iologger;

import org.bukkit.plugin.java.JavaPlugin;


public class IOLogger extends JavaPlugin {

	public void onEnable() {
		new LoginListener(this);
		new ChatListener(this);
		/*
		MyCommandExecutor executor = new MyCommandExecutor(this);
		getCommand("basic").setExecutor(executor);
		getCommand("basic2").setExecutor(executor);
		*/
		
		getLogger().info("IOLogger enabled");
	}
	
	
	public void onDisable() {
		getLogger().info("IOLogger disabled");
	}
}
