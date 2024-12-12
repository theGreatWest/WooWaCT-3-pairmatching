package pairmatching.service;

import pairmatching.core.constant.Constant;
import pairmatching.core.constant.ExceptionMsg;
import pairmatching.core.util.ChangeDataType;

import java.util.List;

public class ValidationService {
    public boolean validateRequest(String request){
        return !request.matches("[123Q]");
    }

    public List<String> validateInfo(String info){
        String[] infos = info.split(Constant.COMMA);
        if(infos.length!=3) return null;
        for(int i=0;i<infos.length;i++){
            if(infos[i].matches(Constant.REGEX_ALPHA_NUMERIC_X)) return null;
            infos[i] = infos[i].trim();
        }

        return ChangeDataType.arrayToList(infos);
    }
}
