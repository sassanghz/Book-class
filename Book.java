//---------------------------------------
// Assignment 0
// Question: You are hired by a bookstore to write a software that helps the store owner in keeping track of the books at the store.
// Written by: Sassan Ghazi Student ID: 40226489
//---------------------------------------

// Welcome to Sassan's first assignment solution to COMP-249
import java.util.Scanner;

public class Book {
	
    //Established attributes
	String title;
	String author;
	long IBSN;
	double price;
	
	public static int NumberOfCreatedBooks = 0;
	
    //Mutator constructor method
	public Book(String title, String author, double price, long IBSN) {
		this.title = title;
		this.author = author;
		this.IBSN = IBSN;
		this.price = price;
		NumberOfCreatedBooks++;
	}
	
    // The following codes display the getter method; returns the variables
    public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public long getISBN() {
		return IBSN;
	}
	
	public double getPrice() {
		return price;
	}
	
    // The following codes display the setter method; allows for changes in the variables
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setIBSN(long IBSN) {
		this.IBSN = IBSN;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public static int findNumberOfCreatedBooks() {
		return NumberOfCreatedBooks;
	}
	
	public boolean equals(Object one) {
		if (this == one) {
			return true;
		}else if (one == null || getClass() != one.getClass()){
			return false;
		}
		
		Book book = (Book) one;
		return IBSN == book.IBSN && Double.compare(book.price, price) == 0;
	}
	
    //Displays all the information of that object
	public String toString() {
		return "Book{" + "Title:" + title + "by" + author + "IBSN = " + "price = " + price + "}";  
	}

    //the findBooksBy static method accepts a string for an author name then preforms the needed search
    public static void findBooksBy(Book[] inventory, String authorName) {
       
        boolean found = false;
        
        //The for loop goes through all the objects in the inventory array
        for (Book book : inventory) {

            //In this statement, the condition is to find the books that are under the name of the author
            //The equals() method tries to check if the books match under the author's name
            if (book.getAuthor().equalsIgnoreCase(authorName)) {

                //the variable 'found' changes to true because the condition is passed
                found = true;

                //Displays all the information of the all books by that requested author
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Title: " + book.getTitle());
                System.out.println("ISBN: " + book.getISBN());
                System.out.println("Price: $" + book.getPrice());

            }
        }
        
        //The program switches to this statement since the object could not be found in the inventory
        if (!found) {
            System.out.println("No books found by author: " + authorName);
        }
    }

    public static void findCheaperThan(Book[] inventory, double bookPrice){

        for(Book value: inventory){

            if(value.getPrice() == bookPrice || bookPrice < value.getPrice()){

                System.out.println("Books available: " + value.getTitle());

            }else{
               
                System.out.println("No books could be found under the price you entered.");

            }
        }
    }

    public static void main(String[] args){

        // Welcome to the main method of the Book assignemnt

        Scanner sc = new Scanner(System.in);

       // Display a welcome message
       System.out.println("Welcome to the Bookstore Inventory System!");

       // Prompt the bookstore owner for the maximum number of books
       System.out.print("Enter the maximum number of books your bookstore can contain: ");
       int maxBooks = sc.nextInt();

       // Create an empty array called "inventory" to track Book objects
       Book[] inventory = new Book[maxBooks];

        System.out.println("What do you want to do?");

        System.out.println("\t" + "1.  Enter new books(password required)");
        System.out.println("\t" + "2.  Change information of a book(password required)");
        System.out.println("\t" + "3.  Display all books by a specific author");
        System.out.println("\t" + "4.  Display all books under a certain price");
        System.out.println("\t" + "5.  Quit");

        System.out.println("Please enter your choice >");
        int choice = sc.nextInt();

        switch(choice){
          
            case 1:

                final String PASSWORD = "249";
                final int MAX_ATTEMPTS = 3;
                final int MAX_SUSPICIOUS_ATTEMPTS = 12;
    
                int failedAttempts = 0;
                int suspiciousAttempts = 0;
    
                while (suspiciousAttempts < 4) {
                    System.out.print("Enter the password: ");
                    String inputPassword = sc.nextLine();
    
                    if (inputPassword.equals(PASSWORD)) {
                        System.out.println("Password accepted. Welcome!");
                        
                        /*Create a method in the Book class that will add new books into the bookstore */
                   
                        System.out.print("How many books do you want to enter? ");
                        int enteredAmount = sc.nextInt();
                    
    
                        if (maxBooks - inventory.length >= enteredAmount) {
                            // Add books to the inventory
                            for (int i = 0; i < enteredAmount; i++) {
                                
                            System.out.println("Enter details for book #" + (i + 1) + ":");
                            System.out.print("Title: ");
                            String title = sc.nextLine();
                            System.out.print("Author: ");
                            String author = sc.nextLine();
                            System.out.print("ISBN: ");
                            long isbn = sc.nextLong();
                            System.out.print("Price: ");
                            double price = sc.nextDouble();
    
                            Book newBook = new Book(title, author, IBSN, price);
                            inventory[inventory.length] = newBook;
                            inventory.length++;
                            System.out.println("Book added successfully.");
                            
                            }
                        } else {
                            
                            int remainingPlaces = maxBooks - inventory.length;
                            System.out.println("Not enough space in the inventory. Maximum remaining places: " + remainingPlaces);
                        }
                        break; // Exit the loop if the password is correct
                    } else {
                        System.out.println("Incorrect password. Please try again.");
                        failedAttempts++;
                   
                        if (failedAttempts >= MAX_ATTEMPTS) {
                            
                            suspiciousAttempts++;
                            System.out.println("Suspicious attempt detected (" + suspiciousAttempts + " of 4).");
    
                            if (suspiciousAttempts == 4) {
                                
                                System.out.println("Program detected suspicious activities and will terminate immediately!");
                                System.exit(0); // Terminate the program
                            }
    
                            failedAttempts = 0; // Reset failed attempts
                        }
                    }
                }
                break;
           
        
                 

            case 2:
           
                final String password = "249";
                final int MX_ATTEMPTS = 3;
                int failedattempts = 0;

                while (true) {
                    
                    System.out.print("Enter the password: ");
                    String enteredPassword = sc.nextLine();
            
                    if (enteredPassword.equals(password)) {
                        
                        System.out.println(" Which book number do you wish to update?");
                        int bookUPDATE = sc.nextInt();
                    
                        for(int i = 0; i < inventory.length; i++){
                      
                            if(bookUPDATE == i){

                                Book selectedBook = inventory[i];
                            
                                System.out.println("Current information of the selected book:");
                                System.out.println("Book # " + bookUPDATE);
                                System.out.println("Author: " + selectedBook.getAuthor());
                                System.out.println("Title: " + selectedBook.getTitle());
                                System.out.println("ISBN: " + selectedBook.getISBN());
                                System.out.println("Price: $" + selectedBook.getPrice());

                                System.out.println("What information would you like to change? ");
                                System.out.println("\t" + "1. author");
                                System.out.println("\t" + "2. title");
                                System.out.println("\t" + "3. ISBN");
                                System.out.println("\t" + "4. price");
                                System.out.println("\t" + "5. Quit");
                                System.out.println(" Enter your choice >");
                                int enteredChoice = sc.nextInt();

                                switch(enteredChoice){
                               
                                    case 1:
                                        
                                        System.out.print("Enter the new author: ");
                                        String newAuthor = sc.nextLine();
                                        selectedBook.setAuthor(newAuthor);

                                        System.out.println("New information of the selected book:");
                                        System.out.println("Author: " + selectedBook.getAuthor());
                                        System.out.println("Title: " + selectedBook.getTitle());
                                        System.out.println("ISBN: " + selectedBook.getISBN());
                                        System.out.println("Price: $" + selectedBook.getPrice());

                                        System.out.println("Would you like to make new changes? (yes/no)");
                                        String changes = sc.nextLine();

                                        if(changes == "yes"){
                                            continue;
                                        }else{
                                            break;
                                        }


                                    case 2:
                                        
                                        System.out.println("Enter the new title: ");
                                        String newTitle = sc.nextLine();
                                        selectedBook.setTitle(newTitle);
                                    
                                        System.out.println("New information of the selected book:");
                                        System.out.println("Author: " + selectedBook.getAuthor());
                                        System.out.println("Title: " + selectedBook.getTitle());
                                        System.out.println("ISBN: " + selectedBook.getISBN());
                                        System.out.println("Price: $" + selectedBook.getPrice());

                                        System.out.println("Would you like to make new changes? (yes/no)");
                                        String changes1 = sc.nextLine();

                                        if(changes1 == "yes"){
                                        
                                            continue;

                                        }else{
                                        
                                            break;
                                        }

                                    case 3:
                                    
                                        System.out.println("Enter the new ISBN: ");
                                        long newISBN = sc.nextLong();
                                        selectedBook.setIBSN(newISBN);
                                    
                                        System.out.println("New information of the selected book:");
                                        System.out.println("Author: " + selectedBook.getAuthor());
                                        System.out.println("Title: " + selectedBook.getTitle());
                                        System.out.println("ISBN: " + selectedBook.getISBN());
                                        System.out.println("Price: $" + selectedBook.getPrice());

                                        System.out.println("Would you like to make new changes? (yes/no)");
                                        String changes2 = sc.nextLine();

                                        if(changes2 == "yes"){
                                            
                                            continue;

                                        }else{
                                            
                                            break;

                                        }

                                    case 4:
                                  
                                        System.out.println("Enter the new price: ");
                                        double newPrice = sc.nextDouble();
                                        selectedBook.setPrice(newPrice);
                                    
                                        System.out.println("New information of the selected book:");
                                        System.out.println("Author: " + selectedBook.getAuthor());
                                        System.out.println("Title: " + selectedBook.getTitle());
                                        System.out.println("ISBN: " + selectedBook.getISBN());
                                        System.out.println("Price: $" + selectedBook.getPrice());

                                        System.out.println("Would you like to make new changes? (yes/no)");
                                        String changes4 = sc.nextLine();

                                        if(changes4 == "yes"){
                                        
                                            continue;
                                        
                                        }else{
                                        
                                            break;
                                        }

                                
                                    case 5:
                                    
                                        break;

                                    default:
                                    
                                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                                }
                            
                            }else{
                            
                                System.out.println("Do you wish to re-enter(1) the book number or return(2) to the main menu?");
                                int inputNum = sc.nextInt();

                                switch(inputNum){

                                    case 1: 
                                        System.out.print("Enter the password: ");
                                        String re_enteredPassword = sc.nextLine();

                                        if(re_enteredPassword.equals(password)){

                                        }
                                
                                    case 2:
                                        
                                        break;
                                }
                            }
                        }
                    
                    } else {
                    
                        System.out.println("Incorrect Password. Please try again.");
                        failedattempts++;
            
                        if (failedattempts >= MX_ATTEMPTS) {
                           
                            System.out.println("Max attempts reached. Returning to the main menu.");
                            break; // Exit the password loop and back to the main menu
                        }
                    }
                }
                break;


                

                case 3:

                    System.out.println("Please enter the name of the author:");
                    String authorName = sc.nextLine();

                    Book.findBooksBy(inventory, authorName);
                    break;

                case 4:

                    System.out.println("Please enter the price of the book: ");
                    double bookPrice = sc.nextDouble();

                    Book.findCheaperThan(inventory, bookPrice);
                    break;
               
                case 5:

                    System.out.println("User selected 'Quit'. Program exit.");
                    System.exit(0);
                    
        }


    }

}
