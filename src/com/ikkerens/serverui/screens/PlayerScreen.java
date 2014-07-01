package com.ikkerens.serverui.screens;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import com.ikkerens.serverui.Screen;
import com.ikkerens.serverui.ServerUIPlugin;
import com.ikkerens.serverui.components.PlayerEditor;
import com.ikkerens.serverui.components.PlayerList;

public class PlayerScreen extends Screen {

	private PlayerList playerList;
	private PlayerEditor editor;
	
    @Override
    protected String getTabTitle() {
        return "Players";
    }

    @Override
    protected JPanel buildContents( final ServerUIPlugin plugin ) {
        final JPanel panel = new JPanel();
        panel.setLayout( new BorderLayout() );
        
        playerList = new PlayerList( plugin );
        editor = new PlayerEditor( playerList );
        panel.add( playerList , BorderLayout.WEST );
        panel.add( editor , BorderLayout.CENTER );

        return panel;
    }

}
