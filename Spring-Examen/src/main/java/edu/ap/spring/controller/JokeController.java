package edu.ap.spring.controller;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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
import java.util.List;

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
			 				Model model) throws ParseException {
		
		
		String random_joke = callURL("http://api.icndb.com/jokes/random?firstName=" + VoorNaam_s + "&lastName=" + AchterNaam_s);
		
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(random_joke);
		JSONObject json_joke = (JSONObject) parser.parse(json.get("value").toString());
		
		model.addAttribute("joke_string", json_joke.get("joke"));
		
		boolean is_al_saved = false;
		List<Joke> joke_list = (List<Joke>) repository.findAll();
		for (int i = 0; i < joke_list.size(); i++) {
			if (joke_list.get(i).getJoke() == json_joke.get("joke").toString()) {
				is_al_saved = true;
				System.out.println("al in db");
			} else {
				System.out.println("nog niet in db");
			}
		}
		
		if (is_al_saved == false) {
			repository.save(new Joke(random_joke));
		}
	   
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
