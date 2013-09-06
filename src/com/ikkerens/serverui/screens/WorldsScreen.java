package com.ikkerens.serverui.screens;

import javax.swing.JPanel;

import com.ikkerens.serverui.Screen;
import com.ikkerens.serverui.ServerUIPlugin;

public class WorldsScreen extends Screen {

    @Override
    protected String getTabTitle() {
        return "Worlds";
    }

    @Override
    protected JPanel buildContents( final ServerUIPlugin plugin ) {
        return new JPanel();
    }

}
