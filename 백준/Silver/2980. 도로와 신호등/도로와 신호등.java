import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int pos = 0;
        int t = 0;
        
        TrafficLight[] lights = new TrafficLight[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            lights[i] = new TrafficLight(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
        }
        int i = 0;
        while (pos < l && i < n) {
            TrafficLight light = lights[i];
            if (pos == light.p) {
                int temp = t % (light.redTime + light.greenTime);
                if (temp < light.redTime) {
                    t += light.redTime - temp;
                }
                i++;
            }
            pos++;
            t++;
        }
        t += l - pos;
        System.out.println(t);
    }

    private static class TrafficLight {
        int p;
        int redTime;
        int greenTime;

        public TrafficLight(int p, int redTime, int greenTime) {
            this.p = p;
            this.redTime = redTime;
            this.greenTime = greenTime;
        }
    }
}

