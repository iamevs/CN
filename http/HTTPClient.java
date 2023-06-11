import java.awt.image.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.*;
import javax.imageio.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class HTTPClient {

  public static void main(String args[]) throws Exception {
    Socket soc;
    BufferedImage img = null;
    soc = new Socket("localhost", 4000);
    System.out.println("Client is running. ");
    try {
      System.out.println("Reading image from disk. ");
      img = ImageIO.read(new File("digital_image_processing.jpg"));
      ByteArrayOutputStream baos = new ByteArrayOutputStream();

      ImageIO.write(img, "jpg", baos);
      baos.flush();
      byte[] bytes = baos.toByteArray();
      baos.close();
      System.out.println("Sending image to server. ");

      OutputStream out = soc.getOutputStream();
      DataOutputStream dos = new DataOutputStream(out);
      dos.writeInt(bytes.length);
      dos.write(bytes, 0, bytes.length);
      System.out.println("Image sent to server. ");
      dos.close();
      out.close();
    } catch (Exception e) {
      System.out.println("Exception: " + e.getMessage());
      soc.close();
    }
    soc.close();
  }
}
