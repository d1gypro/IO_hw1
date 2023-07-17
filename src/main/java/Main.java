import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        StringBuilder log = new StringBuilder();

        List<String> dirList = new ArrayList(Arrays.asList(
                "D://games/src",
                "D://games/src/main",
                "D://games/res",
                "D://games/savegames",
                "D://games/temp",
                "D://games/src/test",
                "D://games/res/drawables",
                "D://games/res/vectors",
                "D://games/res/icons"));

        List<String> fileList = new ArrayList(Arrays.asList(
                "D://games/src/main/Main.java",
                "D://games/src/main/Utils.java",
                "D://games/temp/temp.txt"));

        for (String dir : dirList) {
            MakeDir(dir, log);
        }

        for (String file : fileList) {
            CreateFile(file, log);
        }

        try (FileOutputStream fos = new FileOutputStream("D://games/temp/temp.txt")) {
            byte[] bytes = log.toString().getBytes();
            fos.write(bytes,0, bytes.length);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static boolean MakeDir(String dirPath, StringBuilder log) {
        File dir = new File(dirPath);
        if (dir.mkdir()) {
            log.append("Каталог " + dirPath + " создан \n");
            return true;
        }
        return false;
    }

    public static boolean CreateFile(String pathName, StringBuilder log) {
        File file = new File(pathName);
        try {
            if (file.createNewFile()) {
                log.append("Файл " + pathName + " был создан \n");
                return true;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
