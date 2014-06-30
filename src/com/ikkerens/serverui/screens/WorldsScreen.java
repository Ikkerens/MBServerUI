package com.ikkerens.serverui.screens;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import com.ikkerens.serverui.Screen;
import com.ikkerens.serverui.ServerUIPlugin;
import com.ikkerens.serverui.components.WorldList;

public class WorldsScreen extends Screen {

    @Override
    protected String getTabTitle() {
        return "Worlds";
    }

    @Override
    protected JPanel buildContents( final ServerUIPlugin plugin ) {
    	JPanel panel  = new JPanel();
    	panel.setLayout(new BorderLayout());
    	panel.add(new WorldList(plugin),BorderLayout.WEST);
    	return panel;
    }

}
