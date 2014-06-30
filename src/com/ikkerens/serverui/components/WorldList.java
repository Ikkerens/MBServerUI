package com.ikkerens.serverui.components;

import java.awt.Component;

import javax.swing.JLabel;

import com.ikkerens.serverui.ServerUIPlugin;
import com.mbserver.api.events.EventHandler;
import com.mbserver.api.events.Listener;
import com.mbserver.api.events.ServerStartedEvent;
import com.mbserver.api.game.World;

public class WorldList extends ListComponent<World> implements Listener{
	
	public WorldList(ServerUIPlugin plugin) {
		super(plugin);
		plugin.getPluginManager().registerEventHandler(this);
	}

	private static final long serialVersionUID = 1337L;

	@Override
	protected Component renderItem(World item, int index, boolean selected,boolean focused) {
		JLabel label = new JLabel();
		label.setText(String.format("     %s     ",item.getWorldName()));
		return label;
	}

	@Override
	protected void onSelect(World item, int index) {
		// TODO Auto-generated method stub
		
	}
	
	@EventHandler
	public void onLoad(ServerStartedEvent e){
		this.setData(e.getServer().getWorlds());
	}

}
