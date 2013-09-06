package com.ikkerens.serverui.components;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class PluginDetail extends JPanel {
    private static final long serialVersionUID = 3969978443239933426L;

    public PluginDetail() {
        this.setLayout( new BorderLayout() );

        this.add( this.getButtons(), BorderLayout.NORTH );
    }

    private JPanel getButtons() {
        return null;
    }
}
