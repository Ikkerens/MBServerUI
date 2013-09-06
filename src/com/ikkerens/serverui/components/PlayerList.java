package com.ikkerens.serverui.components;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import com.mbserver.api.Server;
import com.mbserver.api.events.EventHandler;
import com.mbserver.api.events.EventPriority;
import com.mbserver.api.events.Listener;
import com.mbserver.api.events.PlayerLogoutEvent;
import com.mbserver.api.events.PostPlayerLoginEvent;
import com.mbserver.api.game.Player;

public class PlayerList extends JList implements Listener {
    private static final long serialVersionUID = 1337L;

    public PlayerList( final Server server ) {
        this.setSize( 150, this.getSize().height );
        this.setLayoutOrientation( JList.VERTICAL );
        this.setListData( server.getPlayers() );
        this.setCellRenderer( new PlayerRenderer() );

        server.getPluginManager().registerEventHandler( this );
    }

    private static class PlayerRenderer implements ListCellRenderer {

        @Override
        public Component getListCellRendererComponent( final JList list, final Object player, final int index, final boolean selected, final boolean focused ) {
            final JLabel label = new JLabel();

            if ( selected ) {
                label.setBackground( list.getSelectionBackground() );
                label.setForeground( list.getSelectionForeground() );
            } else {
                label.setBackground( list.getBackground() );
                label.setForeground( list.getForeground() );
            }

            label.setText( ( (Player) player ).getName() );

            return label;
        }

    }

    @EventHandler( priority = EventPriority.LOWEST )
    public void onLogin( final PostPlayerLoginEvent e ) {
        this.setListData( e.getServer().getPlayers() );
    }

    @EventHandler( priority = EventPriority.LOWEST )
    public void onLogout( final PlayerLogoutEvent e ) {
        this.setListData( e.getServer().getPlayers() );
    }
}
