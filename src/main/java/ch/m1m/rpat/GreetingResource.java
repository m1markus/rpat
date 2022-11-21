package ch.m1m.rpat;

import ch.m1m.rpat.persistence.ConfigRow;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/hello")
public class GreetingResource {

    ConfigService configService;

    public GreetingResource(ConfigService configService) {
        this.configService = configService;
        //configService.insert(new ConfigRow("key_1", "value_1"));
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }

    @Path("config")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ConfigRow> helloConfig() {
        //configService.delete(new ConfigRow("key_2", "value_2"));
        return configService.selectAll();
    }
}