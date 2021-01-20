package clases;

import java.awt.Component;
import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

/**
 *
 * @author Alan Diaz Yañez
 */
public class FilesEditorContainer extends JTabbedPane {

    private static FilesEditorContainer instance;
    private FileEditor currentEditor;
    private String strSearch;

    public static FilesEditorContainer getInstance() {
        if (FilesEditorContainer.instance == null) {
            FilesEditorContainer.instance = new FilesEditorContainer();
        }
        return FilesEditorContainer.instance;
    }

    private FilesEditorContainer() {
        super();
        initComponents();
    }

    private void initComponents() {
        addFileEditor();
    }

    public void addFileEditor() {
        FileEditor newFileEditor = new FileEditor();
        newFileEditor.setName("Sin titulo");
        addTab("Sin titulo", newFileEditor);
        repaint();
    }

    public void addFileEditor(File file) {
        FileEditor newFileEditor = new FileEditor(file);
        addTab(file.getName(), null, newFileEditor, file.getPath());
        repaint();
    }

    public void save() {
        currentEditor = (FileEditor) getSelectedComponent();
        currentEditor.save();
        updateTextTab();
    }

    public void saveAs() {
        currentEditor = (FileEditor) getSelectedComponent();
        currentEditor.saveAs();
        updateTextTab();
    }

    public void saveAll() {
        Component[] filesEditorList = getComponents();
        for (Component iteratorEditor : filesEditorList) {
            FileEditor iteratorFileEditor = (FileEditor) iteratorEditor;
            iteratorFileEditor.save();
        }
        updateAllTextTabs();
    }
    
    public void cleanAllStringSearches(){
        Component[] filesEditorList = getComponents();
        for (Component iteratorEditor : filesEditorList) {
            FileEditor iteratorFileEditor = (FileEditor) iteratorEditor;
            iteratorFileEditor.cleanSearch();
        }
    }
    
    public void printSelectedFile(){
        currentEditor = (FileEditor) getSelectedComponent();
        currentEditor.printFileByPrinter();
    }

    public void closeCurrentFileEditor() {
        currentEditor = (FileEditor) getSelectedComponent();
        if (currentEditor.isSaved) {
            remove(getSelectedComponent());
        } else {
            int saveFileBeforeClose = JOptionPane.showConfirmDialog(null, "El archivo que intenta cerrar tiene modificaciones sin guardar\n¿Desea guardar los cambios?");
            switch (saveFileBeforeClose) {
                case 0:
                    //Si
                    currentEditor.save();
                    break;
                case 1:
                    //No
                    break;
                case 2:
                    //Cancelar
                    return;
                default:
                    break;
            }
            remove(getSelectedComponent());
        }
    }

    public void selectAllCurrentText() {
        currentEditor = (FileEditor) getSelectedComponent();
        currentEditor.selectAllText();
    }
    
    public void deleteSelectedText(){
        currentEditor = (FileEditor) getSelectedComponent();
        currentEditor.deleteTextSelected();
    }

    public String searchStringInDocument(String strSearch) {
        this.strSearch = strSearch;
        return getCurrentFileEditor().searchStringInDocument(strSearch);
    }

    public String searchNextStringInDocument() {
        String message;
        if(!getCurrentFileEditor().isSearched){
            message = getCurrentFileEditor().searchStringInDocument(strSearch);
        }
        else{
            message = getCurrentFileEditor().searchNextStringInDocument();
        }
        return message;
    }

    public String searchPrevStringInDocument() {
        String message;
        if(!getCurrentFileEditor().isSearched){
            message = getCurrentFileEditor().searchStringInDocument(strSearch);
        }
        else{
            message = getCurrentFileEditor().searchPrevStringInDocument();
        }
        return message;
    }

    public String replaceCurrentStringInDocument(String strReplace) {
        if(!getCurrentFileEditor().isSearched){
            getCurrentFileEditor().searchStringInDocument(strSearch);
        }
        return getCurrentFileEditor().replaceStringInDocument(strReplace);
    }

    public FileEditor getCurrentFileEditor() {
        currentEditor = (FileEditor) getSelectedComponent();
        return currentEditor;
    }

    private File getCurrentFile() {
        currentEditor = (FileEditor) getSelectedComponent();
        return currentEditor.getFile();
    }

    private void updateTextTab() {
        currentEditor = (FileEditor) getSelectedComponent();
        int currentIndex = getSelectedIndex();
        setTitleAt(currentIndex, currentEditor.getFileName());
        setToolTipTextAt(currentIndex, currentEditor.getFilePath());
    }

    private void updateTextTab(int index) {
        FileEditor fileEditor = (FileEditor) getComponentAt(index);
        setTitleAt(index, fileEditor.getFileName());
        setToolTipTextAt(index, fileEditor.getFilePath());

    }

    private void updateAllTextTabs() {
        for (int i = 0; i < getTabCount(); i++) {
            updateTextTab(i);
        }
    }
}
