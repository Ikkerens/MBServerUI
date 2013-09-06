package com.ikkerens.serverui.screens;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import com.ikkerens.serverui.Screen;
import com.ikkerens.serverui.ServerUIPlugin;
import com.ikkerens.serverui.components.PluginDetail;
import com.ikkerens.serverui.components.PluginList;

public class PluginScreen extends Screen {

    @Override
    protected String getTabTitle() {
        return "Plugins";
    }

    @Override
    protected JPanel buildContents( final ServerUIPlugin plugin ) {
        final JPanel panel = new JPanel();
        panel.setLayout( new BorderLayout() );

        panel.add( new PluginList( plugin.getServer() ), BorderLayout.WEST );
        panel.add( new PluginDetail(), BorderLayout.CENTER );

        return panel;
    }

}
