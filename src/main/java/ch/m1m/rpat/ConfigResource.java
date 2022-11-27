package ch.m1m.rpat;

import ch.m1m.rpat.persistence.ConfigUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.LocalDateTime;
import java.util.List;

@Path("/api/v1/config")
public class ConfigResource {

    private static Logger LOG = LoggerFactory.getLogger(ConfigResource.class);
    private static final String APP_NAME = "ch.m1m.app.config.example";

    ConfigService configService;

    public ConfigResource(ConfigService configService) {
        this.configService = configService;
        //configService.insert(new ConfigRow("test", "key_1", "value_1", LocalDateTime.now(), getLocalDateTimeMax()));
    }

    public static LocalDateTime getLocalDateTimeMax() {
        return ConfigUtils.getMaxTimestamp();
    }

    @Path("info")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getConfigInfo() {
        return "config api is deployed and running";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ConfigItem> getAll() {
        //configService.delete(new ConfigRow(APP_NAME,"key_3", "value_3"));
        return configService.selectAll().stream()
                .map(ConfigItemConverter::of)
                .toList();
    }

    @Path("{application}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ConfigItem> getAllForApplication(@PathParam("application") String application) {
        LOG.info("called REST getAllForApplication with: application={}", application);
        LocalDateTime tsDataFor = LocalDateTime.now();
        return configService.getAllForApplication(application, tsDataFor).stream()
                .map(ConfigItemConverter::of)
                .toList();
    }
}
