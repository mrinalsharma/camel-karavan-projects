import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.BuilderSupport;
import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
@Named("ProcessUsers")
public class ProcessUsers implements Processor {

  public void process(Exchange exchange) throws Exception {
      if(exchange.getIn().getHeader(Exchange.HTTP_METHOD).equalc("POST")) { 
         System.out.println("Post method :" + exchange.getIn().getBody());
      }
      else  if(exchange.getIn().getHeader(Exchange.HTTP_METHOD).equalc("DELETE")) {
         System.out.println("DELETE method :" + exchange.getIn().getBody());
      }
      else  if(exchange.getIn().getHeader(Exchange.HTTP_METHOD).equals("GET")) {
        if(!exchange.getIn().getHeader(Exchange.HTTP_QUERY).isEmpty()) {
          System.out.println("Received Get with Parameter:" + exchange.getIn().getHeader(Exchange.HTTP_QUERY));
        }
        exchange.getOut().setBody("{\"username\":\"Karavan\"}");
      }
      exchange.getOut().setHeader(Exchange.HTTP_RESPONSE_CODE, "200");
  }
}