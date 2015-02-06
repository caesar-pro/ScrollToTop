package com.caesarpro.confluence.action;

import com.atlassian.bandana.BandanaManager;
import com.atlassian.confluence.core.ConfluenceActionSupport;
import com.caesarpro.confluence.util.BandanaData;

/*
 *  Caesar pro
 */
public class ConfigButtonAction extends ConfluenceActionSupport {
    private final BandanaManager bandanaManager;
    private String scrollBtnStyle;
    private boolean showButtonEverywhere = false;
    private boolean editConfig = false;

    public ConfigButtonAction(BandanaManager bandanaManager) {
        this.bandanaManager = bandanaManager;
    }

    @Override
    public String execute() throws Exception {
        if (editConfig) {
            bandanaManager.setValue(BandanaData.bandanaContext, BandanaData.BANDANA_SHOW_BUTTON_EVERYWHERE, String.valueOf(showButtonEverywhere));
            bandanaManager.setValue(BandanaData.bandanaContext, BandanaData.BANDANA_BUTTON_STYLE, scrollBtnStyle);
        }

        return SUCCESS;
    }

    public boolean getShowButtonEverywhere() {
        return Boolean.valueOf(String.valueOf(bandanaManager.getValue(BandanaData.bandanaContext, BandanaData.BANDANA_SHOW_BUTTON_EVERYWHERE)));
    }

    public void setShowButtonEverywhere(String showButtonEverywhere) {
        if (showButtonEverywhere != null && "on".equals(showButtonEverywhere)) {
            this.showButtonEverywhere = true;
        }
    }

    public void setEditConfig(boolean editConfig) {
        this.editConfig = editConfig;
    }

    public String getScrollbtnstyle() {
        return String.valueOf(bandanaManager.getValue(BandanaData.bandanaContext, BandanaData.BANDANA_BUTTON_STYLE));
    }

    public void setScrollbtnstyle(String scrollBtnStyle) {
        this.scrollBtnStyle = scrollBtnStyle;
    }
}
