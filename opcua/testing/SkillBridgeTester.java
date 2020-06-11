import java.io.*;
import java.net.*;

class SkillBridgeTester {
    public static void main(String argv[]) throws Exception {
        String host = "localhost";
        int port = 4000;

        String skillName = "TesterSkill";
        String skillType = "Basic";

        Socket clientSocket = new Socket(host, port);
        DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String end = "\r\n";
        (new Thread(new Runnable() {
            public void run() {
                try {
                    while(true)
                    System.out.println("Response: " + in.readLine());
                } catch (Exception e) {
                    System.out.println("Response failed");
                }
            }
        })).start();

        out.writeBytes(skillName + ";INIT;" + skillType + end); 
        out.writeBytes(skillName + ";UPDATE;locked;executingtolocked" + end); 

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Press enter to exit");
		br.readLine();
        clientSocket.close();
    }
}