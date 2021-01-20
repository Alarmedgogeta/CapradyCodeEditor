package clases;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 *
 * @author Alan Diaz Yañez
 */
public class ToolMenuBar extends JMenuBar {

    private static ToolMenuBar instance;

    private JMenu[] menus;

    public static ToolMenuBar getInstance() {
        if (ToolMenuBar.instance == null) {
            ToolMenuBar.instance = new ToolMenuBar();
        }
        return ToolMenuBar.instance;
    }

    private ToolMenuBar() {
        super();
        this.menus = new JMenu[4];
        initComponents();
    }

    public ToolMenuBar(String[] options) {
        super();
        JMenu option;
        for (String strOption : options) {
            option = new JMenu(strOption);
            add(option);
        }
    }

    private void initComponents() {
        this.menus[0] = initFileMenu();
        this.menus[1] = initEditMenu();
        // this.menus[2] = initViewMenu();
        this.menus[2] = initRunMenu();
        this.menus[3] = initHelpMenu();
        initMenuBar();
        setMinimumSize(getSize());
    }

    private JMenu initMenu(String strMenu, MenuItemInfo[] arrayStrItems) {
        JMenu menu = new JMenu(strMenu);
        JMenuItem menuItem;
        for (MenuItemInfo item : arrayStrItems) {
            menuItem = new JMenuItem(item.name);
            menuItem.setToolTipText(item.toolTipText);
            menuItem.addActionListener(new MenusManager(item.name));
            if (item.key != null) {
                menuItem.setAccelerator(item.key);
                menuItem.setActionCommand(item.actionComand);
            }
            if (item.name.equals("Sintactico") || item.name.equals("Semantico")) {
                menuItem.setEnabled(false);
            }
            if (item.icon != null) {
                menuItem.setIcon(item.icon);
            }
            menu.add(menuItem);
            if (item.hasSeparator) {
                menu.addSeparator();
            }
        }
        return menu;
    }

    private void initMenuBar() {
        for (JMenu menu : this.menus) {
            this.add(menu);
        }
    }

