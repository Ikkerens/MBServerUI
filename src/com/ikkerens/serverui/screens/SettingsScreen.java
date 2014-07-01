package com.ikkerens.serverui.screens;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import com.ikkerens.serverui.Screen;
import com.ikkerens.serverui.ServerUIPlugin;
import com.ikkerens.serverui.components.SettingsEditor;

public class SettingsScreen extends Screen{

	@Override
	protected String getTabTitle() {
		return "Settings";
	}

	@Override
	protected JPanel buildContents(ServerUIPlugin plugin) {
		final JPanel panel = new JPanel();
		panel.setLayout( new BorderLayout() );
		panel.add( new SettingsEditor( plugin ) );
		return panel;
	}

}
