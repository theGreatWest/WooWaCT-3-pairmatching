package menu.service;

import menu.model.Coach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AppServiceTest {
    AppService appService = new AppService(new DatabaseService(), new ValidationService());

    @DisplayName("중복되는 메뉴 생기면 실패")
    @Test
    void 중복되는_메뉴_생기면_실패(){
        Coach coach = new Coach("hi", new ArrayList<>(Arrays.asList("불고기", "스시")));
        List<Coach> coaches = new ArrayList<>(Collections.singletonList(coach));

        for(int i=0;i<10;i++){
            String recommendedResult = appService.startRecommend(coaches);
            System.out.println(recommendedResult);
        }
    }

    @DisplayName("카테고리가 같은 것이 3개 이상인 케이스가 발생하면 실패")
    @Test
    void 카테고리_같은_것_3개_미만인지_확인(){
        int[] num = new int[5];
        for(int i=0;i<10;i++){
            List<String> categories = appService.createCategories();
            for(String category : categories){
                if(category.equals("일식")) num[0]++;
                if(category.equals("한식")) num[1]++;
                if(category.equals("중식")) num[2]++;
                if(category.equals("아시안")) num[3]++;
                if(category.equals("양식")) num[4]++;
            }
            for(int n : num){
                if(n>2) System.out.println("Category Test"+(i+1)+": FAIL...");
            }
            System.out.println("Category Test"+(i+1)+": SUCCESS!");
            num = new int[5];
        }
    }

    @DisplayName("못 먹는 메뉴 포함해서 추천하면 실패")
    @Test
    void 못_먹는_메뉴_포함해서_추천하면_실패(){
        Coach coach = new Coach("hi", new ArrayList<>(Arrays.asList("불고기", "스시")));
        List<Coach> coaches = new ArrayList<>(Collections.singletonList(coach));

        int cnt = 0;
        for(int i=0;i<20;i++){
            String recommendedMenus = appService.startRecommend(coaches);
            if(recommendedMenus.contains("스시") || recommendedMenus.contains("불고기")) cnt++;
            if(cnt==0) System.out.println("Success!");
        }
    }
}
