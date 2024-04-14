package pack;

import java.util.Scanner;

public class VowelDisplay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine().toLowerCase(); // Convert input to lowercase for case-insensitive comparison
        scanner.close();

        Thread thread = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < input.length(); i++) {
                    char ch = input.charAt(i);
                    if (isVowel(ch)) {
                        System.out.println(ch);
                        try {
                            Thread.sleep(3000); // Sleep for 3 seconds
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        thread.start();
    }

    public static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
