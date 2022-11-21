package big_task3209_html_editor;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class HTMLFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {
        final String name = f.getName().toLowerCase();
        return f.isDirectory() ||name.endsWith(".html") || name.endsWith(".htm");
    }

    @Override
    public String getDescription() {
        return "HTML and HTM files";
    }
}
