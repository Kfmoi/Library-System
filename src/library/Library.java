package library;

import java.util.ArrayList;

import Item.Item;

public class Library {
    private final int ID;
    private final String name;
    private ArrayList<Item> items = new ArrayList<>();

    public Library(int ID, String name){
        this.ID = ID;
        this.name = name;
    }

    public int getID(){
        return ID;
    }

    public String libraryName(){
        return name;
    }

    public ArrayList<Item> getItems(){
        return items;
    }

    public void addItem(Item item){
        items.add(item);
    }

    public void removeItem(Item item){
        items.remove(item);
    }

    public static Library getLibrary(int ID, ArrayList<Library> libraries) {
        for (Library library : libraries) {
            if (library.getID() == ID) {
                return library;
            }
        }
        return null;
    }
}
