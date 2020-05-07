import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class LibraryApp {

	
	private static FileHelper<Book> helper = new FileHelper<>("library.txt", new BookLineConverter());
	public static ArrayList<Book> books = new ArrayList<>();
	
static {
	
	helper.append(new Book("A","a","true",1));
	books.add(new Book("B","b","true",1));
	books.add(new Book("C","c","true",1));
	books.add(new Book("D","d","true",1));
	books.add(new Book("E","e","true",1));
	books.add(new Book("F","f","true",1));
	books.add(new Book("E","g","true",1));
	books.add(new Book("F","h","true",1));
	books.add(new Book("G","i","true",1));
	books.add(new Book("H","j","true",1));
	books.add(new Book("I","k","true",1));
	books.add(new Book("J","l","true",1));

	
}
	
	public static void main(String[] args) {
		
		
		List<Book> allBook = helper.readAll();
		for (Book b : allBook) {
			System.out.println(b);
		}
		
	}

	
	
}
