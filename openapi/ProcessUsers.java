import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.BuilderSupport;
import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
@Named("ProcessUsers")
public class ProcessUsers implements Processor {

  public void process(Exchange exchange) throws Exception {
      if(exchange.getIn().getHeader(Exchange.HTTP_METHOD).equals("POST")) { 
         System.out.println("Post method :" + exchange.getIn().getBody());
         exchange.getOut().setHeader(Exchange.HTTP_RESPONSE_CODE, "202");
      }
      else  if(exchange.getIn().getHeader(Exchange.HTTP_METHOD).equals("DELETE")) {
         System.out.println("DELETE method :" + exchange.getIn().getBody());
         exchange.getOut().setHeader(Exchange.HTTP_RESPONSE_CODE, "200");
      }
      else  if(exchange.getIn().getHeader(Exchange.HTTP_METHOD).equals("GET")) {
        if(!exchange.getIn().getHeader(Exchange.HTTP_PATH, String.class).isEmpty()) {
          System.out.println("Received Get with HTTP_PATH:" + exchange.getIn().getHeader(Exchange.HTTP_PATH));
          exchange.getOut().setBody("{\"username\":\"Karavan_PATH\"}");
        }
        exchange.getOut().setBody("{\"username\":\"Karavan\"}");
        exchange.getOut().setHeader(Exchange.HTTP_RESPONSE_CODE, "200");
      }
  }
}