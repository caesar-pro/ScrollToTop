/*
 *   JS loaded on next contexts:
 *   * page
 *   * blogpost
 *   * space
 */
AJS.toInit(function ($) {
    AJS.$(document).ready(function () {

        var scrollButtonSelector = "#scroll-to-top-btn";

        if (!$(scrollButtonSelector).length) { // create button holder if it has not yet been created
            $("#main").append("<a href='#' id='scroll-to-top-btn' title='Scroll to top'></a>");
        }

        $.ajax({url: AJS.contextPath() + "/rest/scrolltotop/1.0/config/showButtonEverywhere", async: true}).done(function (data) {
            if (typeof AJS.Meta.get("showButtonEverywhere") == 'undefined') {  // macro not found
                if (data["showButtonEverywhere"] == "true") AJS.Meta.set("showButtonEverywhere", true);
            }

            $(scrollButtonSelector).addClass(data["scrollButtonStyle"]);
        });

        $(window).scroll(function () { // on scroll
            if (AJS.Meta.get("showButtonEverywhere")) {
                if ($(window).scrollTop() > 100) {
                    if (!$(scrollButtonSelector).is(':visible')) $(scrollButtonSelector).fadeIn();
                } else {
                    if ($(scrollButtonSelector).is(':visible')) $(scrollButtonSelector).fadeOut();
                }
            }
        });

        $(scrollButtonSelector).click(function () {
            $("html, body").animate({scrollTop: 0}, "500", "swing", function () {
            });
        });

    });
});