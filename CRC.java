import java.io.*;

class CRC {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Generator:");
        String gen = br.readLine();
        System.out.println("Enter Data:");
        String data = br.readLine();
        String code = data;
        while(code.length() < (data.length() + gen.length() - 1))
            code += "0";
        code = data + div(code, gen);
        System.out.println("The transmitted Code Word is: " + code);
        System.out.println("Please enter the received Code Word: ");
        String rec = br.readLine();
        System.out.println("The received code word " + (Integer.parseInt(div(rec, gen)) == 0 ? "contains no errors." : "contains errors."));
    }

    static String div(String num1, String num2) {
        int pointer = num2.length();
        String result = num1.substring(0, pointer);
        String remainder = "";
        for(int i = 0; i < num2.length(); i++)
            remainder += result.charAt(i) == num2.charAt(i) ? "0" : "1";
        
        while(pointer < num1.length()) {
            if(remainder.charAt(0) == '0') {
                remainder = remainder.substring(1) + num1.charAt(pointer);
                pointer++;
            }
            result = remainder;
            remainder = "";
            for(int i = 0; i < num2.length(); i++)
                remainder += result.charAt(i) == num2.charAt(i) ? "0" : "1";
        }
        return remainder.substring(1);
    }
}
