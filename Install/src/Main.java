import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void dirCreate(String path) {
        File Dir = new File(path);
        if (Dir.mkdir())
            log.append("Создан каталог - " + Dir.getAbsolutePath()).append("\n");
    }

    public static void fileCreate(String dirPath) {
        File main = new File(dirPath);
        try {
            if (main.createNewFile())
                log.append("Создан файл - " + main.getName()).append("\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void tempWriter(String tempDir) {
        try (FileWriter writer = new FileWriter(tempDir, true)) {
            if (log.isEmpty()) {
                writer.write("Выполненных операций нет");
                writer.append('\n');
            } else writer.write(String.valueOf(log));
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    static StringBuilder log = new StringBuilder();

    public static void main(String[] args) {

        List dirList = new ArrayList<>();
        dirList.add("/Users/admin/Games/src");
        dirList.add("/Users/admin/Games/src/main");
        dirList.add("/Users/admin/Games/src/test");
        dirList.add("/Users/admin/Games/res");
        dirList.add("/Users/admin/Games/res/drawables");
        dirList.add("/Users/admin/Games/res/vectors");
        dirList.add("/Users/admin/Games/res/icons");
        dirList.add("/Users/admin/Games/savegames");
        dirList.add("/Users/admin/Games/temp");

        List fileList = new ArrayList<>();

        fileList.add("/Users/admin/Games/src/main/Main.java");
        fileList.add("/Users/admin/Games/src/main/Utils.java");
        fileList.add("/Users/admin/Games/temp/temp.txt");

        for (int i = 0; i < dirList.size(); i++) {
            dirCreate((String) dirList.get(i));
        }
        for (int i = 0; i < fileList.size(); i++) {
            fileCreate((String) fileList.get(i));
        }
        tempWriter("/Users/admin/Games/temp/temp.txt");

    }

}