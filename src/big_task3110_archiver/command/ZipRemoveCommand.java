package big_task3110_archiver.command;

import big_task3110_archiver.ConsoleHelper;
import big_task3110_archiver.ZipFileManager;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipRemoveCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("Removing a file from an archive.");

        ZipFileManager zipfileManager = getZipFileManager();

        ConsoleHelper.writeMessage("Enter the full path to the file in the archive");
        Path sourcePath = Paths.get(ConsoleHelper.readString());
        zipfileManager.removeFile(sourcePath);

        ConsoleHelper.writeMessage("File removed from archive.");
    }
}
