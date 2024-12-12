package menu.service;

import menu.model.Menu;
import menu.repository.Menus;

import java.util.ArrayList;
import java.util.List;

public class DatabaseService {
    private final List<Menu> menus;

    public DatabaseService() {
        Menus menus = new Menus();
        this.menus = menus.getMenus();
    }

    public List<Menu> readTargetMenusByCategory(String type){
        List<Menu> targetMenu = new ArrayList<>();
        for(Menu menu : menus){
            if(menu.getType().equalsIgnoreCase(type)) targetMenu.add(menu);
        }
        return targetMenu;
    }
}
