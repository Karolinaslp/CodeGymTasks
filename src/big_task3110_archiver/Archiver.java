package big_task3110_archiver;

import big_task3110_archiver.command.ExitCommand;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class Archiver {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please, enter the full path to the archive file:");
        final ZipFileManager zipFileManager = new ZipFileManager(Paths.get(reader.readLine()));

        System.out.println("Please, enter path to the file to be zipped:");
        zipFileManager.createZip(Paths.get(reader.readLine()));

        final ExitCommand exitCommand = new ExitCommand();
        exitCommand.execute();
    }
}