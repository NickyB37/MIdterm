

public class Book {

	protected String title;
	protected String author;
	protected String status;
	
	public Book(String title, String author, String status) {
		super();
		this.title = title;
		this.author = author;
		this.status = status;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", status=" + status + ", dueDate= ]";
	}
	
	
}
