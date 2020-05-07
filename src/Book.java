import java.util.Date;

public class Book {

	protected String title;
	protected String author;
	protected boolean status;
	protected Date dueDate;
	
	public Book(String title, String author, boolean status, Date dueDate) {
		super();
		this.title = title;
		this.author = author;
		this.status = status;
		this.dueDate = dueDate;
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
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", status=" + status + ", dueDate=" + dueDate + "]";
	}
	
	
}
