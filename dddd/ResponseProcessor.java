import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
@Named("ResponseProcessor")
public class ResponseProcessor implements Processor {

  public void process(Exchange exchange) throws Exception {
    if(exchange.getIn().getBody().equals("quit")) {
       exchange.getOut().setHeader(NettyConstants.NETTY_CLOSE_CHANNEL_WHEN_COMPLETE, true);
    }
    else {
       exchange.getOut().setBody("Hello from Karavan Pod");
    }
  }
}