package edu.ap.spring.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Joke {
	@Id
    @GeneratedValue
    private Long id;
	
	@Column
	private String Joke;

	public Joke(String joke) {
		super();
		Joke = joke;
	}


	public String getJoke() {
		return Joke;
	}

	public void setJoke(String joke) {
		Joke = joke;
	}

	@Override
	public String toString() {
		return "Joke [id=" + id + ", Joke=" + Joke + "]";
	}
}
