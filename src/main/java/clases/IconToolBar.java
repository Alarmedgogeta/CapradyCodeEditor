/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

/**
 *
 * @author Alan Diaz Yañez
 */
public class IconToolBar extends JToolBar {

    private static IconToolBar instance;

    public static IconToolBar getInstance() {
        if (instance == null) {
            instance = new IconToolBar();
        }
        return instance;
    }

    private IconToolBar() {
        //setBackground(Color.red);
        //setPreferredSize(new Dimension(200, 40));
        initComponents();
    }

    private void initComponents() {
        setOrientation(JToolBar.VERTICAL);
        ImageIcon newFileIcon = Helper.getNewFileIcon();
        JButton btnNewFile = new JButton(newFileIcon);
        btnNewFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FilesEditorContainer.getInstance().addFileEditor();
            }
        });
        btnNewFile.setToolTipText("Abrir nuevo archivo");
        add(btnNewFile);
        ImageIcon openFileIcon = Helper.getOpenFileIcon();
        JButton btnOpenFile = new JButton(openFileIcon);
        btnOpenFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = Helper.searchFile();
                FilesEditorContainer.getInstance().addFileEditor(file);
            }
        });
        btnOpenFile.setToolTipText("Abrir archivo existente");
        add(btnOpenFile);
        ImageIcon openFolderIcon = Helper.getOpenFolderIcon();
        JButton btnOpenFolder = new JButton(openFolderIcon);
        btnOpenFolder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProjectTreeViewer.getInstance().searchProject();
            }
        });
        btnOpenFolder.setToolTipText("Abrir carpeta existente");
        add(btnOpenFolder);
        ImageIcon saveIcon = Helper.getSaveIcon();
        JButton btnSave = new JButton(saveIcon);
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FilesEditorContainer.getInstance().save();
            }
        });
        btnSave.setToolTipText("Guardar archivo");
        add(btnSave);
        ImageIcon saveAsIcon = Helper.getSaveAsIcon();
        JButton btnSaveAs = new JButton(saveAsIcon);
        btnSaveAs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FilesEditorContainer.getInstance().saveAs();
            }
        });
        btnSaveAs.setToolTipText("Guardar como");
        add(btnSaveAs);
        ImageIcon saveAllIcon = Helper.getSaveAllIcon();
        JButton btnSaveAll = new JButton(saveAllIcon);
        btnSaveAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FilesEditorContainer.getInstance().saveAll();
            }
        });
        btnSaveAll.setToolTipText("Guardar todo");
        add(btnSaveAll);
        ImageIcon printIcon = Helper.getPrintIcon();
        JButton btnprint = new JButton(printIcon);
        btnprint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FilesEditorContainer.getInstance().printSelectedFile();
            }
        });
        btnprint.setToolTipText("Imprimir");
        add(btnprint);
        ImageIcon copyIcon = Helper.getCopyIcon();
        JButton btnCopy = new JButton(copyIcon);
        btnCopy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Helper.copySelected(e);
            }
        });
        btnCopy.setToolTipText("Copiar texto seleccionado");
        add(btnCopy);
        ImageIcon pasteIcon = Helper.getPasteIcon();
        JButton btnPaste = new JButton(pasteIcon);
        btnPaste.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Helper.pasteSelected(e);
            }
        });
        btnPaste.setToolTipText("Pegar texto en portapapeles");
        add(btnPaste);
        ImageIcon cutIcon = Helper.getCutIcon();
        JButton btnCut = new JButton(cutIcon);
        btnCut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Helper.cutSelected(e);
            }
        });
        btnCut.setToolTipText("Cortar texto seleccionado");
        add(btnCut);
        ImageIcon runLexicIcon = Helper.getRunLexicIcon();
        JButton btnRunLexic = new JButton(runLexicIcon);
        btnRunLexic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Helper.runLexicAnalizer();
            }
        });
        btnRunLexic.setToolTipText("Copiar texto seleccionado");
        add(btnRunLexic);
        //setMinimumSize(getSize());
        System.out.println(getPreferredSize());
    }

}
