import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import javax.inject.Named;
import javax.inject.Singleton;
import java.lang.String;

@Singleton
@Named("ResponseProcessor")
public class ResponseProcessor implements Processor {

  public void process(Exchange exchange) throws Exception {
    System.out.println("Received Data "+ exchange.getIn().getBody() + " Length "+exchange.getIn().getBody(String.class).length());
    if(exchange.getIn().getBody(String.class).equals("quit")) {
       System.out.println("received Quit");
       exchange.getOut().setHeader("CamelNettyCloseChannelWhenComplete", true);
    }
    else {
       exchange.getOut().setBody("Hello from Karavan Pod");
    }
  }
}