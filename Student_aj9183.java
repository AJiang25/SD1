import java.util.List;
import java.util.Arrays;
import java.io.*;
import java.lang.*;
import java.util.*;
/* 
class SortbySyn implements Comparator<School> {
 
  // Method
  // Sorting in ascending order of name
  public int compare(int a, int b, List<Double> synergies)
  {

      return (int) (synergies.get(a) - synergies.get(b));
  }
}
*/
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

        // Ranking System of Aptitude and Quality of Schools
        School[] preferences = new School[schools.size()];

        // Calculates a score based on quality, aptitude, & synergy for each school
        for (int i = 0; i != schools.size(); ++i) {
          double score = (synergies.get(i)) - (  Math.abs((schools.get(i) * S) - (aptitude * T)));
          preferences[i] = new School(i, score);
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
