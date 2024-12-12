package pairmatching.core.constant;

public enum Level {
    LEVEL1("레벨1", 0),
    LEVEL2("레벨2", 1),
    LEVEL3("레벨3", 2),
    LEVEL4("레벨4", 3),
    LEVEL5("레벨5", 4);

    private final String name;
    private final int idx;

    Level(String name, int idx) {
        this.name = name;
        this.idx = idx;
    }

    public int getIdx(){
        return idx;
    }

    public String getName(){
        return name;
    }

    public static int findIdx(String name){
        if(name.equalsIgnoreCase(LEVEL1.getName())) return LEVEL1.getIdx();
        if(name.equalsIgnoreCase(LEVEL2.getName())) return LEVEL2.getIdx();
        if(name.equalsIgnoreCase(LEVEL3.getName())) return LEVEL3.getIdx();
        if(name.equalsIgnoreCase(LEVEL4.getName())) return LEVEL4.getIdx();
        if(name.equalsIgnoreCase(LEVEL5.getName())) return LEVEL5.getIdx();
        return -1;
    }
}
