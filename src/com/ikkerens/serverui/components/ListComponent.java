package com.ikkerens.serverui.components;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JList;
import javax.swing.ListCellRenderer;

import com.ikkerens.serverui.ServerUIPlugin;

public abstract class ListComponent extends JList {
    private static final long    serialVersionUID = 1337L;
    private final ServerUIPlugin plugin;

    public ListComponent( final ServerUIPlugin plugin ) {
        this.setLayoutOrientation( JList.VERTICAL );
        this.setCellRenderer( new ListItemRenderer() );
        this.setSize( new Dimension( 350, 100 ) );

        this.plugin = plugin;
    }

    protected final ServerUIPlugin getPlugin() {
        return this.plugin;
    }

    protected abstract Component renderItem( final JList list, final Object plugin, final int index, final boolean selected, final boolean focused );

    private class ListItemRenderer implements ListCellRenderer {

        @Override
        public Component getListCellRendererComponent( final JList list, final Object plugin, final int index, final boolean selected, final boolean focused ) {
            final Component component = ListComponent.this.renderItem( list, plugin, index, selected, focused );

            if ( selected ) {
                component.setBackground( list.getSelectionBackground() );
                component.setForeground( list.getSelectionForeground() );
            } else {
                component.setBackground( list.getBackground() );
                component.setForeground( list.getForeground() );
            }

            return component;
        }

    }
}
