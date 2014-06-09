package be.ordina.workshop.java7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DiamondOperator {

    public static void main(String[] args) {
        // Java 6
        Map<String, Map<String, Integer>> map = new HashMap<String, Map<String, Integer>>();
        List<String> strings = new ArrayList<String>();
        Set<Integer> set = new HashSet<>();

        //Java 7
        Map<String, Map<String, Integer>> map2 = new HashMap<>();
        List<String> strings2 = new ArrayList<>();
        Set<Integer> set2 = new HashSet<>();

    }
}
