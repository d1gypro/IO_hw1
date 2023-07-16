import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        StringBuilder log = new StringBuilder();

        File dir1 = new File("D://games/src/main");
        if (dir1.mkdirs())
            log.append("Каталог D://games/src/main создан \n");

        dir1 = new File("D://games/res");
        if (dir1.mkdir())
            log.append("Каталог D://games/res создан \n");

        dir1 = new File("D://games/savegames");
        if (dir1.mkdir())
            log.append("Каталог D://games/savegames создан \n");

        dir1 = new File("D://games/temp");
        if (dir1.mkdir())
            log.append("Каталог D://games/temp создан \n");

        dir1 = new File("D://games/src/test");
        if (dir1.mkdir())
            log.append("Каталог D://games/src/test создан \n");

        File file = new File("D://games/src/main/Main.java");
        try {
            if (file.createNewFile())
                    log.append("Файл Main.java был создан \n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        file = new File("D://games/src/main/Utils.java");
        try {
            if (file.createNewFile())
                log.append("Файл Utils.java был создан \n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        if ((new File("D://games/res/drawables")).mkdir())
            log.append("Каталог D://games/res/drawables создан \n");

        if ((new File("D://games/res/vectors")).mkdir())
            log.append("Каталог D://games/res/vectors создан \n");

        if ((new File("D://games/res/icons")).mkdir())
            log.append("Каталог D://games/res/icons создан \n");

        try {
            if (new File("D://games/temp/temp.txt").createNewFile())
                log.append("Файл temp.txt был создан \n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (FileOutputStream fos = new FileOutputStream("D://games/temp/temp.txt")) {
            byte[] bytes = log.toString().getBytes();
            fos.write(bytes,0, bytes.length);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}