package menu.repository;

import menu.core.constant.Constant;
import menu.model.Menu;

import java.util.ArrayList;
import java.util.List;

public class Menus {
    private final List<Menu> menus;

    public Menus() {
        this.menus = getData();
    }

    private List<Menu> getData(){
        List<Menu> tmpMenus = new ArrayList<>();
        String unprocessedData = "일식: 규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼\n" +
                "한식: 김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음\n" +
                "중식: 깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채\n" +
                "아시안: 팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜\n" +
                "양식: 라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니";

        for(String category : unprocessedData.split(Constant.NEW_LINE)){
            String[] menu = category.split(":");
            for(String name : menu[1].split(Constant.COMMA)){
                tmpMenus.add(new Menu(menu[0], name.trim()));
            }
        }
        return tmpMenus;
    }

    public List<Menu> getMenus(){
        return this.menus;
    }
}
