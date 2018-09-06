package edu.ap.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import edu.ap.spring.jpa.Joke;
import edu.ap.spring.jpa.JokeRepository;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

@Controller
@Scope("session")
public class JokeController {
   
	@Autowired
	JokeRepository repository;
	
	public JokeController() {
	}
       
	@RequestMapping("/joke")
	public String joke() {
		
		return "joke";
	}
		   
	@PostMapping("/joke_post")
	public String joke_post(@RequestParam("voorNaam") String VoorNaam_s, 
				 			@RequestParam("achterName") String AchterNaam_s,
			 				Model model) {
		
		
		String random_joke = callURL("http://api.icndb.com/jokes/random?firstName=" + VoorNaam_s + "&lastName=" + VoorNaam_s);
		
		
		model.addAttribute("joke_string", random_joke);
		
		//if (repository.findByJoke(joke_s) == null) {
			repository.save(new Joke(random_joke));
		//}
	   
   		return "joke_result";
	}
   
	@RequestMapping("/")
	public String root() {
		return "joke";
	}
	
	public static String callURL(String myURL) {
		System.out.println("Requeted URL:" + myURL);
		StringBuilder sb = new StringBuilder();
		URLConnection urlConn = null;
		InputStreamReader in = null;
		try {
			URL url = new URL(myURL);
			urlConn = url.openConnection();
			if (urlConn != null)
				urlConn.setReadTimeout(60 * 1000);
			if (urlConn != null && urlConn.getInputStream() != null) {
				in = new InputStreamReader(urlConn.getInputStream(),
						Charset.defaultCharset());
				BufferedReader bufferedReader = new BufferedReader(in);
				if (bufferedReader != null) {
					int cp;
					while ((cp = bufferedReader.read()) != -1) {
						sb.append((char) cp);
					}
					bufferedReader.close();
				}
			}
		in.close();
		} catch (Exception e) {
			throw new RuntimeException("Exception while calling URL:"+ myURL, e);
		} 
 
		return sb.toString();
	}
}
