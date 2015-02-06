package com.caesarpro.confluence.macro;

import com.atlassian.confluence.content.render.xhtml.ConversionContext;
import com.atlassian.confluence.macro.Macro;
import com.atlassian.confluence.macro.MacroExecutionException;
import com.atlassian.confluence.renderer.radeox.macros.MacroUtils;
import com.atlassian.confluence.util.velocity.VelocityUtils;

import java.util.Map;

/*
 *  Caesar pro
 */
public class ScrollToTopMacro implements Macro {
    @Override
    public String execute(Map<String, String> parameters, String body, ConversionContext conversionContext) throws MacroExecutionException {
        return VelocityUtils.getRenderedTemplate("templates/scroll-to-top-macro.vm", MacroUtils.defaultVelocityContext());
    }

    @Override
    public BodyType getBodyType() {
        return BodyType.NONE;
    }

    @Override
    public OutputType getOutputType() {
        return OutputType.INLINE;
    }
}
