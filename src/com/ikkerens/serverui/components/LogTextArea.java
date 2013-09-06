package com.ikkerens.serverui.components;

import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import javax.swing.JTextArea;

public class LogTextArea extends JTextArea {
    private static final long serialVersionUID = 7215329406490832433L;

    public LogTextArea( final Logger logger ) {
        this.setEditable( false );
        this.setSize( 1000, 1000 );
        logger.addHandler( new LogReader( logger ) );
    }

    private class LogReader extends Handler {
        private final Formatter format;

        public LogReader( final Logger logger ) {
            this.format = logger.getHandlers()[ 0 ].getFormatter();
        }

        @Override
        public void publish( final LogRecord record ) {
            LogTextArea.this.append( this.format.format( record ) );
        }

        @Override
        public void flush() {
        }

        @Override
        public void close() throws SecurityException {
        }

    }
}
