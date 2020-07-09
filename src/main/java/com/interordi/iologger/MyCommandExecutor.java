package com.interordi.iologger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.command.CommandExecutor;


public class MyCommandExecutor implements CommandExecutor {
	
	@SuppressWarnings("unused")
	private IOLogger plugin;
	
	
	public MyCommandExecutor(IOLogger plugin) {
		this.plugin = plugin;
	}
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Player player = null;
		if (sender instanceof Player) {
			player = (Player) sender;
		}
		/*
		else {
			sender.sendMessage(ChatColor.RED + "You must be a player!");
			return false;
		}
		*/
		
		if (cmd.getName().equalsIgnoreCase("basic")) {
			//Do something
			sender.sendMessage("Success!");
			return true;
		} else if (cmd.getName().equalsIgnoreCase("basic2")) {
			if (args.length < 1) {
				sender.sendMessage("Missing argument");
				return false;
			} else if (args.length > 1) {
				sender.sendMessage(ChatColor.RED + "Too many arguments");
				return false;
			}
			
			Player other = null;
			other = (Bukkit.getServer().getPlayer(args[0]));
			
			if (other == null) {
				//OfflinePlayer class provides basic manipulation methods for offline players
				sender.sendMessage(ChatColor.RED + args[0] + " is not online!");
				return false;
			}
			
			if (player == null) {
				sender.sendMessage("Command only available to players.");
				return false;
			} else {
				if (player.hasPermission("iologger.basic2")) {
					return true;
					//Do something
					//boolean isPermissionSet(String name)
					
					/*
					for(Player player : getServer().getOnlinePlayers()) {}
					*/
				} else {
					//Do something else
					return true;
				}
			}
		}
	
		//Always return false if no match
		return false;
	}
}
