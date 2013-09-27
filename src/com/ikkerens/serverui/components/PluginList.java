package com.ikkerens.serverui.components;

import java.awt.Component;

import javax.swing.JLabel;

import com.ikkerens.serverui.ServerUIPlugin;
import com.mbserver.api.MBServerPlugin;
import com.mbserver.api.Manifest;
import com.mbserver.api.events.EventHandler;
import com.mbserver.api.events.EventPriority;
import com.mbserver.api.events.Listener;
import com.mbserver.api.events.ServerStartedEvent;

public class PluginList extends ListComponent< MBServerPlugin > implements Listener {
    private static final long serialVersionUID = 1337L;

    public PluginList( final ServerUIPlugin plugin ) {
        super( plugin );
        plugin.getServer().getPluginManager().registerEventHandler( this );
    }

    @Override
    protected Component renderItem( final MBServerPlugin plugin, final int index, final boolean selected, final boolean focused ) {
        final JLabel label = new JLabel();

        final Manifest mf = plugin.getClass().getAnnotation( Manifest.class );
        label.setText( "        " + mf.name() + "        " );

        return label;
    }

    @Override
    protected void onSelect( final MBServerPlugin item, final int index ) {
        // TODO Auto-generated method stub

    }

    @EventHandler( priority = EventPriority.LOWEST )
    public void onLogin( final ServerStartedEvent e ) {
        this.setData( e.getServer().getPluginManager().getPlugins() );
    }

}
