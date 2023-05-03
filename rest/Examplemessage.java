import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import javax.inject.Named;
import javax.inject.Singleton;

public class Examplemessage {

public String hello;

public Examplemessage(){

}

public setHello(String hello){
  this.hello = hello;
}
  
}