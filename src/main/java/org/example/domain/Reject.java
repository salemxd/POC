package org.example.domain;

import org.json.simple.JSONObject;

public class Reject{

    private final JSONObject responseJson;
    public Reject(String rejectMessage) {
        JSONObject responseJson = new JSONObject();
        responseJson.put("statusCode", 400);
        responseJson.put("exception", rejectMessage);
        this.responseJson = responseJson;
    }

    public JSONObject getResponseJson() {
        return responseJson;
    }
}
