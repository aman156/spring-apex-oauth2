package com.client.app.springangular;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Component;

/**
 * Force
 */
@Component
public class Force {

    private static final String REST_VERSION = "44.0";
    @Bean
    private OAuth2RestTemplate oAuth2RestTemplate(OAuth2ProtectedResourceDetails resource, OAuth2ClientContext ctx0) {
        return new OAuth2RestTemplate(resource, ctx0);
    }
    @Autowired
    private OAuth2RestTemplate restTemplate;

    public List<Account> accounts(OAuth2Authentication principal) {
        String url = restUrl(principal) + "query/?q={q}";
        System.out.println(">>>>URL :"+url);
        Map<String, String> params = new HashMap<>();
        params.put("q", "SELECT Id, Name, Type, Industry, Rating FROM Account");
        return restTemplate.getForObject(url, QueryResultAccount.class, params).records;
    }
    
    @SuppressWarnings("unchecked")
    private static String restUrl(OAuth2Authentication principal)
    {
        HashMap<String,Object> details = (HashMap<String,Object>)principal.getUserAuthentication().getDetails();
        System.out.println(">>>>>details"+details);
        HashMap<String,String> urls     = (HashMap<String,String>)details.get("urls");
        System.out.println(">>>>>urls"+urls);
        return urls.get("rest").replace("{version}",REST_VERSION);

    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class QueryResult<T> {
        public List<T> records;
    }
    private static class QueryResultAccount extends QueryResult<Account> {}
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Account {
        public String Id;
        public String Name;
        public String Industry;
        public String Rating;
    }
}