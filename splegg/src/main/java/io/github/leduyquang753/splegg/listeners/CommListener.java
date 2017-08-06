package io.github.leduyquang753.splegg.listeners;

import java.util.List;
import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import io.github.leduyquang753.splegg.Main;

public final class CommListener implements Listener {
	@EventHandler
	public void onCommand(CommandSender player, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("gun")) {
			player.sendMessage(ChatColor.YELLOW + "OK. Here is your gun. Keep it safe.");
			ItemStack gun = new ItemStack(Material.IRON_BARDING);
			ItemMeta meta = gun.getItemMeta();
			
			meta.setDisplayName(ChatColor.YELLOW + "Splegg gun");
			
			List<String> lore = new ArrayList<String>();
			lore.add("Right click to shoot.");
			lore.add("It will erase every blocks. So be careful!");
			
			meta.setLore(lore);
			gun.setItemMeta(meta);
			
			PlayerInventory inven = ((HumanEntity) player).getInventory();
			inven.addItem(gun);
			
			Main.getInstance().getLogger().info("A Splegg gun has been given to a player.");
		}
	}
}
