
public class BookLineConverter implements LineConverter<Book>{

	@Override
	public String toLine(Book object) {
		return object.getTitle()+","+object.getAuthor() + "," + object.getStatus();
	}

	@Override
	public Book fromLine(String line) {

		String[] parts = line.split(",");
		String title = parts[0];
		String author = parts[1];
		String status = parts[2];
		long date = Long.parseLong(parts[3]);
	
		return new Book(title,author,status,1);
	}

}