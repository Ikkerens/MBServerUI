package com.ikkerens.serverui;

import java.awt.GraphicsEnvironment;
import java.util.logging.Level;

import com.ikkerens.serverui.screens.LogScreen;
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

        this.mainFrame = new MainWindow( this );
        this.mainFrame.addTab( new LogScreen() );
    }

    @Override
    public void onDisable() {
        if ( this.mainFrame != null )
            this.mainFrame.dispose();
    }
}
