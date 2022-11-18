package big_task3209_html_editor;

import big_task3209_html_editor.listeners.UndoListener;

import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.File;
import java.io.StringReader;

public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }

    public static void main(String[] args) {
        View view = new View();
        final Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }

    public void init() {

    }

    public void exit() {
        System.exit(0);
    }

    public void resetDocument(){
        UndoListener undoListener = view.getUndoListener();
        if (document != null){

            document.removeUndoableEditListener(undoListener);
        }
        document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
        document.addUndoableEditListener(undoListener);
        view.update();
    }

    // This method will write the passed text with HTML tags to document
    public void setPlainText(String text) {
        try {
            resetDocument();
            StringReader reader = new StringReader(text);
            HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
            htmlEditorKit.read(reader, document, 0);
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public HTMLDocument getDocument() {
        return document;
    }
}