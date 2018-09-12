package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Application contains starting page which has table with the jokes. User can add his own jokes into the
 * table. Each row of the table represents one joke. Each joke has its number of likes and number of dislikes.
 * User can like or dislike each joke by pressing the button. Jokes are sorted in the table by difference 
 * between number of likes and number of dislikes.
 * 
 * @author Toni Martinčić
 * @version 1.0
 */
@SpringBootApplication
public class Application {

	/**
	 * Main method which starts the execution of the application.
	 * 
	 * @param args arguments of the command line, unused
	 */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}