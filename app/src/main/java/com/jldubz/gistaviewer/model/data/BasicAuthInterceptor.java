package com.jldubz.gistaviewer.model.data;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class BasicAuthInterceptor implements Interceptor {

    private String mCredentials;

    public BasicAuthInterceptor(String username, String token) {
        this.mCredentials = Credentials.basic(username, token);
    }


    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request request = chain.request();
        Request authenticateRequest = request.newBuilder()
                .header("Authorization", mCredentials)
                .build();
        return chain.proceed(authenticateRequest);
    }
}
