package com.ikkerens.serverui;

import java.awt.BorderLayout;
import java.awt.GraphicsEnvironment;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import sun.font.GraphicComponent;

import com.ikkerens.serverui.components.Logo;

public class MainWindow extends JFrame {
    private static final long    serialVersionUID = 1337L;
    private final ServerUIPlugin plugin;
    private final JTabbedPane    tabs;

    public MainWindow( final ServerUIPlugin plugin ) {
        super( "Minebuilder Server User Interface" );
        
        this.setSize( 800, 600 );
        this.setLocationRelativeTo( null );
        this.setResizable( false );
        this.setLayout( new BorderLayout() );

        this.plugin = plugin;
        this.tabs = new JTabbedPane();
        this.tabs.setTabLayoutPolicy( JTabbedPane.SCROLL_TAB_LAYOUT );

        this.addWindowListener( new WindowAdapter() {
            @Override
            public void windowClosing( final WindowEvent e ) {
                plugin.getServer().shutdown();
            }
        } );

        this.add( new Logo(), BorderLayout.NORTH );
        this.add( this.tabs, BorderLayout.CENTER );

        this.setVisible( true );
    }

    public void addTab( final Screen screen ) {
        this.tabs.addTab( screen.getTabTitle(), screen.getImageIcon(), screen.buildContents( this.plugin ) );
    }
}
