package menu.core.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChangeDataType {
    public static List<String> stringArrayToList(String[] array){
        List<String> result = new ArrayList<>();
        for(String value : array){
            result.add(value.trim());
        }
        return result;
    }
}
