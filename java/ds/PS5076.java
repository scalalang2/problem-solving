import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){ 
            String text = sc.nextLine();
            if(text.equals("#")) break;

            Stack<String> stack = new Stack();
            try {
            while(text != "") {
                int openTagSt = text.indexOf("<");
                int closingTagSt = text.indexOf("</");
                if((openTagSt < closingTagSt || closingTagSt == -1) && openTagSt != -1) {
                    int openTagEd = text.indexOf(">");
                    int openTagBlank = text.indexOf(" ", openTagSt);

                    int instantClosing = text.indexOf("/>");
                    if(instantClosing != -1 && (instantClosing < text.indexOf("<", openTagSt + 1) || text.indexOf("<", openTagSt + 1) == -1)) {
                        text = text.substring(instantClosing+2, text.length());
                    } else {
                        int ed = openTagBlank < openTagEd ? openTagBlank : openTagEd;
                        String tagName = text.substring(openTagSt + 1, ed);

                        text = text.substring(openTagEd+1, text.length());
                        stack.push(tagName);
                    }
                } else if(closingTagSt != -1) {
                    int ed = text.indexOf(">");
                    String tagName = text.substring(closingTagSt + 2, ed);

                    text = text.substring(ed+1, text.length());
                    if(stack.peek().equals(tagName)) stack.pop();
                } else {
                    text = "";
                }
            }

                if(stack.isEmpty()) System.out.println("legal");
                else System.out.println("illegal");
            } catch(EmptyStackException e) {
                System.out.println("illegal");
            }
        }
    }
}