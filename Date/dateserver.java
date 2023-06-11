import java.io.*;
import java.net.*;
import java.util.*;

class dateserver {

  public static void main(String args[]) throws IOException {
    ServerSocket ss = new ServerSocket(8020);
    Socket s = ss.accept();
    PrintStream ps = new PrintStream(s.getOutputStream());
    Date d = new Date();
    ps.println(d);
    DataInputStream dis = new DataInputStream(s.getInputStream());
    String inet = dis.readLine();
    System.out.println("THE CLIENT SYSTEM ADDRESS IS:" + inet);
    ps.close();
  }
}
