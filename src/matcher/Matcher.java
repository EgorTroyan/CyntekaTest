package matcher;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Matcher {

    public String[] getMatches (String[] data, String[] source){
        List<String> list = new ArrayList<>();
        for (String datum : data) {
            list.add(getMatch(datum, source));
        }
        return list.toArray(new String[0]);
    }

    public String getMatch(String data, String[] source){
        Set<String> matches = new HashSet<>();
        String[] splitData = data.split("\s");
        for (String s : splitData) {
            for (String s1 : source) {
                if(s1.contains(s)){
                    matches.add(data + ":" + s1);
                }
            }
        }
        if(matches.isEmpty()){
            return data + ":?";
        } else if (matches.size() == 1){
            return matches.stream().findFirst().get();
        } else {
            return getBestMatches(matches);
        }
    }

    private String getBestMatches(Set<String> set){
        List<String> list = new ArrayList<>(set);
        int bestIndex = 0;
        int count = 0;
        for (int i = 0; i < list.size(); i++){
            String temp = list.get(i);
            if(countOfMatches(temp) > count){
                bestIndex = i;
                count = countOfMatches(temp);
            }
        }
        return list.get(bestIndex);
    }
    private int countOfMatches(String s){
        int count = 0;
        String[] strings = s.split(":");
        String[] s1 = strings[0].split(" ");
        String[] s2 = strings[1].split(" ");
        for (String item : s1) {
            for (String value : s2) {
                if (item.equals(value)) {
                    count++;
                }
            }

        }
        return count;
    }
}
