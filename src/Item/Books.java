package Item;


public class Books implements Item {
    private final int ID;
    private String title;
    private final Type type = Type.B;
    private boolean status;

    public Books(int ID, String title){
        this.ID = ID;
        this.title = title;
        status = true;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String name){
        this.title = name;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public void changeStatus() {
        status = !status;
    }

    @Override
    public boolean getStatus() {
        return status;
    }

    @Override
    public Item getItem(){
        return this;
    }

 
}
