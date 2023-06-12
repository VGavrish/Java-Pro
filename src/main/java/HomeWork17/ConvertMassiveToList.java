package HomeWork17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertMassiveToList {

    public static <T> List<T> toList(T[] massive) {
        return new ArrayList<>(Arrays.asList(massive));
    }

}
