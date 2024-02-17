import java.util.List;
import java.util.Arrays;

public class Student_aj9183 implements Student {
    private class School implements Comparable<School> {
        public School(int i, double s, double q) {
          index = i;
          synergy = s;
          quality = q;
        }
    
        private int index;
        private double synergy;
        private double quality;
    
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
        School[] synergy = new School[schools.size()];
        School[] preferences = new School[25];

        // sorts the schools based on synergies
        for (int i = 0; i != schools.size(); ++i) {
          synergy[i] = new School(i, synergies.get(i), schools.get(i));
        }
        Arrays.sort(synergy);

        // Creates a list of schools & sorts them based on rank
        for (int i = 0; i != 25; ++i) {
          double newQuality = - (Math.abs((aptitude * T) - (synergy[i].quality * S)));
          preferences[i] = new School(i, synergy[i].synergy, newQuality);
        }
        Arrays.sort(preferences);

        // Sorts the preferences and outputs a list of 10
        int[] ret = new int[10];
        for (int i = 0; i != 10; ++i) {
          ret[i] = synergy[i].index;
        }
        return ret;
    }
}
