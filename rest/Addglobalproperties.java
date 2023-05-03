import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Addglobalproperties {

     @Inject
    CamelContext context;

    @PostConstruct
    void init() {
        // Enable Jackson JSON type converter.
        camelContext.getGlobalOptions().put("CamelJacksonEnableTypeConverter", "true");
        // Allow Jackson JSON to convert to pojo types also
        // (by default Jackson only converts to String and other simple types)
        getContext().getGlobalOptions().put("CamelJacksonTypeConverterToPojo", "true");
    }
}