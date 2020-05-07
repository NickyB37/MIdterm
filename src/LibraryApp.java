
import java.util.ArrayList;
import java.util.List;

public class LibraryApp {

	
	private static FileHelper<Book> helper = new FileHelper<>("library.txt", new BookLineConverter());
	public static ArrayList<Book> books = new ArrayList<>();
	
static {
	
	helper.append(new Book("A","a","true"));
	helper.append(new Book("B","b","true"));
	helper.append(new Book("C","c","true"));
	helper.append(new Book("D","d","true"));
	helper.append(new Book("E","e","true"));
	helper.append(new Book("F","f","true"));
	helper.append(new Book("E","g","true"));
	helper.append(new Book("F","h","true"));
	helper.append(new Book("G","i","true"));
	helper.append(new Book("H","j","true"));
	helper.append(new Book("I","k","true"));
	helper.append(new Book("J","l","true"));

	
}
	
	public static void main(String[] args) {

	listBooks();
	
}

	private static void listBooks() {
		List<Book> allBook = helper.readAll();
		for (Book b : allBook) {
			System.out.println(b);
		}
		
	}
}
