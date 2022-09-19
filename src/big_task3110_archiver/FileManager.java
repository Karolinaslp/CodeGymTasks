package big_task3110_archiver;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private final Path rootPath;
    private final List<Path> fileList;

    public FileManager(Path rootPath) throws IOException {
        this.rootPath = rootPath;
        this.fileList = new ArrayList<>();
        collectFileList(rootPath);
    }

    public List<Path> getFileList() {
        return fileList;
    }

    private void collectFileList(Path path) throws IOException {
        // Only add files
        if (Files.isRegularFile(path)) {
            fileList.add(rootPath.relativize(path));
        }

        // Add the contents of a directory
        if (Files.isDirectory(path)) {
            // Recursively go through all the contents of the directory
            // To avoid writing code to call close on the DirectoryStream,
            // I will wrap the "new DirectoryStream" call in a try-with-resources
            try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {
                for (Path p : directoryStream) {
                    collectFileList(p);
                }
            }
        }
    }
}
