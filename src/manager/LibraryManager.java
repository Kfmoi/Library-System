package manager;

import java.util.ArrayList;
import java.util.Scanner;

import Item.Books;
import Item.Item;
import Item.VideoGames;
import library.Library;
import person.Person;

public class LibraryManager {
    private Scanner userInput;
    private ArrayList<Person> people = new ArrayList<>();
    private ArrayList<Library> libraries = new ArrayList<>();
    private ArrayList<Item> items = new ArrayList<>();

    public LibraryManager() {
        userInput = new Scanner(System.in);
    }

    public void start() {
        int choice;
        do {
            System.out.println("Choose an option:");
            System.out.println("1. Create a Person");
            System.out.println("2. Create a Library");
            System.out.println("3. Create an Item");
            System.out.println("4. Borrow an Item");
            System.out.println("5. Return an Item");
            System.out.println("6. Exit");

            choice = userInput.nextInt();

            switch (choice) {
                case 1:
                    createPerson();
                    break;
                case 2:
                    createLibrary();
                    break;
                case 3:
                    createItem();
                    break;
                case 4:
                    borrowItem();
                    break;
                case 5:
                    returnItem();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
    }

    private void createPerson() {
        System.out.println("Creating a Person...");

        System.out.print("Enter person's name: ");
        String name = userInput.next();

        System.out.print("Enter library card number: ");
        int libraryCard = userInput.nextInt();

        Person person = new Person(name, libraryCard);
        System.out.println("Person created: " + person);
        people.add(person);
    }

    private void createLibrary() {
        System.out.println("Creating a Library...");

        System.out.println("Enter Library ID: ");
        int libraryID = userInput.nextInt();

        System.out.println("Enter Library Name: ");
        String libraryName = userInput.next();

        Library library = new Library(libraryID, libraryName);
        System.out.println("Library created: " + library);
        libraries.add(library);
    }

    private void createItem() {
        System.out.println("Creating an Item...");

        System.out.println("Is it a Book or Video Game ?");
        String itemType = userInput.next();

        if (itemType.equalsIgnoreCase("Book")) {
            System.out.println("Enter Book ID: ");
            int bookID = userInput.nextInt();

            System.out.println("Enter Book Name: ");
            String bookName = userInput.next();

            Books book = new Books(bookID, bookName);
            System.out.println("Book created: " + book);
            items.add(book);

            System.out.println("Would you like to add it to a Library? (yes/no)");
            String addToLibraryChoice = userInput.next();

            if (addToLibraryChoice.equalsIgnoreCase("yes")) {
                addBookToLibrary(book);
            }

        } else if (itemType.equalsIgnoreCase("Video Game")) {
            System.out.println("Enter Video Game ID: ");
            int videoGameID = userInput.nextInt();

            System.out.println("Enter Video Game Name: ");
            String videoGameName = userInput.next();

            VideoGames videoGame = new VideoGames(videoGameID, videoGameName);
            System.out.println("Video Game created: " + videoGame);
            items.add(videoGame);

            System.out.println("Would you like to add it to a Library? (yes/no)");
            String addToLibraryChoice = userInput.next();

            if (addToLibraryChoice.equalsIgnoreCase("yes")) {
                addVGToLibrary(videoGame);
            }
        } else {
            System.out.println("Invalid item type.");
        }
    }

    private void addBookToLibrary(Books book) {
        System.out.println("Enter Library ID to add book to: ");
        int libraryID = userInput.nextInt();

        boolean libraryCheck = checkLibraries(libraryID);

        if (libraryCheck) {
            Library library = Library.getLibrary(libraryID, libraries);
            library.addItem(book);
            System.out.println("Item added to Library " + libraryID);
        } else {
            System.out.println("Library with ID " + libraryID + " not found.");
        }
    }

    private void addVGToLibrary(VideoGames vg) {
        System.out.println("Enter Library ID to add video game to: ");
        int libraryID = userInput.nextInt();

        boolean libraryCheck = checkLibraries(libraryID);
        if (libraryCheck) {
            Library library = Library.getLibrary(libraryID, libraries);
            library.addItem(vg);
            System.out.println("Item added to Library " + libraryID);
        } else {
            System.out.println("Library with ID " + libraryID + " not found.");
        }

    }

    private void borrowItem() {
        System.out.println("Enter your Library Card: ");
        int libraryCard = userInput.nextInt();
        Item item;

        Person person = Person.getPerson(libraryCard, people);
        if (person != null) {
            System.out.println("Enter Item Name: ");
            String itemName = userInput.next();

            item = getItemByName(itemName);

            if (item != null) {
                System.out.println("Enter Library ID: ");
                int libraryID = userInput.nextInt();

                Library library = Library.getLibrary(libraryID, libraries);
                person.borrowItem(library, item);
            } else {
                System.out.println("Item not found.");
            }

        } else {
            System.out.println("Person with Library Card " + libraryCard + " not found.");
        }
    }

    private void returnItem() {
        System.out.println("Enter your Library Card: ");
        int libraryCard = userInput.nextInt();
        Item item;

        Person person = Person.getPerson(libraryCard, people);
        if (person != null) {
            System.out.println("Enter Item Name: ");
            String itemName = userInput.next();

            item = getItemByName(itemName);

            if (item != null) {
                person.returnItem(item);
            } else {
                System.out.println("Item not found.");
            }

        } else {
            System.out.println("Person with Library Card " + libraryCard + " not found.");
        }

    }

    private boolean checkLibraries(int libraryID) {
        Library library = Library.getLibrary(libraryID, libraries);
        if (library != null) {
            return true;
        } else {
            return false;
        }
    }

    private Item getItemByName(String name) {
        for (Item item : items) {
            if (item.getTitle().equals(name)) {
                return item;
            }
        }
        return null;
    }
}
