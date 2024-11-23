package xyz.tcbuildmc.common.liteconfig.util;

import java.io.*;

public final class FileUtils {
    public static String read(File file) {
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {

            StringBuilder sb = new StringBuilder();

            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line)
                        .append(FileUtils.getLineSeparator());
            }

            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file.", e);
        }
    }

    public static void write(File file, String content) {
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }

            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException("Failed to create file.", e);
            }
        }

        try (FileWriter fw = new FileWriter(file);
             BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write("");
            bw.write(content);
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getLineSeparator() {
        return System.lineSeparator();
    }
}
