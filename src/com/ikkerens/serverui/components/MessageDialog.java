package com.ikkerens.serverui.components;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mbserver.api.game.Player;

public class MessageDialog extends JDialog{
	private static final long serialVersionUID = 1337L;
	private JTextField input;
	private Player player;
	
	public MessageDialog(JPanel playerPanel,Player player) {
		super();
		this.player = player;
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		this.setLocationRelativeTo(playerPanel);
		
		final JLabel label = new JLabel("Enter Your Message");
		final JPanel panel = new JPanel();
		input = new JTextField("",1);
		final JButton send = new JButton("Send"),cancel = new JButton("Cancel");
		panel.setLayout(new FlowLayout());
		
		send.addActionListener(new SendHandler());
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MessageDialog.this.setVisible(false);
				MessageDialog.this.dispose();
			}
		});
		
		panel.add(send);
		panel.add(cancel);
		this.add(label,BorderLayout.NORTH);
		this.add(input,BorderLayout.CENTER);
		this.add(panel,BorderLayout.SOUTH);
		this.pack();
		this.setVisible(true);
	}
	
	private class SendHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String text = input.getText();
			if(text.trim().isEmpty())
				return;
			
			player.sendMessage(text);
			MessageDialog.this.setVisible(false);
			MessageDialog.this.dispose();
		}
		
	}
	
}
