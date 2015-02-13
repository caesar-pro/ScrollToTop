package com.caesarpro.confluence.rest;

import com.caesarpro.confluence.util.BandanaData;
import com.caesarpro.confluence.util.BandanaService;
import com.google.gson.Gson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/*
 *  Caesar pro
 */
@Path("/config")
public class ConfigRest {
    private final BandanaService bandanaService;

    public ConfigRest(BandanaService bandanaService) {
        this.bandanaService = bandanaService;
    }

    @GET /*     /rest/scrolltotop/1.0/config/showButtonEverywhere    */
    @Path("showButtonEverywhere")
    @Produces({APPLICATION_JSON})
    public Response showButtonEverywhere() {
        Map<String, String> params = new HashMap<>();

        Object showButtonEverywhereObject = bandanaService.getBoolean(BandanaData.bandanaContext, BandanaData.BANDANA_SHOW_BUTTON_EVERYWHERE, true);
        params.put("showButtonEverywhere", String.valueOf(showButtonEverywhereObject));

        Object scrollButtonStyleObject = bandanaService.getString(BandanaData.bandanaContext, BandanaData.BANDANA_BUTTON_STYLE, "scrollbtn1");
        params.put("scrollButtonStyle", String.valueOf(scrollButtonStyleObject));

        return Response.ok(new Gson().toJson(params), MediaType.APPLICATION_JSON).build();
    }
}
