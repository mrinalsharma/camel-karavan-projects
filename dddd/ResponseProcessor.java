import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
@Named("ResponseProcessor")
public class ResponseProcessor implements Processor {

  public void process(Exchange exchange) throws Exception {
    System.out.println("Received Data "+ exchange.getIn().getBody());
    if(exchange.getIn().getBody().equals("quit")) {
       System.out.println("received Quit");
       exchange.getOut().setHeader("CamelNettyCloseChannelWhenComplete", true);
    }
    else {
       exchange.getOut().setBody("Hello from Karavan Pod");
    }
  }
}