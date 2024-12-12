package pairmatching.core.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChangeDataType {
    public static Object stringArrayToList;

    public static <T> List<T> arrayToList(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }

    // Integer[] intArray = listToArray(intList, new Integer[0]);
    // String[] stringArray = listToArray(stringList, new String[0]);
    public static <T> T[] listToArray(List<T> list, T[] array) {
        return list.toArray(array);
    }
}
