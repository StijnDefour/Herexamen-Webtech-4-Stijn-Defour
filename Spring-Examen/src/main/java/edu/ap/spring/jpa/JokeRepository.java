package edu.ap.spring.jpa;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface JokeRepository  extends CrudRepository<Joke, Long> {
	public List<Joke> findByJoke(String joke);
}
