package pairmatching.core.constant;

public enum Course {
    BACKEND("백엔드", "backend-crew"),
    FRONTEND("프론트엔드", "frontend-crew.md");

    private final String name;
    private final String fileName;

    Course(String name, String fileName) {
        this.name = name;
        this.fileName = fileName;
    }

    public static String findFileName(String courseName){
        if(courseName.equalsIgnoreCase(BACKEND.name)){
            return BACKEND.fileName;
        }

        if(courseName.equalsIgnoreCase(FRONTEND.name)){
            return FRONTEND.fileName;
        }

        return null;
    }
}
