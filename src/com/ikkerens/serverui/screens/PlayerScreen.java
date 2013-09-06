package com.ikkerens.serverui.screens;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import com.ikkerens.serverui.Screen;
import com.ikkerens.serverui.ServerUIPlugin;
import com.ikkerens.serverui.components.PlayerEditor;
import com.ikkerens.serverui.components.PlayerList;

public class PlayerScreen extends Screen {

    @Override
    protected String getTabTitle() {
        return "Players";
    }

    @Override
    protected JPanel buildContents( final ServerUIPlugin plugin ) {
        final JPanel panel = new JPanel();
        panel.setLayout( new BorderLayout() );

        panel.add( new PlayerList( plugin.getServer() ), BorderLayout.WEST );
        panel.add( new PlayerEditor(), BorderLayout.CENTER );

        return panel;
    }

}
