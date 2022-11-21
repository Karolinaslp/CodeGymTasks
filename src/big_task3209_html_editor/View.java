package big_task3209_html_editor;

import big_task3209_html_editor.listeners.FrameListener;
import big_task3209_html_editor.listeners.TabbedPaneChangeListener;
import big_task3209_html_editor.listeners.UndoListener;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {
    private Controller controller;

    private final UndoManager undoManager = new UndoManager();
    private final UndoListener undoListener = new UndoListener(undoManager);

    private final JTabbedPane tabbedPane = new JTabbedPane();
    private final JTextPane htmlTextPane = new JTextPane();
    private final JEditorPane plainTextPane = new JEditorPane();

    public View() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public Controller getController() {
        return controller;
    }

    public UndoListener getUndoListener() {
        return undoListener;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String command = actionEvent.getActionCommand();
        switch (command) {
            case "New" -> controller.createNewDocument();
            case "Open" -> controller.openDocument();
            case "Save" -> controller.saveDocument();
            case "Save as..." -> controller.saveDocumentAs();
            case "Exit" -> controller.exit();
            case "About" -> this.showAbout();
        }
    }

    public void init() {
        initGui();
        addWindowListener(new FrameListener(this));
        setVisible(true);
    }

    public void exit() {
        controller.exit();
    }

    public void initMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        MenuHelper.initFileMenu(this, menuBar);
        MenuHelper.initEditMenu(this, menuBar);
        MenuHelper.initStyleMenu(this, menuBar);
        MenuHelper.initAlignMenu(this, menuBar);
        MenuHelper.initColorMenu(this, menuBar);
        MenuHelper.initFontMenu(this, menuBar);
        MenuHelper.initHelpMenu(this, menuBar);

        getContentPane().add(menuBar, BorderLayout.NORTH);
    }

    public void initEditor() {
        htmlTextPane.setContentType("text/html");
        JScrollPane htmlScrollPane = new JScrollPane(htmlTextPane);
        tabbedPane.addTab("HTML", htmlScrollPane);

        JScrollPane plainScrollPane = new JScrollPane(plainTextPane);
        tabbedPane.addTab("Text", plainScrollPane);

        tabbedPane.setPreferredSize(new Dimension(300, 300));

        tabbedPane.addChangeListener(new TabbedPaneChangeListener(this));

        getContentPane().add(tabbedPane, BorderLayout.CENTER);
    }

    public void undo() {
        try {
            undoManager.undo();
        } catch (CannotUndoException e) {
            ExceptionHandler.log(e);
        }
    }

    public void redo() {
        try {
            undoManager.redo();
        } catch (CannotRedoException e) {
            ExceptionHandler.log(e);
        }
    }


    public void initGui() {
        initMenuBar();
        initEditor();
        pack();
    }

    public void selectedTabChanged() {
        switch (tabbedPane.getSelectedIndex()) {
            case 0 -> controller.setPlainText(plainTextPane.getText());
            case 1 -> plainTextPane.setText(controller.getPlainText());
        }
        resetUndo();
    }

    public void selectHtmlTab() {
        tabbedPane.setSelectedIndex(0);
        resetUndo();
    }

    public void update() {
        HTMLDocument document = controller.getDocument();
        htmlTextPane.setDocument(document);
    }

    public void showAbout() {
        JOptionPane.showMessageDialog(this,"about", "info", JOptionPane.INFORMATION_MESSAGE);
    }

    public boolean canUndo() {
        return undoManager.canUndo();
    }

    public boolean canRedo() {
        return undoManager.canRedo();
    }

    public void resetUndo() {
        undoManager.discardAllEdits();
    }

    public boolean isHtmlTabSelected() {
        return tabbedPane.getSelectedIndex() == 0;
    }
}