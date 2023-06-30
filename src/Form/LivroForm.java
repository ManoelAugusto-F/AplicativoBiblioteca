package Form;

import app.Livro;
import controler.LivroControler;
import net.miginfocom.swing.MigLayout;
import table.LivroCellRenderer;
import table.LivroTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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


        panelButtons.add(btnNew, "gapleft 90");
        panelButtons.add(btnCancel);
        panelButtons.add(btnSave, "gap unrelated");
        panelButtons.add(btnUpdate, "gap unrelated");
        panelButtons.add(btnRemove);

        panelTable = new JPanel(new MigLayout());
        panelTable.setBorder(BorderFactory.createTitledBorder("Lista de Livros"));
        panelTable.setBounds(5, 150, 480, 240);

        table = new JTable();

        scrollPane = new JScrollPane(table);

        panelTable.add(scrollPane);

        refreshTable();
        enableFields(false);


        add(panelAdd);
        add(panelButtons);
        add(panelTable);
        setMinimumSize(new Dimension(500, 420));
        setVisible(true);

        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onSaveLivro();
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancelar();
            }
        });

        btnNew.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onNovoLivro();
            }
        });

        btnRemove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onRemoverLivro();
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onAlterarLivro();
            }
        });


    }



    private void onRemoverLivro() {
        int rowIndex = table.getSelectedRow();

        if (rowIndex == -1) {
            JOptionPane.showMessageDialog(this, "Selecione o livro a ser removido!");
            return;
        }

        Livro livro = new LivroTableModel(livroList).get(rowIndex);

        int confirm = JOptionPane.showConfirmDialog(this, "Confirmar exclusão?", "Excluir Livro", JOptionPane.YES_NO_OPTION);

        if (confirm != 0) {
            return;
        }

        int result = new LivroControler().excluirLivro(livro.getId());

        if (result == 1) {
            JOptionPane.showMessageDialog(this, "Valor removido com sucesso!");
            refreshTable();
        } else {
            JOptionPane.showMessageDialog(this, "Tente novamente!");
        }
    }

    private void onAlterarLivro() {
        int rowIndex = table.getSelectedRow();

        if (rowIndex == -1) {
            JOptionPane.showMessageDialog(this, "Selecione o livro a ser alterado!");
            return;
        }

        Livro livro = new LivroTableModel(livroList).get(rowIndex);

        idLivro = livro.getId();

        textFieldEditora.setText(livro.getEditora());
        textFieldTitulo.setText(livro.getTitulo());
        textFieldIsbn.setText(livro.getIsbn());

        enableFields(true);
    }

    private void onNovoLivro() {
        enableFields(true);
    }

    private void onSaveLivro() {
        Livro livro = new Livro();

        if (textFieldEditora.getText().length() > 0 && textFieldTitulo.getText().length() > 0 && textFieldIsbn.getText().length() > 0) {
            livro.setEditora(textFieldEditora.getText());
            livro.setTitulo(textFieldTitulo.getText());
            livro.setIsbn(textFieldIsbn.getText());
        } else {
            JOptionPane.showMessageDialog(this, "Todos os campos são obrigatórios!");
            return;
        }

        int result = 0;
        if (idLivro == null) {
            result = new LivroControler().addLivro(livro);
        } else {
            livro.setId(idLivro);
            result = new LivroControler().alterarLivro(livro);
            idLivro = null;
        }

        if (result == 1) {
            JOptionPane.showMessageDialog(this, "Valor inserido com sucesso!");
            enableFields(false);
            onCancelar();
            refreshTable();
        } else {
            JOptionPane.showMessageDialog(this, "Tente novamente!");
        }
    }

    private void onCancelar() {
        textFieldEditora.setText("");
        textFieldTitulo.setText("");
        textFieldIsbn.setText("");
        enableFields(false);
    }

    private void enableFields(boolean b) {
        textFieldEditora.setEnabled(b);
        textFieldTitulo.setEnabled(b);
        textFieldIsbn.setEnabled(b);
    }

    private void refreshTable() {
        livroList = new LivroControler().findLivros();
        if (livroList != null) {
            table.setModel(new LivroTableModel(livroList));
            table.setDefaultRenderer(Object.class, new LivroCellRenderer());
        }
    }
}