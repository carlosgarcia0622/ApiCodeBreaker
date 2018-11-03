package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import com.udea.DojoTDDMaven.CodeBreaker;

import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private CodeBreaker codeBreaker = new CodeBreaker();

    @GetMapping("/guess/{id}")
    public CodeBreaker greeting(@PathVariable String id) {
    	String result = "";
		result = codeBreaker.guess(id);
        return new CodeBreaker(result, "Hola perras");
        		//new Greeting(counter.incrementAndGet(),
                 //           String.format(template, name));
    }
    
    /*@PostMapping(path = "/guess"){
    	return new codeBreaker()
    }*/
}
