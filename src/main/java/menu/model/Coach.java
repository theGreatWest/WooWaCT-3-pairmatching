package menu.model;

import java.util.List;

public class Coach {
    private String name;
    private List<String> cantEatMenus;

    public Coach(String name, List<String> cantEatMenus) {
        this.name = name;
        this.cantEatMenus = cantEatMenus;
    }

    public String getName() {
        return name;
    }

    public List<String> getCantEatMenus() {
        return cantEatMenus;
    }
}
