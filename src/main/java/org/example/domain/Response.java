package org.example.domain;

import org.json.simple.JSONObject;

import java.util.Optional;

public class Response {

    private final Optional<Success> success;
    private final Optional<Reject> reject;

    public Response(Success success) {
        this.success = Optional.of(success);
        this.reject = Optional.empty();
    }

    public Response(Reject reject) {
        this.reject = Optional.of(reject);
        this.success = Optional.empty();
    }

    public String getMessage(){
        if (success.isPresent()){
            return success.get().getResponseJson().toString();
        }
        else {
            return reject.get().getResponseJson().toString();
        }
    }

}