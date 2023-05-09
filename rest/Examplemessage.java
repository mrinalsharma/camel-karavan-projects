Examplemessageimport org.apache.camel.Exchange;
import org.apache.camel.Processor;

import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
@Named("NAME")
public class Examplemessage {

  public void process(Exchange exchange) throws Exception {
      exchange.getIn().setBody("Hello World");
  }
}