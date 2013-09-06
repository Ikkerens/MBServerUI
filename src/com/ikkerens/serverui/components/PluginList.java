package com.ikkerens.serverui.components;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;

import com.ikkerens.serverui.ServerUIPlugin;
import com.mbserver.api.Manifest;
import com.mbserver.api.events.EventHandler;
import com.mbserver.api.events.EventPriority;
import com.mbserver.api.events.Listener;
import com.mbserver.api.events.ServerStartedEvent;

public class PluginList extends ListComponent implements Listener {
    private static final long serialVersionUID = 1337L;

    public PluginList( final ServerUIPlugin plugin ) {
        super( plugin );
        plugin.getServer().getPluginManager().registerEventHandler( this );
    }

    @Override
    protected Component renderItem( JList list, Object plugin, int index, boolean selected, boolean focused ) {
        JLabel label = new JLabel();
        
        Manifest mf = plugin.getClass().getAnnotation( Manifest.class );
        label.setText( "        " + mf.name() + "        " );
        
        return label;
    }

    @EventHandler( priority = EventPriority.LOWEST )
    public void onLogin( final ServerStartedEvent e ) {
        this.setListData( e.getServer().getPluginManager().getPlugins() );
    }

}
