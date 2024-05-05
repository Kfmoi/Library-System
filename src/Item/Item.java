package Item;


public interface Item {
    int getID();
    String getTitle();
    void setTitle(String name);
    Type getType();
    void changeStatus();
    boolean getStatus();
    Item getItem();
    

}