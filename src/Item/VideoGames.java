package Item;

public class VideoGames implements Item {

    private final int ID;
    private String title;
    private final Type type = Type.VG;
    private boolean status;

    public VideoGames(int ID, String name){
        this.ID = ID;
        this.title = name;
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
    public void setTitle(String name) {
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
