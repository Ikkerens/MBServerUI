package com.ikkerens.serverui;

import java.awt.GraphicsEnvironment;
import java.util.logging.Level;

import javax.swing.SwingUtilities;

import com.ikkerens.serverui.screens.LogScreen;
import com.ikkerens.serverui.screens.PlayerScreen;
import com.ikkerens.serverui.screens.PluginScreen;
import com.ikkerens.serverui.screens.WorldsScreen;
import com.mbserver.api.Load;
import com.mbserver.api.MBServerPlugin;
import com.mbserver.api.Manifest;

@Manifest( name = "MBServerUI", authors = "Ikkerens", load = Load.PREWORLD )
public class ServerUIPlugin extends MBServerPlugin {
    private MainWindow mainFrame;

    @Override
    public void onLoad() {
        if ( GraphicsEnvironment.isHeadless() ) {
            this.getLogger().log( Level.WARNING, "MBServerUI will not work in an headless environment." );
            this.getLogger().log( Level.WARNING, "Are you running this server though SSH/command line?" );
            return;
        }

        SwingUtilities.invokeLater( new Runnable() {

            @Override
            public void run() {
                ServerUIPlugin.this.mainFrame = new MainWindow( ServerUIPlugin.this );
                ServerUIPlugin.this.mainFrame.addTab( new LogScreen() );
                ServerUIPlugin.this.mainFrame.addTab( new PlayerScreen() );
                ServerUIPlugin.this.mainFrame.addTab( new WorldsScreen() );
                ServerUIPlugin.this.mainFrame.addTab( new PluginScreen() );
            }
        } );
    }

    @Override
    public void onDisable() {
        if ( this.mainFrame != null )
            this.mainFrame.dispose();
    }
}
