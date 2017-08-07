package io.github.leduyquang753.splegg.listeners;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.entity.Egg;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.BlockIterator;

public final class Shoot implements Listener {
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerUse(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		if (player.getItemInHand().getType() == Material.IRON_BARDING) {
			Egg bullet = player.getWorld().spawn(player.getEyeLocation(), Egg.class);
			bullet.setVelocity(player.getEyeLocation().getDirection());
			bullet.setVelocity(bullet.getVelocity().multiply(2));
			bullet.setShooter(player);
			player.getWorld().playSound(player.getEyeLocation(), Sound.ENTITY_EGG_THROW, 1, 0);
		}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onEggHit(ProjectileHitEvent event) {
		BlockIterator iterator = new BlockIterator(event.getEntity().getWorld(), event.getEntity().getLocation().toVector(), event.getEntity().getVelocity().normalize(), 0.0D, 4);
		Block hit = null;
		boolean isTNT = false;
		
		while(iterator.hasNext()) {
			hit = iterator.next();
			
			if(hit.getTypeId() != 0) {
				break;
			}
		}
		if (event.getEntity().getType() == EntityType.EGG) {
			hit.getWorld().playSound(hit.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1, 0);
			if (hit.getType() == Material.TNT) {
				isTNT = true;
			}
			hit.setType(Material.AIR);
			if (isTNT) {
				TNTPrimed tnt = (TNTPrimed) hit.getWorld().spawn(hit.getLocation(), TNTPrimed.class);
				tnt.setFuseTicks(0);
			}
		}
	}
}
