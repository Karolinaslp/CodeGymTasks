package big_task3110_archiver;


import big_task3110_archiver.exception.NoSuchZipFileException;
import big_task3110_archiver.exception.PathNotFoundException;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipFileManager {
    // Full path to the zip file
    private final Path zipFile;

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception {
        //Check whether the directory where the archive will be created exists
        //If necessary, create it
        Path zipDirectory = zipFile.getParent();
        if (Files.notExists(zipDirectory)) {
            Files.createDirectories(zipDirectory);
        }

        //Create zip stream
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile))) {
            if (Files.isDirectory(source)) {
                // If we're archiving a directory, then we need to get the list of files it contains
                FileManager fileManager = new FileManager(source);
                List<Path> fileNames = fileManager.getFileList();

                //Add each file to the archive
                for (Path fileName : fileNames) {
                    addNewZipEntry(zipOutputStream, source, fileName);
                }
            } else if (Files.isRegularFile(source)) {

                //If we're archiving an individual file, then we need to get its directory and name
                addNewZipEntry(zipOutputStream, source.getParent(), source.getFileName());
            } else {

                //If source is not a directory or file, then throw an exception
                throw new PathNotFoundException();
            }
        }
    }

    private void addNewZipEntry(ZipOutputStream zipOutputStream, Path filePath, Path fileName) throws Exception {
        Path fullPath = filePath.resolve(fileName);
        try (InputStream inputStream = Files.newInputStream(fullPath)) {
            ZipEntry entry = new ZipEntry(fileName.toString());

            zipOutputStream.putNextEntry(entry);

            copyData(inputStream, zipOutputStream);

            zipOutputStream.closeEntry();
        }
    }

    private void copyData(InputStream in, OutputStream out) throws Exception {
        byte[] buffer = new byte[8 * 1024];
        int len;
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
    }

    public List<FileProperties> getFileList() throws Exception {
        //Check whether the zip file exists
        if (!Files.isRegularFile(zipFile)) {
            throw new NoSuchZipFileException();
        }

        List<FileProperties> files = new ArrayList<>();

        try (ZipInputStream zipInputStream = new ZipInputStream(Files.newInputStream(zipFile))) {
            ZipEntry zipEntry = zipInputStream.getNextEntry();

            while (zipEntry != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                copyData(zipInputStream, byteArrayOutputStream);

                FileProperties file = new FileProperties(
                        zipEntry.getName(),
                        zipEntry.getSize(),
                        zipEntry.getCompressedSize(),
                        zipEntry.getMethod()
                );
                files.add(file);
                zipEntry = zipInputStream.getNextEntry();
            }
        }
        return files;
    }

    public void extractAll(Path outputFolder) throws Exception {
        //check whether the zip file exists
        if (!Files.isRegularFile(zipFile)) {
            throw new NoSuchZipFileException();
        }
        try (ZipInputStream zipInputStream = new ZipInputStream(Files.newInputStream(zipFile))) {
            //Create the output directory if it doesn't exist
            if (Files.notExists(outputFolder)) {
                Files.createDirectories(outputFolder);
            }

            //Go through the contents of the zip stream (file)
            ZipEntry zipEntry = zipInputStream.getNextEntry();

            while (zipEntry != null) {
                String fileName = zipEntry.getName();
                Path fileFullName = outputFolder.resolve(fileName);

                //Create the necessary directories
                Path parent = fileFullName.getParent();
                if (Files.notExists(parent)) {
                    Files.createDirectories(parent);
                }

                try (OutputStream outputStream = Files.newOutputStream(fileFullName)) {
                    copyData(zipInputStream, outputStream);
                }
                zipEntry = zipInputStream.getNextEntry();
            }
        }
    }
}

