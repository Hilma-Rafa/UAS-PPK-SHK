package com.project.shkproject.Utils;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {

    public static <T> List<T> toList(ArrayList<T> arrayList) {
        return arrayList;
    }
    public static <T> ArrayList<T> ToArrayList(List<T> list) {
        return new ArrayList<>(list);
    }

}
