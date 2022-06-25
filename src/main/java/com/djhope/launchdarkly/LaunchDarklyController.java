package com.djhope.launchdarkly;

import com.launchdarkly.sdk.LDUser;
import com.launchdarkly.sdk.LDValue;
import com.launchdarkly.sdk.server.LDClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController // shorthand for @Controller and @ResponseBody rolled together
public class LaunchDarklyController {

    @RequestMapping( "/hello" )
    public String echo() {
        // Create a new LDClient with your environment-specific SDK key
        LDClient ldClient = new LDClient("sdk-bd8652b2-55c9-4740-8ee4-7fae23de78b0");

        // Set up the user properties. This user should appear on your
        // LaunchDarkly users dashboard soon after you run the demo.
        LDUser user = new LDUser.Builder("UNIQUE IDENTIFIER")
                .firstName("Bob")
                .lastName("Loblaw")
                .custom("groups", LDValue.buildArray().add("beta_testers").build())
                .build();

        boolean showFeature = ldClient.boolVariation("edit-note", user, false);

        System.out.println("SDK successfully connected! The value of edit-note is " + showFeature + "for " + user);

        // Here we ensure that the SDK shuts down cleanly and has a chance to deliver analytics
        // events to LaunchDarkly before the program exits. If analytics events are not delivered,
        // the user properties and flag usage statistics will not appear on your dashboard. In a
        // normal long-running application, the SDK would continue running and events would be
        // delivered automatically in the background.
        try {
            ldClient.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "Hello World! "+showFeature;
    }

    @RequestMapping( "/getLaunchDarklyCredentials" )
    public CredentialsBean getLaunchDarklyCredentials() {
        CredentialsBean credentialsBean = new CredentialsBean();
        credentialsBean.setClientKey("");
        credentialsBean.setUserId("");
        credentialsBean.setUserName("");
        return credentialsBean;
    }
}