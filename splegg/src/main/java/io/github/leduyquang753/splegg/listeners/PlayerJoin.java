package io.github.leduyquang753.splegg.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public final class PlayerJoin implements Listener {
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		player.sendMessage(ChatColor.GREEN + "Welcome to the Splegg test server!");
		ItemStack test = new ItemStack(Material.IRON_BARDING);
		if (player.getInventory().contains(test)) {
			player.sendMessage(ChatColor.GREEN + "To start, type " + ChatColor.YELLOW + "/gun" + ChatColor.GREEN + ".");
		}
	}
}
