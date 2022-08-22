package big_task3110_archiver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class Archiver {
    public static void main(String[] args) throws Exception {
        System.out.println("Please, enter the full path to the archive:");
        String archiveFileName;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        archiveFileName = reader.readLine();
        final ZipFileManager zipFileManager = new ZipFileManager(Paths.get(archiveFileName));

        System.out.println("Please, enter path to the file to be zipped:");
        String pathToBeZipped = reader.readLine();
        zipFileManager.createZip(Paths.get(pathToBeZipped));
    }
}
