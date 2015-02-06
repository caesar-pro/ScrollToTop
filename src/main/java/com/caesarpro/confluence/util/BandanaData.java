package com.caesarpro.confluence.util;

import com.atlassian.bandana.BandanaContext;
import com.atlassian.confluence.setup.bandana.ConfluenceBandanaContext;

/*
 *  Caesar pro
 */
public class BandanaData {
    public static final String BANDANA_SHOW_BUTTON_EVERYWHERE = "showButtonEverywhere";
    public static final String BANDANA_BUTTON_STYLE = "scrollButtonStyle";
    public static final BandanaContext bandanaContext = new ConfluenceBandanaContext("ScrollToTop");
}
