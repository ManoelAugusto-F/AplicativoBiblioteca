package Form;

import app.Livro;
import controler.LivroControler;
import net.miginfocom.swing.MigLayout;
import table.LivroTableModel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class LivroForm extends JFrame {

    private JLabel labelEditora, labelTitulo, labelIsbn;
    private JTextField textFieldEditora, textFieldTitulo, textFieldIsbn;
    private JPanel panelAdd, panelTable, panelButtons;
    private JButton btnNew, btnSave, btnUpdate, btnRemove, btnCancel;
    private JTable table;
    private JScrollPane scrollPane;

    private List<Livro> livroList;
    private Long idLivro;

    public LivroForm() throws HeadlessException {
        super("Cadastro de Livros");
        setContentPane(new JPanel());
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelAdd = new JPanel(new MigLayout());
        panelAdd.setBorder(BorderFactory.createTitledBorder("Adicionar Livros"));
        panelAdd.setBounds(5, 0, 480, 100);

        labelEditora = new JLabel("Editora");
        labelTitulo = new JLabel("Titulo");
        labelIsbn = new JLabel("ISBN");

        textFieldEditora = new JTextField(50);
        textFieldTitulo = new JTextField(50);
        textFieldIsbn = new JTextField(15);

        panelAdd.add(labelEditora);
        panelAdd.add(textFieldEditora, "span, growx");

        panelAdd.add(labelTitulo);
        panelAdd.add(textFieldTitulo, "span, growx");

        panelAdd.add(labelIsbn);
        panelAdd.add(textFieldIsbn, "growx");

        panelButtons = new JPanel(new MigLayout());
        panelButtons.setBorder(BorderFactory.createEtchedBorder());
        panelButtons.setBounds(5, 105, 480, 40);

        ClassLoader loader = getClass().getClassLoader();
        btnNew = new JButton(new ImageIcon(loader.getResource("img/new.png")));
        btnSave = new JButton(new ImageIcon(loader.getResource("img/save.png")));
        btnCancel = new JButton(new ImageIcon(loader.getResource("img/cancel.png")));
        btnRemove = new JButton(new ImageIcon(loader.getResource("img/trash.png")));
        btnUpdate = new JButton(new ImageIcon(loader.getResource("img/edit.png")));


        panelButtons.add(btnNew,"gapleft 90");
        panelButtons.add(btnCancel);
        panelButtons.add(btnSave, "gap unrelated");
        panelButtons.add(btnUpdate, "gap unrelated");
        panelButtons.add(btnRemove);

        panelTable = new JPanel(new MigLayout());
        panelTable.setBorder(BorderFactory.createTitledBorder("Lista de Livros"));
        panelTable.setBounds(5,150,480,240);

        table = new JTable();

        scrollPane =  new JScrollPane(table);

        panelTable.add(scrollPane);

       // refreshTable();


        add(panelAdd);
        add(panelButtons);
        add(panelTable);
        setMinimumSize(new Dimension(500, 420));
        setVisible(true);

    }

    private void refreshTable(){
        livroList = new LivroControler().findLivros();
        if (livroList != null){
            table.setModel(new LivroTableModel(livroList));
        }


    }
}
