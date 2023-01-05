package org.example.controller;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import org.example.domain.RequestParser;
import org.example.infrastructure.UploadService;
import org.example.domain.Response;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class LambdaRequestStreamHandler implements RequestStreamHandler {

    public final UploadService uploadService = new UploadService();

    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {

        RequestParser requestParser = new RequestParser(inputStream);
        Response response =  uploadService.handleEvent(requestParser.getEvent());

        OutputStreamWriter writer = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
        writer.write(response.getMessage());
        writer.close();
    }
}
