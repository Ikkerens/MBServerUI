package com.ikkerens.serverui.components;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import com.mbserver.api.Manifest;
import com.mbserver.api.Server;
import com.mbserver.api.events.EventHandler;
import com.mbserver.api.events.EventPriority;
import com.mbserver.api.events.Listener;
import com.mbserver.api.events.ServerStartedEvent;

public class PluginList extends JList implements Listener {
    private static final long serialVersionUID = 8004760921073851046L;

    public PluginList( final Server server ) {
        this.setSize( 200, this.getSize().height );
        this.setLayoutOrientation( JList.VERTICAL );
        this.setCellRenderer( new PluginRenderer() );

        server.getPluginManager().registerEventHandler( this );
    }

    private static class PluginRenderer implements ListCellRenderer {

        @Override
        public Component getListCellRendererComponent( final JList list, final Object plugin, final int index, final boolean selected, final boolean focused ) {
            final JLabel label = new JLabel();

            if ( selected ) {
                label.setBackground( list.getSelectionBackground() );
                label.setForeground( list.getSelectionForeground() );
            } else {
                label.setBackground( list.getBackground() );
                label.setForeground( list.getForeground() );
            }

            final Manifest mf = plugin.getClass().getAnnotation( Manifest.class );
            label.setText( mf.name() );

            return label;
        }

    }

    @EventHandler( priority = EventPriority.LOWEST )
    public void onLogin( final ServerStartedEvent e ) {
        this.setListData( e.getServer().getPluginManager().getPlugins() );
    }
}
