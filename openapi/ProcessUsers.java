import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.BuilderSupport;
import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
@Named("ProcessUsers")
public class ProcessUsers implements Processor {

  public void process(Exchange exchange) throws Exception {
      exchange.getOut().setBody("{\"username\":\"Karavan\"}");
      exchange.getOut().setHeader(Exchange.HTTP_RESPONSE_CODE, "401");
  }
}