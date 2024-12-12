package pairmatching.service;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.core.constant.Constant;
import pairmatching.core.constant.Course;
import pairmatching.core.constant.ExceptionMsg;
import pairmatching.core.constant.Level;
import pairmatching.core.util.ReadFile;
import pairmatching.model.MatchingHistory;
import pairmatching.model.MatchingInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppService {
    private final ValidationService validationService;
    private MatchingHistory matchingHistory = new MatchingHistory();

    public AppService(ValidationService validationService) {
        this.validationService = validationService;
    }

    public String validateRequest(String request) {
        if (validationService.validateRequest(request)) {
            throw new IllegalArgumentException(ExceptionMsg.INVALID_ETC.fullErrorMsg());
        }
        return request;
    }

    public List<String> validationInfo(String info) {
        List<String> validatedInfo = validationService.validateInfo(info);

        if (validatedInfo == null) {
            throw new IllegalArgumentException(ExceptionMsg.INVALID_ETC.fullErrorMsg());
        }
        return validatedInfo;
    }

    public boolean validationAnswer(String answer){
        if(answer.equalsIgnoreCase("네")) return true;
        if(answer.equalsIgnoreCase("아니오")) return false;
        throw new IllegalArgumentException(ExceptionMsg.INVALID_ETC.fullErrorMsg());
    }

    public MatchingInfo pairMatching(List<String> infos) {
        if(!matchingHistory.getHistory(infos.get(Constant.COURSE_NAME_IDX), infos.get(Constant.COURSE_LEVEL_IDX)).isEmpty()) return null;

        List<String> crews = ReadFile.readFile(Course.findFileName(infos.get(Constant.COURSE_NAME_IDX)));
        if (crews == null) throw new IllegalArgumentException(ExceptionMsg.INVALID_ETC.fullErrorMsg());
        crews = Randoms.shuffle(crews);
        List<List<String>> pairMatchingResult = matching(crews);

        return createMatchingInfo(infos, pairMatchingResult);
    }

    public MatchingInfo createMatchingInfo(List<String> infos, List<List<String>> pairMatchingResult) {
        MatchingInfo matchingInfo = new MatchingInfo(infos.get(Constant.COURSE_NAME_IDX), infos.get(Constant.COURSE_LEVEL_IDX), infos.get(Constant.COURSE_MISSION_IDX), pairMatchingResult);
        List<MatchingInfo> prevMatchingResult = matchingHistory.getHistory(infos.get(Constant.COURSE_NAME_IDX), infos.get(Constant.COURSE_LEVEL_IDX));
        for(MatchingInfo prevHistory: prevMatchingResult){
            if(checkSamePair(prevHistory, matchingInfo)) return null;
        }
        matchingHistory.setHistory(matchingInfo);
        return matchingInfo;
    }

    public boolean checkSamePair(MatchingInfo prevMatchingResult, MatchingInfo currentMatching) {
        for (List<String> result : prevMatchingResult.getPairCrew()) {
            for(List<String> currentResult : currentMatching.getPairCrew()){
                if(checkSameValue(result, currentResult)) return true;
            }
        }
        return false;
    }

    public List<List<String>> matching(List<String> crews) {
        if (crews.size() % 2 == 0) return evenMatching(crews);
        return oddMatching(crews);
    }

    private boolean checkSameValue(List<String> pair1, List<String> pair2) {
        int sameCnt = 0;
        for (String name : pair1) {
            if (pair2.contains(name)) sameCnt++;
        }
        return sameCnt == 2 || sameCnt == 3;
    }

    private List<List<String>> evenMatching(List<String> crews) {
        List<List<String>> pairMatchingResult = new ArrayList<>();
        for (int i = 0; i < crews.size(); i += 2) {
            pairMatchingResult.add(Arrays.asList(crews.get(i), crews.get(i + 1)));
        }
        return pairMatchingResult;
    }

    private List<List<String>> oddMatching(List<String> crews) {
        List<List<String>> pairMatchingResult = new ArrayList<>();
        for (int i = 0; i < crews.size(); i += 2) {
            List<String> pair = new ArrayList<>(Arrays.asList(crews.get(i), crews.get(i + 1)));
            if (i == crews.size() - 3) {
                pair.add(crews.get(i + 2));
                break;
            }
            pairMatchingResult.add(pair);
        }
        return pairMatchingResult;
    }
}
