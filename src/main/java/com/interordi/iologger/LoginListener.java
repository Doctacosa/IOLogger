package com.interordi.iologger;

import org.bukkit.event.player.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;


public class LoginListener implements Listener {
	
	@SuppressWarnings("unused")
	private IOLogger plugin;
	
	public LoginListener(IOLogger plugin) {
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	
	@EventHandler	//Annotation - EventPriority.NORMAL by default
	//@EventHandler(priority = EventPriority.HIGHEST) // Makes your event Highest priority
	//@EventHandler(priority = EventPriority.LOW) // Makes your event Low priority
	public void onPlayerLogin(PlayerJoinEvent event) {
		//event.getPlayer().sendMessage("Hi " + event.getPlayer().getDisplayName() + "!");
		//plugin.getLogger().info(event.getPlayer().getDisplayName() + " logged in");
		//My code here
	}
}
