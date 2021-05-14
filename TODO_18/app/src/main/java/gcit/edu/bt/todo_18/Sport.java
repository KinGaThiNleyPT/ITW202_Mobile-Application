package gcit.edu.bt.todo_18;

public class Sport {
    private final int imageResource;
    private String title, info;

    public Sport(String title, String info, int imageResource){
        this.title =title;
        this.info=info;
        this.imageResource = imageResource;
    }
    public int getImageResource(){
        return imageResource;
    }
    public String  getTitle(){
        return title;
    }
    public String getInfo(){
        return info;
    }
}
