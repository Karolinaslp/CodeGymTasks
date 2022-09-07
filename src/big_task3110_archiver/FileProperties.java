package big_task3110_archiver;

public class FileProperties {
    //The file name
    private final String name;
    //The file size in bytes
    private final long size;
    //The size after compression in bytes
    private final long compressedSize;
    //The compression method
    private final int compressionMethod;

    public FileProperties(String name, long size, long compressedSize, int compressionMethod) {
        this.name = name;
        this.size = size;
        this.compressedSize = compressedSize;
        this.compressionMethod = compressionMethod;
    }

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    public long getCompressedSize() {
        return compressedSize;
    }

    public int getCompressionMethod() {
        return compressionMethod;
    }

    public long getCompressionRatio() {
        //Calculate the compression ratio
        return 100 - ((compressedSize * 100) / size);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name);
        if (size > 0) {
            builder.append("\t");
            builder.append(size / 1024);
            builder.append(" KB (");
            builder.append(compressedSize / 1024);
            builder.append(" KB) compression: ");
            builder.append(getCompressionRatio());
            builder.append("%");
        }
        return builder.toString();
    }
}

