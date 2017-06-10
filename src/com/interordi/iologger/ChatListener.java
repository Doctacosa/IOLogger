package com.interordi.iologger;

import org.bukkit.entity.Player;
import org.bukkit.event.player.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.Location;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class ChatListener implements Listener {

	private IOLogger plugin;
	
	public ChatListener(IOLogger plugin) {
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event) {
		log(event.getPlayer(), event.getMessage(), "chat");
	}
	
	
	 @EventHandler
	 public void onPlayerCommand(PlayerCommandPreprocessEvent event) {
		 log(event.getPlayer(), event.getMessage(), "command");
	 }
	 
	 
	@EventHandler
	public void onPlayerJoin(PlayerLoginEvent event) {
		log(event.getPlayer(), "[" + event.getPlayer().getDisplayName() + " joined]", "chat");
	}
	
	
	@EventHandler
	public void onPlayerLogout(PlayerQuitEvent event) {
		log(event.getPlayer(), "[" + event.getPlayer().getDisplayName() + " left]", "chat");
	}
	
	
	private void log(Player sender, String message, String type) {
		//Get the log data
		Location pos = sender.getLocation();

		//Get the current date and time
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		
		String log = timeFormat.format(date) + " | " + sender.getDisplayName() + "@" + pos.getWorld().getName() + "(" + Math.round(pos.getX()) + "," + Math.round(pos.getY()) + "," + Math.round(pos.getZ()) + "): " + message;
		
		try {
			String folder = "plugins/IOLogger/logs/" + type + "/";
			new File(folder).mkdirs();
			
			File file = new File(folder + dateFormat.format(date) + ".txt");
			
			//If the file doesn't exist, create it
			if (!file.exists()) {
				file.createNewFile();
			}
			
			//Second parameter true = appends
			FileWriter writer = new FileWriter(folder + file.getName(), true);
			BufferedWriter buffer = new BufferedWriter(writer);
			buffer.write(log + "\n");
			buffer.close();
		
		} catch (IOException e) {
			String errorMsg = e.getMessage();
			if (errorMsg == null)	errorMsg = "";
			plugin.getLogger().info("Failed log writing: " + errorMsg);
		}
		
		//plugin.getLogger().info(log);
	 }
}
