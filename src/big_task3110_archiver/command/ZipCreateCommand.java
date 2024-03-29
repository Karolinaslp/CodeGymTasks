package big_task3110_archiver.command;

import big_task3110_archiver.ConsoleHelper;
import big_task3110_archiver.ZipFileManager;
import big_task3110_archiver.exception.PathNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipCreateCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Creating an archive");

            ZipFileManager zipFileManager = getZipFileManager();

            ConsoleHelper.writeMessage("Please enter the full path to the file or directory to be archived:");
            String fileName = ConsoleHelper.readString();
            Path path = Paths.get(fileName);
            zipFileManager.createZip(path);

            ConsoleHelper.writeMessage("Archive created");
        } catch (PathNotFoundException e) {
            ConsoleHelper.writeMessage("You didn't correctly enter a file name or directory.");
        }
    }
}
