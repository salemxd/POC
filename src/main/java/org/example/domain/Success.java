package org.example.domain;

import org.json.simple.JSONObject;

public class Success{
    private final JSONObject responseJson;

    public Success() {
        JSONObject responseJson = new JSONObject();

        JSONObject responseBody = new JSONObject();
        responseBody.put("message", "New item created");

        JSONObject headerJson = new JSONObject();
        headerJson.put("x-custom-header", "my custom header value");

        responseJson.put("statusCode", 200);
        responseJson.put("headers", headerJson);
        responseJson.put("body", responseBody.toString());

        this.responseJson = responseJson;
    }

    public JSONObject getResponseJson() {
        return responseJson;
    }
}
