import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
@Named("ProcessUsers")
public class ProcessUsers implements Processor {

  public void process(Exchange exchange) throws Exception {
      exchange.getOut().setBody("{\"username\":\"Karavan\"}");
      exchange.getOut().setHeader(Exchange.HTTP_RESPONSE_CODE, constant(403))
  }
}