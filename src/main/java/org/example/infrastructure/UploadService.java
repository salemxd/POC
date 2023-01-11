package org.example.infrastructure;

import org.example.domain.*;
import org.json.simple.JSONObject;

public class UploadService {
    private final Database database = new Database();
    public Response handleEvent(JSONObject event){
        try {
            Person person = new Person((String) event.get("body"));
            database.UploadPerson(person);
            return new Response(new Success());}
        catch (Exception exception){
            return new Response(new Reject(exception.getMessage()));}
    }
}
