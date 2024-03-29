import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.apache.camel.CamelContext;

@ApplicationScoped
public class Addglobalproperties {

     @Inject
    CamelContext context;

    @PostConstruct
    void init() {
        // Enable Jackson JSON type converter.
        context.getGlobalOptions().put("CamelJacksonEnableTypeConverter", "true");
        // Allow Jackson JSON to convert to pojo types also
        // (by default Jackson only converts to String and other simple types)
        context.getGlobalOptions().put("CamelJacksonTypeConverterToPojo", "true");
    }
}