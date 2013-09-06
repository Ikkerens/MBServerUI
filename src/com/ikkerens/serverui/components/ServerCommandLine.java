package com.ikkerens.serverui.components;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ServerCommandLine extends JPanel {
    private static final long serialVersionUID = 8925316017441299619L;
    private JTextField        field;

    public ServerCommandLine() {
        this.setLayout( new BorderLayout() );
        this.add( this.getTextArea(), BorderLayout.CENTER );
        this.add( this.getSubmitButton(), BorderLayout.EAST );
    }

    private JTextField getTextArea() {
        this.field = new JTextField();

        this.field.addActionListener( new SendListener() );

        return this.field;
    }

    private JButton getSubmitButton() {
        final JButton button = new JButton( "Send" );

        button.addActionListener( new SendListener() );

        return button;
    }

    private class SendListener implements ActionListener {

        @Override
        public void actionPerformed( final ActionEvent e ) {
            ServerCommandLine.this.field.setText( "" );
        }

    }
}
