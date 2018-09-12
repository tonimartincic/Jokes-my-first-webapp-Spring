package application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Class represents controller which is used for the handling requests which are coming from the client.
 * 
 * @author Toni Martinčić
 * @version 1.0
 */
@Controller
public class JokeController {

	/**
	 * Instance of {@link JokeRepository} which is used for storing instances of the class {@link Joke}.
	 */
	@Autowired
	private JokeRepository repository;
	
	/**
	 * Method gets all the jokes from the repository sorted by difference between number of likes and number
	 * of dislikes and adds them into the model as attribute. Then it calls starting page of the application 
	 * which contain all the jokes in the one table.
	 * 
	 * @param model instance of {@link Model} which is used for storing attributes
	 * @return String "index" which represents html file
	 */
	@GetMapping("/")
    public String index(Model model) {
		Iterable<Joke> allJokes = repository.findAllSorted();
        model.addAttribute("allJokes", allJokes);
        
        return "index";
    }
	
	/**
	 * Method add new instance of the {@link Joke} into the model attributes and then it calls page which
	 * contains form which accepts joke.
	 * 
	 * @param model instance of {@link Model} which is used for storing attributes
	 * @return String "new" which represents html file
	 */
    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("joke", new Joke());
        
        return "new";
    }

    /**
     * Method accepts instance of the {@link Joke} and adds it into the database.
     * 
     * @param joke instance of the {@link Joke}
     * @return String "result" which represents html file
     */
    @PostMapping("/new")
    public String newSubmit(@ModelAttribute Joke joke) {
    	repository.save(joke);
    	
        return "result";
    }
    
    /**
     * Method increments number of likes for the {@link Joke} which id is accepted as argument.
     * Then it gets all the jokes from the database sorted by difference between number of likes and number
     * of dislikes, adds them as attribute to the model and calls the starting page of the application.
     * 
     * @param id joke's id
     * @param model instance of {@link Model} which is used for storing attributes
     * @return String "index" which represents html file
     */
    @GetMapping("/like")
    public String like(@RequestParam(value="id", required=true) int id, Model model) {
        repository.addLike(id);
        
        Iterable<Joke> allJokes = repository.findAllSorted();
        model.addAttribute("allJokes", allJokes);
        
        return "index";
    }
    
    /**
     * Method increments number of dislikes for the {@link Joke} which id is accepted as argument.
     * Then it gets all the jokes from the database sorted by difference between number of likes and number
     * of dislikes, adds them as attribute to the model and calls the starting page of the application.
     * 
     * @param id joke's id
     * @param model instance of {@link Model} which is used for storing attributes
     * @return String "index" which represents html file
     */
    @GetMapping("/dislike")
    public String dislike(@RequestParam(value="id", required=true) int id, Model model) {
        repository.addDislike(id);
        
        Iterable<Joke> allJokes = repository.findAllSorted();
        model.addAttribute("allJokes", allJokes);
        
        return "index";
    }
    
    
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
    //																																    //
    // Ovaj dio koda je ubačen samo da Vama olakša provjeru rada aplikacije, u aplikaciju sam dodao gumb koji dodaje neke viceve u bazu //
    //																																    //
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
    
    
    /**
     * Instance of {@link Joke}.
     */
    private static Joke joke1 = 
    		new Joke("Zašto je Chuck Norris najjači? Zato što vježba dva dana dnevno", 72, 10);
    
    /**
     * Instance of {@link Joke}.
     */
    private static Joke joke2 = 
    		new Joke("Pita nastavnica hrvatskog jezika mladog osnovnoškolca: Reci ti meni što su to prilozi? Prilozi su: ketchup, majoneza, luk, salata...", 80, 40);
   
    /**
     * Instance of {@link Joke}.
     */
    private static Joke joke3 = 
    		new Joke("Pričaju dvije gimnazijalke: Nema mi roditelja doma ovaj vikend! Bože, pa koja si ti sretnica! Možeš učiti naglas!", 25, 2);
   
    /**
     * Instance of {@link Joke}.
     */
    private static Joke joke4 = 
    		new Joke("Došao Mujo u pizzeriju i naručio pizzu. Konobar ga upita: Želite da vam izrežem pizzu na 6 ili 12 komada? Ma na 6 komada, nema šanse da pojedem 12.", 32, 9);
    
    /**
     * Method adds four instances of {@link Joke} into the repository.
     * 
     * @param model instance of {@link Model} which is used for storing attributes
     * @return String "index" which represents html file
     */
    @GetMapping("/addExamples")
    public String addExamples(Model model) {
    	repository.save(joke1);
    	repository.save(joke2);
    	repository.save(joke3);
    	repository.save(joke4);
    	
    	Iterable<Joke> allJokes = repository.findAllSorted();
        model.addAttribute("allJokes", allJokes);
        
        return "index";
    }
}