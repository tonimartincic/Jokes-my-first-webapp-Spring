package application;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Class represents records which are stored in the {@link JokeRepository}. Each {@link Joke} contains 
 * its unique id which is generated automatically, its content and number of likes and dislikes.
 * 
 * @author Toni Martinčić
 * @version 1.0
 */
@Entity
public class Joke {

	/**
	 * Jokes' id.
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    public int id;
    
	/**
	 * Joke's content.
	 */
	@Column(nullable = false, length = 1024)
    public String content;
    
    /**
     * Number of likes.
     */
    public int likes;
    
    /**
     * Number of dislikes.
     */
    public int dislikes;
    
    /**
     * Constructor which accepts no arguments.
     */
    public Joke() {
	}
    
    /**
     * Constructor which accepts three arguments; joke's content and number of likes and dislikes
     * of the joke.
     * 
     * @param content joke's content.
     * @param likes number of likes
     * @param dislikes number of dislikes
     */
    public Joke(String content, int likes, int dislikes) {
		super();
		this.content = content;
		this.likes = likes;
		this.dislikes = dislikes;
	}

	/**
     * Getter for the joke's id.
     * 
     * @return joke's id
     */
	public int getId() {
		return id;
	}

	/**
	 * Setter for the joke's id.
	 *  
	 * @param id joke's id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter for the joke's content.
	 * 
	 * @return joke's content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Setter for the joke's content.
	 * 
	 * @param content joke's content
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * Getter for the number of likes.
	 * 
	 * @return number of likes
	 */
	public int getLikes() {
		return likes;
	}

	/**
	 * Setter for the number of likes.
	 * 
	 * @param likes number of likes
	 */
	public void setLikes(int likes) {
		this.likes = likes;
	}

	/**
	 * Getter for the number of dislikes.
	 * 
	 * @return number of dislikes
	 */
	public int getDislikes() {
		return dislikes;
	}

	/**
	 * Setter for the number of dislikes.
	 * 
	 * @param dislikes number of dislikes
	 */
	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Joke other = (Joke) obj;
		if (id != other.id)
			return false;
		return true;
	}
}