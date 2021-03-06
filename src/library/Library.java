package library;
import java.util.ArrayList;
import java.util.Iterator;


public class Library {

	// A list of books owned by the library, Question 2, b
		private ArrayList<Book> books;
		// The name of the library 
		private String name; 
		
		/**
		 *  Create a new library.
		 */
		public Library(String aName) 
		{
			name = aName; 
			books = new ArrayList<>();
		}
		
		/**
		 * Add a new Book to the library's book collection using the following parameters.
		 * 
		 * @param author The author of the book.
		 * @param title The title of the book.
		 * @param id The id of the book.
		 */
		public void addBook(String author, String title, String id) 
		{
			Book book = new Book(author, title, id);
			books.add(book);
		}
		
		/**
		 * Calculate a fine for returning a book late.
		 * 
		 * @param price The price of book.
		 * @param numberDays The number of days late.
		 * 
		 * @return The fine that the user need to pay.
		 */
		public double calculateFine(double price, int numberDays) 
		{
			double fine = 0;
			fine  = (price * 0.02) * numberDays;
			return fine;
			
		}
		
		/**
		 * Show the list of books that the library owns, whose titles match the given parameter.
		 * 
		 * @param The title of a book.
		 * 
		 * @return The list of books with the same title.
		 */
		public ArrayList<Book> getMachingBooks(String title) 
		{
			ArrayList<Book> machingList = new ArrayList<Book>();
			
			for(Book item:books) 
			{
				if(title.equals(item.getTitle())) 
				{
					machingList.add(item);
				}
			}
			return machingList;
		}

		/** 
		 * Check the availability of a book, searching by its title
		 * 
		 * @return Returns true if the parameterís title matches that of any book in the collection 
		 * and the book is not on loan
		 */
		public boolean isAvailable(Book book)  
		{
			for(Book item:books) 
			{
				if(book.getTitle().equals(item.getTitle()) && item.isOnLoan() != true) 
				{
					return true;
				}
			}
			return false;
		}
		
		/**
		 * Show a list of all the books in the library
		 */
		public void listAllBooks()
	    {
	        int position = 1;
	        for(Book item:books) {
	            System.out.println(position + ". "+ item);
	            position ++;
	        }
	    }
		
		/**
		 * Find the first book in the library that matches the parameter by id, and set
		 * it as loaned.
		 */
		public void loanBook(Book book) 
		{
			for(Book item:books) 
			{
				if(item.getId().equals(book.getId())) 
				{
					item.setOnLoan(true);
					return; // the method execution is stopped after the first book was found
				}
			}
				
		}

		/**
		 * Remove the first book with a matching id from the collection
		 */
		public void removeBook(Book book) 
		{
			Iterator<Book> it = books.iterator(); // initialise iterator
			while(it.hasNext()) //check whether there are more elements in collection
			{
				Book currentBook = it.next(); // get the next element
				
				// check whether the id of the element matches with that of the parameter			
				if(currentBook.getId().equals(book.getId())) 
				{
					it.remove(); // remove the book
					return; // the method execution is stopped after the first book was found
				} 
			}
			System.out.println("Book not found."); //print message if there in no book with a matching id
		}
}
