package com.hikago;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.appengine.api.users.UserService;
import com.hikago.models.StudySet;

import javax.inject.Named;
import java.util.Date;

/**
  * Add your first API methods in this class, or you may create another class. In that case, please
  * update your web.xml accordingly.
 **/
@Api(name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(ownerDomain = "helloworld.example.com",
                ownerName = "helloworld.example.com",
                packagePath=""))
public class YourFirstAPI {
    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "sayHi")
    public StudySet sayHi(@Named("name") String name) {
        StudySet response = new StudySet();
        response.setName("Set 1");
        response.setUsername("1111");
        response.setLastUpdate(new Date());

        return response;
    }
}