package pack;

import java.io.*;
import java.util.concurrent.*;

public class Slip14a {
    private static final String SEARCH_STRING = "your_search_string"; // Change to your search string
    private static final int THREAD_POOL_SIZE = 10;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        File currentDir = new File(".");
        File[] files = currentDir.listFiles((dir, name) -> name.endsWith(".txt"));

        if (files != null) {
            for (File file : files) {
                executor.execute(new SearchTask(file));
            }
        }

        executor.shutdown();
    }

    static class SearchTask implements Runnable {
        private File file;

        public SearchTask(File file) {
            this.file = file;
        }

        @Override
        public void run() {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                int lineNumber = 0;
                while ((line = reader.readLine()) != null) {
                    lineNumber++;
                    if (line.contains(SEARCH_STRING)) {
                        System.out.println("Found in file: " + file.getName() + ", Line: " + lineNumber);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
