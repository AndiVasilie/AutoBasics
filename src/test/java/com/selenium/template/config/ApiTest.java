package com.selenium.template.config;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import groovy.json.JsonSlurper;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.testng.annotations.Test;

public class ApiTest {

    public static void getATicketsTitle()throws Exception{
    String ticketId = "cd62e2bd-b0c4-4404-a40d-6ba4a978caa1";
        String searchQueryApi = "https://qe-challenge.softia.dev:81/api/tickets/" + ticketId;
        JsonNode body = Unirest.get(searchQueryApi)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Api-Key", "Q4iVZ06HHV2iwBPlN8GNgJ3wn5QFbNYD")
                .asJson()
                .getBody();

        String response = body.toString();
        String[] ticketData = response.split("\"title\":",5);
        String ticketTitleWithBraces = ticketData[1];
        String[] cleaningBracesFromTitle = ticketTitleWithBraces.split("}}");
        String theTitle ="@@@@@@@@@@@@@@@@@@ \n" + "This is the ticket's title: \n" + cleaningBracesFromTitle [0] + "\n@@@@@@@@@@@@@@@@@@";

    System.out.println(theTitle);

    }
}
