package menu.core.constant;

public enum Category {
    JAPANESE("일식", 1),
    KOREAN("한식", 2),
    CHINESE("중식", 3),
    ASIAN("아시안", 4),
    WESTERN("양식", 5);

    private final String name;
    private final int index;

    Category(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public static String pickCategoryName(int idx){
        if(idx==1) return JAPANESE.name;
        if(idx==2) return KOREAN.name;
        if(idx==3) return CHINESE.name;
        if(idx==4) return ASIAN.name;
        if(idx==5) return WESTERN.name;
        return null;
    }

    public static int pickCategoryIdx(String category){
        if(category.equalsIgnoreCase(JAPANESE.name)) return 1;
        if(category.equalsIgnoreCase(KOREAN.name)) return 2;
        if(category.equalsIgnoreCase(CHINESE.name)) return 3;
        if(category.equalsIgnoreCase(ASIAN.name)) return 4;
        if(category.equalsIgnoreCase(WESTERN.name)) return 5;
        return 0;
    }
}
