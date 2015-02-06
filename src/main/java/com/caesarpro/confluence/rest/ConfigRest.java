package com.caesarpro.confluence.rest;

import com.atlassian.bandana.BandanaManager;
import com.caesarpro.confluence.util.BandanaData;
import com.google.gson.Gson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

/*
 *  Caesar pro
 */
@Path("/config")
public class ConfigRest {
    private final BandanaManager bandanaManager;

    public ConfigRest(BandanaManager bandanaManager) {
        this.bandanaManager = bandanaManager;
    }

    @GET /*     /rest/scrolltotop/1.0/config/showButtonEverywhere    */
    @Path("showButtonEverywhere")
    @Produces({TEXT_PLAIN})
    public Response showButtonEverywhere() {
        Map<String, String> params = new HashMap<>();

        Object showButtonEverywhereObject = bandanaManager.getValue(BandanaData.bandanaContext, BandanaData.BANDANA_SHOW_BUTTON_EVERYWHERE);
        if (showButtonEverywhereObject == null) {
            bandanaManager.setValue(BandanaData.bandanaContext, BandanaData.BANDANA_SHOW_BUTTON_EVERYWHERE, String.valueOf(true));
            showButtonEverywhereObject = true;
        }
        params.put("showButtonEverywhere", String.valueOf(showButtonEverywhereObject));

        Object scrollButtonStyleObject = bandanaManager.getValue(BandanaData.bandanaContext, BandanaData.BANDANA_BUTTON_STYLE);
        if (scrollButtonStyleObject == null) {
            bandanaManager.setValue(BandanaData.bandanaContext, BandanaData.BANDANA_BUTTON_STYLE, "scrollbtn1");
            scrollButtonStyleObject = "scrollbtn1";
        }
        params.put("scrollButtonStyle", String.valueOf(scrollButtonStyleObject));

        return Response.ok(new Gson().toJson(params), MediaType.APPLICATION_JSON).build();
    }
}
