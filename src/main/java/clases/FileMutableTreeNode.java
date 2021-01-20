/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.File;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Alan Diaz Yañez
 */
public class FileMutableTreeNode extends DefaultMutableTreeNode{
    
    private final String absolutePath;
    
    private final File file;

    public FileMutableTreeNode(String absolutePath) {
        this.absolutePath = absolutePath;
        this.file = new File(absolutePath);
        this.setUserObject(file.getName());
    }
    
    public void openFile(){
        FilesEditorContainer.getInstance().addFileEditor(file);
    }
}
