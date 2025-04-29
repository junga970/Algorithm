import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
        int cnt = Integer.parseInt(br.readLine());
        String[] strScores = br.readLine().split(" ");
        Integer[] intScores = Arrays.stream(strScores)
            .map((s) -> Integer.parseInt(s))
            .sorted((a, b) -> b - a)
            .toArray(Integer[]::new);
        
        double max = intScores[0];
        double sum = 0;
        for(Integer score : intScores) {
            double tmp = (double) (score.intValue());
            sum += (tmp / max * 100);
        }
        
        System.out.println(sum / cnt);
    }
}