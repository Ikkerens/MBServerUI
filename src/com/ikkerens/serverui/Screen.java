package com.ikkerens.serverui;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public abstract class Screen {
    protected abstract String getTabTitle();

    protected ImageIcon getImageIcon() {
        return null;
    }

    protected abstract JPanel buildContents( ServerUIPlugin plugin );
}
