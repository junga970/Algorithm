import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] t = br.readLine().split(" ");
        int A = Integer.parseInt(t[0]), B = Integer.parseInt(t[1]), C = Integer.parseInt(t[2]);
        
        bw.write((A+B)%C + "\n");
        bw.write(((A%C)+(B%C))%C + "\n");
        bw.write((A*B)%C + "\n");
        bw.write(((A%C)*(B%C))%C + "\n");
        
        bw.flush();
        bw.close();
    }
}
