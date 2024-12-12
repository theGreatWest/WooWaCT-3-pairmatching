package menu.core.constant;

public enum FileInfo {
    BACKEND("src/main/resources/backend-crew.md", "backend-crew","backend-crew.md"),
    FRONTEND("src/main/resources/frontend-crew.md", "frontend-crew","frontend-crew.md");

    private final String filePath;
    private final String fileName;
    private final String fileNameWithExtension;

    FileInfo(String filePath, String fileName, String fileNameWithExtension) {
        this.filePath = filePath;
        this.fileName = fileName;
        this.fileNameWithExtension = fileNameWithExtension;
    }

    public static String findFilePath(String fileName){
        FileInfo targetObj = findTargetObj(fileName);

        if(targetObj==null) return null;

        return targetObj.filePath;
    }

    public static FileInfo findTargetObj(String fileName){
        if(fileName.equalsIgnoreCase(BACKEND.fileName) || fileName.equalsIgnoreCase(BACKEND.fileNameWithExtension)){
            return BACKEND;
        }

        if(fileName.equalsIgnoreCase(FRONTEND.fileName) || fileName.equalsIgnoreCase(FRONTEND.fileNameWithExtension)){
            return FRONTEND;
        }

        return null;
    }
}
