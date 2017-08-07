package io.github.leduyquang753.splegg;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
	
	private static Main _instance;
	
	@Override
	public void onEnable() {
		getCommand("gun").setExecutor(new CommListener());
		getServer().getPluginManager().registerEvents(new Shoot(), this);
		getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
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
