package application;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * Interface extends {@link PagingAndSortingRepository} and it is used for storing the instances of the
 * class {@link Joke}.
 * 
 * @author Toni Martinčić
 * @version 1.0
 */
public interface JokeRepository extends PagingAndSortingRepository<Joke, Integer> {
	
	/**
	 * Method increments number of likes for the {@link Joke} which id is accepted as argument.
	 * 
	 * @param jokeID joke's id
	 */
	@Modifying
    @Query("UPDATE Joke j SET j.likes = j.likes + 1 WHERE j.id = :jokeID")
	@Transactional
    void addLike(@Param("jokeID") int jokeID);
	
	/**
	 * Method increments number of dislikes for the {@link Joke} which id is accepted as argument.
	 * 
	 * @param jokeID joke's id
	 */
	@Modifying
    @Query("UPDATE Joke j SET j.dislikes = j.dislikes + 1 WHERE j.id = :jokeID")
	@Transactional
    void addDislike(@Param("jokeID") int jokeID);
	
	/**
	 * Method gets all the jokes from the database sorted by difference between number of likes and 
	 * number of dislikes.
	 * 
	 * @return all the jokes from the database sorted by difference between number of likes and 
	 * number of dislikes
	 */
    @Query("SELECT j FROM Joke j ORDER BY j.likes - j.dislikes DESC")
    public Iterable<Joke> findAllSorted();	
    
}
