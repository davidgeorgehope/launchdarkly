package com.djhope.launchdarkly;

import com.launchdarkly.sdk.LDUser;
import com.launchdarkly.sdk.LDValue;
import com.launchdarkly.sdk.server.LDClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController // shorthand for @Controller and @ResponseBody rolled together
public class LaunchDarklyController {

    @RequestMapping( "/hello" )
    public String echo() {
        CredentialsBean credsSingleton = WelcomeController.credsSingleton();
        LDClient ldClient = new LDClient(credsSingleton.getSDKKey());
        LDUser user = new LDUser.Builder(credsSingleton.getUserId())
                .firstName(credsSingleton.getUserName())
                .lastName(credsSingleton.getUserName())
                .custom("groups", LDValue.buildArray().add("beta_testers").build())
                .build();

        boolean showFeature = ldClient.boolVariation("backend-note", user, false);

        System.out.println("SDK successfully connected! The value of edit-note is " + showFeature + "for " + user);
        try {
            ldClient.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "The back end feature flag is set to "+showFeature;
    }
}