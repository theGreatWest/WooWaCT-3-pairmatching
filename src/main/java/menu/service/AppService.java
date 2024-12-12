package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.core.constant.Category;
import menu.core.constant.Constant;
import menu.model.Coach;

import java.util.ArrayList;
import java.util.List;

public class AppService {
    private final DatabaseService databaseService;
    private final ValidationService validationService;

    public AppService(DatabaseService databaseService, ValidationService validationService) {
        this.databaseService = databaseService;
        this.validationService = validationService;
    }

    public void validateCoachesName(List<String> coaches) {
        try {
            validationService.validateCoachesNum(coaches);
            validationService.validateNameLength(coaches);

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public Coach createCoachInfo(String name, List<String> cantEatMenu) {
        Coach coachInfo;
        try {
            validationService.validateCantEatMenusNum(cantEatMenu);
            coachInfo = new Coach(name.trim(), cantEatMenu);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        return coachInfo;
    }

    public String startRecommend(List<Coach> coaches){
        List<String> categories = createCategories();
        StringBuilder sb = new StringBuilder(Constant.OUTPUT_START);
        sb.append(Constant.OUTPUT_CATEGORIES);
        sb.append(Constant.OUTPUT_CATEGORY).append(createFormat(categories)).append(Constant.SPACE).append(Constant.CLOSING_BLANKET).append(Constant.NEW_LINE);
        for(Coach coachInfo : coaches){
            sb.append(Constant.OPENING_BLANKET).append(Constant.SPACE).append(coachInfo.getName()).append(Constant.SPACE).append(Constant.PIPE).append(Constant.SPACE).append(createRecommendMenu(coachInfo, categories)).append(Constant.SPACE).append(Constant.CLOSING_BLANKET).append(Constant.NEW_LINE);
        }
        sb.append(Constant.OUTPUT_END);
        return sb.toString();
    }

    public List<String> createCategories(){
        List<String> categories = new ArrayList<>();
        int[] typesNum = new int[5];
        while(categories.size() < 5){
            int idx = Randoms.pickNumberInRange(1,5);
            if(typesNum[idx - 1] < 2){
                typesNum[idx - 1]++;
                categories.add(Category.pickCategoryName(idx));
            }
        }
        return categories;
    }

    private String createRecommendMenu(Coach coachInfo, List<String> categories){
        List<String> recommendedMenus = new ArrayList<>();
        for(String category : categories){
            while(true){
                String menuName = Randoms.shuffle(databaseService.readTargetMenusByCategory(category)).get(0).getName();
                if(recommendedMenus.contains(menuName) || coachInfo.getCantEatMenus().contains(menuName)) continue;
                recommendedMenus.add(menuName);
                break;
            }
        }
        return createFormat(recommendedMenus);
    }

    private String createFormat(List<String> values){
        return String.join(" | ", values);
    }

}
