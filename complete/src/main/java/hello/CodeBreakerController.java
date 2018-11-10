package hello;

import org.springframework.web.bind.annotation.*;


@RestController
public class CodeBreakerController {

    private CodeBreaker codeBreaker;

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
    
    
    @RequestMapping(value = "/secret", method = RequestMethod.POST)
    public void generateSecret(@RequestBody String secret) {
    	
    	codeBreaker = new CodeBreaker(secret);
    	
    }
    
    @RequestMapping(value = "/randomSecret", method = RequestMethod.POST)
    public void generateRandomSecret() {
    	
    	codeBreaker = new CodeBreaker();
    	
    }
    
}
