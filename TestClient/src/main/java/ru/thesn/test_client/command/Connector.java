package ru.thesn.test_client.command;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

final class Connector {

    private static final OkHttpClient client = new OkHttpClient();
    
    private Connector() {
    }

    static Response connect(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            throw new IOException("Failed to download file: " + response);
        }
        return response;
    }
}
