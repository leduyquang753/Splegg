package io.github.leduyquang753.splegg.listeners;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.entity.Egg;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.BlockIterator;
import org.bukkit.util.Vector;

public final class Shoot implements Listener {
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerUse(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		if (player.getItemInHand().getType() == Material.IRON_BARDING) {
			Egg bullet = player.getWorld().spawn(player.getLocation(), Egg.class);
			bullet.setVelocity(player.getLocation().getDirection());
			bullet.setShooter(player);
			player.getWorld().playSound(player.getLocation(), Sound.ENTITY_EGG_THROW, 1, 1);
		}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onEggHit(ProjectileHitEvent event) {
		BlockIterator iterator = new BlockIterator(event.getEntity().getWorld(), event.getEntity().getLocation().toVector(), event.getEntity().getVelocity().normalize(), 0.0D, 4);
		Block hit = null;
		
		while(iterator.hasNext()) {
			hit = iterator.next();
			
			if(hit.getTypeId() != 0) {
				break;
			}
		}
		hit.getWorld().playSound(hit.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1, 1);
		hit.setType(Material.AIR);
	}
}
