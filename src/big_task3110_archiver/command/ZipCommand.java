package big_task3110_archiver.command;

import big_task3110_archiver.ConsoleHelper;
import big_task3110_archiver.ZipFileManager;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipCommand implements Command {
    @Override
    public void execute() throws Exception {

    }

    public ZipFileManager getZipFileManager() throws Exception {
        ConsoleHelper.writeMessage("Please enter the full path to the archive");
        final String pathName = ConsoleHelper.readString();
        Path path = Paths.get(pathName);

        return new ZipFileManager(path);
    }
}
