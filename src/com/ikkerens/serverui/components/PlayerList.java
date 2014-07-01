package com.ikkerens.serverui.components;

import java.awt.Component;

import javax.swing.JLabel;

import com.ikkerens.serverui.ServerUIPlugin;
import com.mbserver.api.events.EventHandler;
import com.mbserver.api.events.Listener;
import com.mbserver.api.events.PlayerLoginEvent;
import com.mbserver.api.events.PostPlayerLoginEvent;
import com.mbserver.api.game.Player;

public class PlayerList extends ListComponent<Player> implements Listener {
	
	public PlayerList(ServerUIPlugin plugin) {
		super(plugin);
		plugin.getPluginManager().registerEventHandler(this);
	}

	private static final long serialVersionUID = 1337L;

	@Override
	protected Component renderItem(Player item, int index, boolean selected,boolean focused) {
		final JLabel label = new JLabel();
		
		label.setText(String.format("     %s    ",item.getDisplayName()));
		return label;
	}

	@Override
	protected void onSelect(Player item, int index) {
		
	}
	
	@EventHandler
	public void onLogout(PlayerLoginEvent e){
		this.setData(e.getServer().getPlayers());
	}
	
	@EventHandler
	public void onLogin(PostPlayerLoginEvent e){
		this.setData(e.getServer().getPlayers());
	}

}
