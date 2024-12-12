package menu.model;

public class Menu {
    private String type;
    private String name;

    public Menu(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public String getType() {
        return type;
    }
}
