package hello;

import java.util.Map;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;


@RestController
public class CodeBreakerController {

    private CodeBreaker codeBreaker;

    @CrossOrigin(origins="")
    @GetMapping("/guess/{id}")
    public CodeBreaker greeting(@PathVariable String id) {
    	String result = "";
		result = codeBreaker.guess(id);
		String message ="";
		
		if(result.compareTo("xxxx") ==0) {
			message = "Ganaste";
		}
		else {
			message = "Sigue intentando";
		}
		
        return new CodeBreaker(result, message);
        		
    }
    
    @CrossOrigin(origins="")
    @RequestMapping(value = "/guess", method = RequestMethod.POST, headers= {"accept=aplication/json","content-type=application/json","content-type=text/plain"})
    public void generateSecret(@RequestBody Optional<Map<String, String>> secret) {
    	if(secret.isPresent()) {
    		codeBreaker = new CodeBreaker(secret.get().get("secret"));
    		
    	}
    	else {
    		codeBreaker = new CodeBreaker();
    	}
    		

    	
    	
    }
    @CrossOrigin(origins="")
    @RequestMapping(value = "/randomSecret", method = RequestMethod.POST)
    public void generateRandomSecret() {
    	
    	codeBreaker = new CodeBreaker();
    	
    }
    
}
