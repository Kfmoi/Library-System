package person;

import java.util.ArrayList;

import Item.Item;
import library.Library;

public class Person{
    private final String name;
    private final int libraryCard;
    private ArrayList<Item> itemsBorrowed = new ArrayList<>();

    public Person(String name, int libraryCard){
        this.name = name;
        this.libraryCard = libraryCard;
    }

    public void borrowItem(Library library, Item item){
        if (library.getItems().contains(item) && item.getStatus()){
            itemsBorrowed.add(item);
            item.changeStatus();
            System.out.println(item.getTitle() + " is successfully borrowed");
        } else {
            System.out.println("This item is not currently available");
        }
    }

    public void returnItem(Item item){
        if(!item.getStatus()){
            item.changeStatus();
            System.out.println(item.getTitle() + " is successfully returned");
        } else {
            System.out.println("This item has not been taken out");
        }
    }

    public ArrayList<Item> getBorrowedItems(){
        return itemsBorrowed;
    }

    public String getName(){
        return name;
    }

    public int getLibraryCard(){
        return libraryCard;
    }

    public static Person getPerson(int ID, ArrayList<Person> people) {
        for (Person person : people) {
            if (person.getLibraryCard() == ID) {
                return person;
            }
        }
        return null;
    }
}