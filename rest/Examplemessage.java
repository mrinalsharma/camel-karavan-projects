import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import javax.inject.Named;
import javax.inject.Singleton;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Examplemessage {

@JsonProperty
public String hello;

public Examplemessage(){

}

public void setHello(String hello){
  this.hello = hello;
}
  
}