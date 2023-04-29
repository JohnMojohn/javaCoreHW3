import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    static GameProgress gamer1 = new GameProgress(94, 10, 2, 254.32);
    static GameProgress gamer2 = new GameProgress(43, 5, 1, 023.11);
    static GameProgress gamer3 = new GameProgress(87, 7, 5, 754.88);
    static List saveToZip = new ArrayList<>();

    public static void saveGame(String filePass, GameProgress savedGames) {
        try (FileOutputStream fos = new FileOutputStream(filePass);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(savedGames);
            saveToZip.add(filePass);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void zipFiles(String zipName, List saveToZip) {
            try (ZipOutputStream zout = new ZipOutputStream(new
                    FileOutputStream(zipName));
                 FileInputStream fis = new FileInputStream("/Users/admin/Games/savegames/save1.dat")) {
                for (int i = 0; i < saveToZip.size(); i++) {
                    ZipEntry entry = new ZipEntry((String) saveToZip.get(i));
                    zout.putNextEntry(entry);
                    // считываем содержимое файла в массив byte
                    byte[] buffer = new byte[fis.available()];
                    fis.read(buffer);
                    // добавляем содержимое к архиву
                    zout.write(buffer);
                    // закрываем текущую запись для новой записи
                    zout.closeEntry();}
 //               }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
    }

    public static void main(String[] args) {
        saveGame("/Users/admin/Games/savegames/save1.dat", gamer1);
        saveGame("/Users/admin/Games/savegames/save2.dat", gamer2);
        saveGame("/Users/admin/Games/savegames/save3.dat", gamer3);
        zipFiles("/Users/admin/Games/savegames/zip.zip", saveToZip);
        System.out.println(saveToZip);
//        System.out.println(saveToZip.get(1));


    }
}
