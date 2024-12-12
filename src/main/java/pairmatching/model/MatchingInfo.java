package pairmatching.model;

import pairmatching.core.constant.Constant;
import pairmatching.core.constant.Course;
import pairmatching.core.constant.Level;

import java.util.List;

public class MatchingInfo {
    private String course;
    private String level;
    private String mission;
    private List<List<String>> pairCrew;

    public MatchingInfo(String course, String level, String mission, List<List<String>> pairCrew) {
        this.course = course;
        this.level = level;
        this.mission = mission;
        this.pairCrew = pairCrew;
    }

    public String getCourse() {
        return course;
    }

    public String getLevel() {
        return level;
    }

    public List<List<String>> getPairCrew() {
        return pairCrew;
    }

    public String announcePairResult(){
        StringBuilder sb = new StringBuilder(Constant.ANNOUNCE_MATCHING_RESULT);
        for(List<String> pair : pairCrew){
            sb.append(String.join(" : ", pair)).append(Constant.NEW_LINE);
        }
        return sb.toString();
    }
}
