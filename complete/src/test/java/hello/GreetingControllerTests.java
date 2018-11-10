/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package hello;


//import main.java.hello.CodeBreaker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GreetingControllerTests {
	
	private CodeBreaker code = new CodeBreaker("1234");
	String result;


    
    @Test
	public void guessAllMatch() {
		result = code.guess("1234");
		assertEquals("xxxx", result);
	}
	
	@Test
	public void guessOneFailAndThreeMatch(){
		result = code.guess("0234");
		assertEquals("xxx", result);
	}
	
	@Test
	public void guessTwoFailAndTwoMatch(){
		result = code.guess("0034");
		assertEquals("xx", result);
	}
	
	@Test
	public void guessThreeFailAndOneMatch(){
		result = code.guess("0004");
		assertEquals("x", result);
	}
	
	@Test
	public void guessAllFail(){
		result = code.guess("0000");
		assertEquals("", result);
	}
	
	@Test
	public void guessAllMessy(){
		result = code.guess("4321");
		assertEquals("____", result);
	}
	
	@Test
	public void guessThreeMessy(){
		result = code.guess("4120");
		assertEquals("___", result);
	}
	
	@Test
	public void guessTwoMessy(){
		result = code.guess("0041");
		assertEquals("__", result);
	}
	
	@Test
	public void guessOneMessy(){
		result = code.guess("0040");
		assertEquals("_", result);
	}
	
	@Test
	public void guessOneMatchThreeMessy(){
		result = code.guess("2314");
		assertEquals("x___", result);
	}
	
	@Test
	public void guessTwoMatchTwoMessy(){
		result = code.guess("1432");
		assertEquals("xx__", result);
	}
	
	@Test
	public void guessOneFailThreeMessy(){
		result = code.guess("4320");
		assertEquals("___", result);
	}
	
	@Test
	public void guessTwoFailTwoMessy(){
		result = code.guess("0041");
		assertEquals("__", result);
	}
	
	@Test
	public void guessThreeFailOneMessy(){
		result = code.guess("0400");
		assertEquals("_", result);
	}
	
}
    
    


