import java.util.List;
import java.util.Arrays;
import java.io.*;
import java.lang.*;
import java.util.*;

public class Student_aj9183 implements Student {
    private class School implements Comparable<School> {
        public School(int i, double s, double q) {
          index = i;
          synergy = s;
          quality = q;
        }

        public School(int i, double q) {
          index = i;
          quality = q;
        }
    
        private int index;
        private double quality;
        private double synergy;
    
        public int compareTo(School n) { // smaller pairs are higher quality
          int ret = Double.compare(n.quality, quality);
          return (ret == 0) ? (Integer.compare(index, n.index)) : ret;
        }

        
    }
    

    
    public int[] getApplications(
        int N,
        double S,
        double T,
        double W,
        double aptitude,
        List<Double> schools,
        List<Double> synergies) {

        // Creates a list of preferences for each school
        School[] topSynergy = new School[schools.size()];
        School[] preferences = new School[25];

        // Ranking System of Aptitude and Quality of Schools
        for (int i = 0; i != topSynergy.length; ++i) {
          double rank = - (Math.abs((aptitude * T) - (schools.get(i) * S)));
          topSynergy[i] = new School(i, synergies.get(i), rank);
        }
        Arrays.sort(topSynergy);

        // Creates a list of schools and sorts them based on synergies
        for (int i = 0; i != 25; ++i) {
          preferences[i] = new School(i, topSynergy[i].synergy);
        }
        Arrays.sort(preferences);

        // Sorts the preferences and outputs a list of 10
        int[] ret = new int[10];
        for (int i = 0; i != 10; ++i) {
          ret[i] = preferences[i].index;
        }
        return ret;
    }
}
