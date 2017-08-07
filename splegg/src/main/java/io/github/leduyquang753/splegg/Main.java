package io.github.leduyquang753.splegg;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.leduyquang753.splegg.listeners.GriefPrevention;
import io.github.leduyquang753.splegg.listeners.CommListener;
import io.github.leduyquang753.splegg.listeners.PlayerJoin;
import io.github.leduyquang753.splegg.listeners.Shoot;

public final class Main extends JavaPlugin {
	
	private static Main _instance;
	public Plugin plugin;
	
	@Override
	public void onEnable() {
		this.plugin = plugin;
		getCommand("gun").setExecutor(new CommListener());
		Bukkit.getPluginManager().registerEvents(new PlayerJoin(), this);
		Bukkit.getPluginManager().registerEvents(new Shoot(), this);
		Bukkit.getPluginManager().registerEvents(new GriefPrevention(), this);
		
		getLogger().info("The Splegg engine test plugin has been successfully enabled.");
		_instance = this;
	}
	
	@Override
	public void onDisable() {
		getLogger().info("The Splegg engine test plugin has been successfully disabled.");
		getLogger().info("Plugin by Le Duy Quang (github.com/leduyquang753).");
	}
	
	public static Main getInstance() {
		return(_instance);
	}
}