    private JMenu initFileMenu() {
        String menuTittle = "Archivo";

        MenuItemInfo newFile = new MenuItemInfo("Nuevo Archivo", "Crear un nuevo archivo", 
                KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK), "cmd_new_file", Helper.getNewFileIcon());
        MenuItemInfo openFile = new MenuItemInfo("Abrir Archivo", "Abrir un archivo ya existente", 
                KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK), "cmd_open_file", Helper.getOpenFileIcon());
        MenuItemInfo closeFile = new MenuItemInfo("Cerrar Archivo", "Cerrar archivo en edicion", 
                KeyStroke.getKeyStroke(KeyEvent.VK_F4, KeyEvent.CTRL_DOWN_MASK), "cmd_close_file", true);
        MenuItemInfo openProject = new MenuItemInfo("Abrir Proyecto", "Abrir directorio de un proyecto", Helper.getOpenFolderIcon());
        MenuItemInfo save = new MenuItemInfo("Guardar", "Guardar archivo en edicion",
                KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK), "cmd_save", Helper.getSaveIcon());
        MenuItemInfo saveAs = new MenuItemInfo("Guardar como", "Crear un nuevo archivo a partir del archivo en edicion",
                KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK | KeyEvent.SHIFT_DOWN_MASK), "cmd_save_as", Helper.getSaveAsIcon());
        MenuItemInfo saveAll = new MenuItemInfo("Guardar todo", "Guardar todos los archivos en edicion",
                KeyStroke.getKeyStroke(KeyEvent.VK_K | KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK), "cmd_save_all", Helper.getSaveAllIcon(), true);
        MenuItemInfo print = new MenuItemInfo("Imprimir", "Imprimir el archivo actual",
                KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK | KeyEvent.ALT_DOWN_MASK), "cmd_print", Helper.getPrintIcon());
        MenuItemInfo exit = new MenuItemInfo("Salir", "Finalizar la ejecucion del sistema");

        MenuItemInfo[] strItems = {newFile, openFile, openProject, closeFile, save, saveAs, saveAll, print, exit};

        return initMenu(menuTittle, strItems);
    }

    private JMenu initEditMenu() {
        String menuTittle = "Editar";

        MenuItemInfo undo = new MenuItemInfo("Deshacer", "De ser podible deshace la ultima accion hecha", 
                KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK), "cmd_undo");
        MenuItemInfo redo = new MenuItemInfo("Rehacer", "De ser podible vuelve a hacer la ultima accion hecha", 
                KeyStroke.getKeyStroke(KeyEvent.VK_Y, KeyEvent.CTRL_DOWN_MASK), "cmd_redo", true);
        MenuItemInfo copy = new MenuItemInfo("Copiar", "Copiar el texto seleccionado", 
                KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK), "cmd_copy", Helper.getCopyIcon());
        MenuItemInfo paste = new MenuItemInfo("Pegar", "Pegar el texto en la ubicacion actual del cursor", 
                KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK), "cmd_paste", Helper.getPasteIcon());
        MenuItemInfo cut = new MenuItemInfo("Cortar", "Cortar el texto seleccionado", 
                KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK), "cmd_cut", Helper.getCutIcon());
        MenuItemInfo delete = new MenuItemInfo("Borrar", "Borrar el texto seleccionado");
        MenuItemInfo selectAll = new MenuItemInfo("Seleccionar todo", "Seleccionar todo el texto del archivo actual en edicion", 
                KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK), "cmd_select_all", true);
        MenuItemInfo search = new MenuItemInfo("Buscar", "Buscar un texto en el contenido del archivo", 
                KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_DOWN_MASK), "cmd_search");
        MenuItemInfo replace = new MenuItemInfo("Remplazar", "Remplazar un texto en el contenido del archivo", KeyStroke.getKeyStroke(KeyEvent.VK_H, KeyEvent.CTRL_DOWN_MASK), "cmd_replace");

        MenuItemInfo[] strItems = {undo, redo, copy, paste, cut, delete, selectAll, search, replace};

        return initMenu(menuTittle, strItems);
    }

    private JMenu initViewMenu() {
        String menuTittle = "Vista";

        MenuItemInfo font = new MenuItemInfo("Fuente", "Seleccionar la fuente del editor de texto");
        MenuItemInfo size = new MenuItemInfo("Tamaño", "Seleccionar el tamaño de letra del editor de texto");
        MenuItemInfo style = new MenuItemInfo("Estilo", "Seleccionar el estilo de letra del editor de texto");

        MenuItemInfo[] strItems = {font, size, style};

        return initMenu(menuTittle, strItems);
    }

    private JMenu initRunMenu() {
        String menuTittle = "Ejecutar";

        MenuItemInfo run = new MenuItemInfo("Analizar Código", "Ejecutar todos los analizis del archivo", Helper.getRunSyntaxIcon());
        MenuItemInfo lexic = new MenuItemInfo("Lexico", "Ejecutar el analizis lexico del archivo", 
                KeyStroke.getKeyStroke(KeyEvent.VK_F5, KeyEvent.CTRL_DOWN_MASK), "cmd_run_lexic", Helper.getRunLexicIcon());
        MenuItemInfo syntax = new MenuItemInfo("Sintactico", "Ejecutar el analizis sintactico del archivo", Helper.getRunSyntaxIcon());
        MenuItemInfo semantic = new MenuItemInfo("Semantico", "Ejecutar el analizis sintactico del archivo");

        MenuItemInfo[] strItems = {run, lexic, syntax};

        return initMenu(menuTittle, strItems);
    }

    private JMenu initHelpMenu() {
        String menuTittle = "Ayuda";

        MenuItemInfo help = new MenuItemInfo("Apoyo", "Despliega consejos generales del sistema");
        MenuItemInfo support = new MenuItemInfo("Acerca de", "Visitar documentacion del sistema");

        MenuItemInfo[] strItems = {help, support};

        return initMenu(menuTittle, strItems);
    }

    private class MenuItemInfo {

        public String name;
        public String toolTipText;
        public KeyStroke key;
        public String actionComand;
        public boolean hasSeparator = false;
        public ImageIcon icon = null;

        public MenuItemInfo(String name, String toolTipText) {
            this.name = name;
            this.toolTipText = toolTipText;
        }

        public MenuItemInfo(String name, String toolTipText, ImageIcon icon) {
            this.name = name;
            this.toolTipText = toolTipText;
            this.icon = icon;
        }

        public MenuItemInfo(String name, String toolTipText, KeyStroke key, String action) {
            this.name = name;
            this.toolTipText = toolTipText;
            this.key = key;
            this.actionComand = action;
        }

        public MenuItemInfo(String name, String toolTipText, KeyStroke key, String action, boolean hasSeparator) {
            this.name = name;
            this.toolTipText = toolTipText;
            this.key = key;
            this.actionComand = action;
            this.hasSeparator = hasSeparator;
        }

        public MenuItemInfo(String name, String toolTipText, KeyStroke key, String action, ImageIcon icon) {
            this.name = name;
            this.toolTipText = toolTipText;
            this.key = key;
            this.actionComand = action;
            this.icon = icon;
        }

        public MenuItemInfo(String name, String toolTipText, KeyStroke key, String action, ImageIcon icon, boolean hasSeparator) {
            this.name = name;
            this.toolTipText = toolTipText;
            this.key = key;
            this.actionComand = action;
            this.icon = icon;
            this.hasSeparator = hasSeparator;
        }

    }

    private class MenusManager implements ActionListener {

        private final String type;

        public MenusManager(String type) {
            this.type = type;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (type) {
                case "Nuevo Archivo":
                    FilesEditorContainer.getInstance().addFileEditor();
                    break;
                case "Abrir Archivo":
                    File file = Helper.searchFile();
                    FilesEditorContainer.getInstance().addFileEditor(file);
                    break;
                case "Cerrar Archivo":
                    FilesEditorContainer.getInstance().closeCurrentFileEditor();
                    break;
                case "Abrir Proyecto":
                    ProjectTreeViewer.getInstance().searchProject();
                    break;
                case "Guardar":
                    FilesEditorContainer.getInstance().save();
                    break;
                case "Guardar como":
                    FilesEditorContainer.getInstance().saveAs();
                    break;
                case "Guardar todo":
                    FilesEditorContainer.getInstance().saveAll();
                    break;
                case "Imprimir":
                    FilesEditorContainer.getInstance().printSelectedFile();
                    break;
                case "Salir":
                    System.exit(0);
                    break;
                case "Deshacer":
                    Helper.undoAction(e);
                    break;
                case "Rehacer":
                    Helper.redoAction(e);
                    break;
                case "Copiar":
                    Helper.copySelected(e);
                    break;
                case "Pegar":
                    Helper.pasteSelected(e);
                    break;
                case "Cortar":
                    Helper.cutSelected(e);
                    break;
                case "Borrar":
                    FilesEditorContainer.getInstance().deleteSelectedText();
                    break;
                case "Seleccionar todo":
                    FilesEditorContainer.getInstance().selectAllCurrentText();
                    break;
                case "Buscar":
                    SearchAndReplacePane.getInstance().selectSearchAndReplace();
                    break;
                case "Remplazar":
                    SearchAndReplacePane.getInstance().selectSearchAndReplace();
                    break;
                case "Analizar Código":
                    Helper.runDebbuger();
                    break;
                case "Lexico":
                    Helper.runLexicAnalizer();
                    break;
                case "Sintactico":
                    Helper.runDebbuger();
                    break;
                case "Apoyo":
                    Helper.openSupportWebpage();
                    break;
                case "Acerca de":
                    Helper.showAbout();
                    break;
                default:
            }
            //throw new UnsupportedOperationException("Not supported yet.");
        }

    }
}
