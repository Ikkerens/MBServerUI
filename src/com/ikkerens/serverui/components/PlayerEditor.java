package com.ikkerens.serverui.components;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.mbserver.api.game.Player;

public class PlayerEditor extends JPanel {
    private static final long serialVersionUID = 1337L;
    private final PlayerList list;
    
    public PlayerEditor(PlayerList list) {
    	this.list = list;
		this.setLayout( new BorderLayout() );
		this.add(this.getButtons(), BorderLayout.NORTH);
	}
    
    private JPanel getButtons(){
    	final JPanel panel = new JPanel();
    	panel.setLayout( new FlowLayout() );
    	
    	final JButton kick = new JButton( "Kick Player" );
    	final JButton message = new JButton( "Send Message" );
    	
    	kick.addActionListener( new KickHandler() );
    	message.addActionListener( new MessageHandler() );
    	
    	panel.add( kick );
    	panel.add( message );
    	return panel;
    }
    
    private class KickHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Player player = (Player) list.getSelectedValue();
			
			if(player == null){
				JOptionPane.showMessageDialog(PlayerEditor.this , "No player selected!" );
				return;
			}
			
			player.kick("You have been kicked from the server.");
			
			JOptionPane.showMessageDialog(PlayerEditor.this, String.format("%s has been kicked!",player.getDisplayName()));
		}
    	
    }
    
    private class MessageHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Player player = (Player) list.getSelectedValue();
			
			if(player == null){
				JOptionPane.showMessageDialog(PlayerEditor.this , "No player selected!" );
				return;
			}
			
			new MessageDialog(PlayerEditor.this, player);
		}
    	
    }
}
