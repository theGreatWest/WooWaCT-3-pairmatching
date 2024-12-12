package pairmatching.model;

import java.util.ArrayList;
import java.util.List;

public class MatchingHistory {
    private List<MatchingInfo> matchingInfos = new ArrayList<>();

    public List<MatchingInfo> getHistory(String course, String level){
        List<MatchingInfo> result = new ArrayList<>();
        for(MatchingInfo matchingInfo : matchingInfos){
            if(matchingInfo.getCourse().equalsIgnoreCase(course) && matchingInfo.getLevel().equalsIgnoreCase(level)){
                result.add(matchingInfo);
            }
        }
        return result;
    }

    public void setHistory(MatchingInfo matchingInfo){
        matchingInfos.add(matchingInfo);
    }
}
