package com.ikkerens.serverui.components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.ikkerens.serverui.ServerUIPlugin;

public abstract class ListComponent< T > extends JList {
    private static final long    serialVersionUID = 1337L;
    private final ServerUIPlugin plugin;

    public ListComponent( final ServerUIPlugin plugin ) {
        this.setLayoutOrientation( JList.VERTICAL );
        this.setSize( new Dimension( 350, 100 ) );

        this.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        this.setCellRenderer( new ListItemRenderer() );
        this.addListSelectionListener( new SelectionListener() );
        this.plugin = plugin;
    }

    public void setData( final T[] objects ) {
        super.setListData( objects );
    }

    protected final ServerUIPlugin getPlugin() {
        return this.plugin;
    }

    protected abstract Component renderItem( final T item, final int index, final boolean selected, final boolean focused );

    protected abstract void onSelect( final T item, final int index );

    private class ListItemRenderer implements ListCellRenderer {

        @Override
        @SuppressWarnings( "unchecked" )
        public Component getListCellRendererComponent( final JList list, final Object item, final int index, final boolean selected, final boolean focused ) {
            final Component component = ListComponent.this.renderItem( (T) item, index, selected, focused );

            if ( selected ) {
                component.setBackground( Color.BLUE );
                component.setForeground( Color.BLUE );
            } else {
                component.setBackground( Color.BLACK );
                component.setForeground( Color.BLACK );
            }

            return component;
        }

    }

    private class SelectionListener implements ListSelectionListener {

        @Override
        public void valueChanged( final ListSelectionEvent e ) {
        	if(!e.getValueIsAdjusting())
        	ListComponent.this.onSelect((T) ListComponent.this.getSelectedValue(),
        			ListComponent.this.getSelectedIndex());
        }

    }
}
