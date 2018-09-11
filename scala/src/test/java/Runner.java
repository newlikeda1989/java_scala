/**
 * 
 */


import com.app.model.Book;
import com.app.storage.BookStorage;

/**
 * @author Jason.lee
 *
 */
public class Runner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BookStorage storage = new BookStorage();
		storage.getBooks().stream().forEach((Book b) -> System.out.println(b));
	}

}
