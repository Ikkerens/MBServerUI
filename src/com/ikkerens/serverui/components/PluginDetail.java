package com.ikkerens.serverui.components;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PluginDetail extends JPanel {
    private static final long serialVersionUID = 1337L;

    public PluginDetail() {
        this.setLayout( new BorderLayout() );

        this.add( this.getButtons(), BorderLayout.NORTH );
    }

    private JPanel getButtons() {
        final JPanel panel = new JPanel();
        panel.setLayout( new FlowLayout() );

        final JButton disable = new JButton( "Disable plugin" );
        disable.addActionListener( new DisableHandler() );

        panel.add( disable );
        return panel;
    }

    private static class DisableHandler implements ActionListener {

        @Override
        public void actionPerformed( final ActionEvent e ) {

        }

    }
}
