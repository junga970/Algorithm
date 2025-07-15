import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] time = br.readLine().split(" ");
        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);

        int cookTime = Integer.parseInt(br.readLine());

        int totalMinutes = hour * 60 + minute + cookTime;
        int resultHour = (totalMinutes / 60) % 24;
        int resultMinute = totalMinutes % 60;

        bw.write(resultHour + " " + resultMinute);
        bw.flush();
        bw.close();
    }
}
