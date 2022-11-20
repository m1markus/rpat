package ch.m1m.rpat;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }

    @Path("config")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ConfigItem> helloConfig() {
        List<ConfigItem> liConfig = new ArrayList<>();
        liConfig.add(new ConfigItem("key_1", "value_1"));
        liConfig.add(new ConfigItem("key_2", "value_3"));
        liConfig.add(new ConfigItem("key_3", "value_3"));
        liConfig.add(new ConfigItem("key_4", "value_4"));
        return liConfig;
    }
}