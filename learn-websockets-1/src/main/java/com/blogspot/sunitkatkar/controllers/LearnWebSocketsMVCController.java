/**
 * Copyright &copy; Sunit Katkar (sunitkatkar@gmail.com) http://sunitkatkar.blogspot.com
 */
package com.blogspot.sunitkatkar.controllers;

import java.security.Principal;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.blogspot.sunitkatkar.util.Util;

/**
 * {@link LearnWebSocketsMVCController} is for handling the user login and
 * logout. Simple form based security is used. Refer to
 * <code>application-security.xml</code> and <code>web.xml</code> for details.
 * 
 * @author <a href="mailto:sunitkatkar@gmail.com">Sunit Katkar</a>
 * @since 1.0
 * @version 1.0.0.1
 */
@Controller
public class LearnWebSocketsMVCController {

    private static final Logger LOG = LoggerFactory
            .getLogger(LearnWebSocketsMVCController.class);

    /**
     * To handle the regular request to the application context. e.g.
     * http://localhost:8080/learn-websockets-1
     * 
     * @param model
     * @param locale
     * @return
     */
    @RequestMapping("/")
    public String handleIndexPage(Model model, Locale locale) {
        LOG.info("Request for default / url processed at {}",
                Util.getSimpleDate());
        return "loginPage";
    }

    /**
     * Method is executed when there is a call to the <code>/logoutPage</code>
     * url.
     * 
     * @return
     */
    @RequestMapping(value = "/logoutPage", method = RequestMethod.GET)
    public String logoutPage() {
        LOG.info("Request for /logoutPage url processed at {}",
                Util.getSimpleDate());
        return "logoutPage";
    }

    /**
     * Method is executed when there is a call to the <code>/loginPage</code>
     * url. On successful login, the user is re-directed to the
     * <code>/secured/myPage</code> url.
     * 
     * @return
     */
    @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
    public String loginPage() {
        LOG.info("Request for /loginPage url processed at {}",
                Util.getSimpleDate());
        return "loginPage";
    }

    /**
     * Method gets executed when there are requests to the
     * <code>/secured/basicWebsockets</code> url. This url is called after a
     * successful login.
     * 
     * @param model
     * @param principal
     * @param locale
     * @return
     */
    @RequestMapping("/secured/basicWebsockets")
    public String basicWebsocketsPage(Model model, Principal principal,
            Locale locale) {

        // Get a simple human readable date and time
        String formattedDate = Util.getSimpleDate(locale);

        // Get the logged in user's name
        String userName = principal.getName();

        // Set some sample messages to show on the landing 'basicWebsockets.jsp'
        // page.
        model.addAttribute("username", userName);
        model.addAttribute("time", formattedDate);

        LOG.info(
                "Request from user:{} for /secured/basicWebsockets url processed at time:{}",
                userName, formattedDate);

        return "secured/basicWebsockets";
    }
}