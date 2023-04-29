import java.io.*;

public class Main {

    static StringBuilder log = new StringBuilder();

    public static void main(String[] args) {

        File srcDir = new File("/Users/admin/Games/src");
        if (srcDir.mkdir())
            log.append("Создан каталог - " + srcDir.getAbsolutePath()).append("\n");
        File mainDir = new File("/Users/admin/Games/src/main");
        if (mainDir.mkdir())
            log.append("Создан каталог - " + mainDir.getAbsolutePath()).append("\n");
        File main = new File(mainDir, "Main.java");
        try {
            if (main.createNewFile())
                log.append("Создан файл - " + main.getName()).append("\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        File utils = new File(mainDir, "Utils.java");
        try {
            if (utils.createNewFile())
                log.append("Создан файл - " + utils.getName()).append("\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        File testDir = new File("/Users/admin/Games/src/test");
        if (testDir.mkdir())
            log.append("Создан каталог - " + testDir.getAbsolutePath()).append("\n");
        File resDir = new File("/Users/admin/Games/res");
        if (resDir.mkdir())
            log.append("Создан каталог - " + resDir.getAbsolutePath()).append("\n");
        File drawablesDir = new File("/Users/admin/Games/res/drawables");
        if (drawablesDir.mkdir())
            log.append("Создан каталог - " + drawablesDir.getAbsolutePath()).append("\n");

        File vectorsDir = new File("/Users/admin/Games/res/vectors");
        if (vectorsDir.mkdir())
            log.append("Создан каталог - " + vectorsDir.getAbsolutePath()).append("\n");

        File iconssDir = new File("/Users/admin/Games/res/icons");
        if (iconssDir.mkdir())
            log.append("Создан каталог - " + iconssDir.getAbsolutePath()).append("\n");

        File savegamesDir = new File("/Users/admin/Games/savegames");
        if (savegamesDir.mkdir())
            log.append("Создан каталог - " + savegamesDir.getAbsolutePath()).append("\n");

        File tempDir = new File("/Users/admin/Games/temp");
        if (tempDir.mkdir())
            log.append("Создан каталог - " + tempDir.getAbsolutePath()).append("\n");

        File temp = new File(tempDir, "temp.txt");
        try {
            if (temp.createNewFile())
                log.append("Создан файл - " + temp.getName()).append("\n");

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        try (FileWriter writer = new FileWriter(temp, true)) {
            if (log.isEmpty()) {
                writer.write("Выполненных операций нет");
                writer.append('\n');
            } else writer.write(String.valueOf(log));
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

}