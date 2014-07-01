package com.ikkerens.serverui.components;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

import com.ikkerens.serverui.ServerUIPlugin;
import com.mbserver.api.events.EventHandler;
import com.mbserver.api.events.Listener;
import com.mbserver.api.events.PlayerPvpEvent;

public class SettingsEditor extends JPanel implements Listener{
	private static final long serialVersionUID = 1337L;

	private JCheckBox pvp;
	private boolean PvpAllowed;
	
	public SettingsEditor(ServerUIPlugin plugin) {
		PvpAllowed = false;
		plugin.getPluginManager().registerEventHandler(this);
		
		this.setLayout( new BorderLayout() );
		this.add(this.getCheckBoxes(),BorderLayout.WEST);
	}
	
	private JPanel getCheckBoxes(){
		final JPanel panel = new JPanel();
		panel.setLayout( new BoxLayout( panel , BoxLayout.Y_AXIS ) );
		pvp = new JCheckBox("Enable PvP");
		pvp.setSelected(false);
		pvp.addItemListener( new PvPHandler() );
		panel.add(pvp);
		return panel;
	}
	
	private class PvPHandler implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.SELECTED)
				PvpAllowed = true;
			
			else
				PvpAllowed = false;
		}
		
	}
	
	@EventHandler
	public void onPvP(PlayerPvpEvent e){
		if(!PvpAllowed)
			e.setCancelled(true);
	}
	
}
