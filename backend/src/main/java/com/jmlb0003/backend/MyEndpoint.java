package com.jmlb0003.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.jmlb0003.jokeslib.Joker;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "jokeApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.jmlb0003.com",
                ownerName = "backend.jmlb0003.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /**
     * A simple endpoint method that returns a joke
     */
    @ApiMethod(name = "getJoke")
    public MyBean getAJoke() {
        final MyBean response = new MyBean();
        response.setData(Joker.getJoke());
        return response;
    }

}
