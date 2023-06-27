package table;

import app.Livro;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class LivroTableModel extends AbstractTableModel {

    private static final int COL_ID = 0;
    private static final int COL_EDITORA = 1;
    private static final int COL_TITULO = 2;
    private static final int COL_ISBN = 3;

    private List<Livro> valores;

    public LivroTableModel(List<Livro> valores) {
        this.valores = valores;
    }

    @Override
    public int getRowCount() {
        return valores.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Livro livro = valores.get(rowIndex);
        if (columnIndex == COL_ID) {
            return livro.getId();
        } else if (columnIndex == COL_EDITORA) {
            return livro.getEditora();
        } else if (columnIndex == COL_TITULO) {
            return livro.getTitulo();
        } else if (columnIndex == COL_ISBN) {
            return livro.getIsbn();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        String coluna = "";
        switch (column){
            case COL_ID :
                coluna = "Código";
                break;
            case COL_EDITORA:
                coluna ="Editora";
            case COL_TITULO:
                coluna = "Titulo";
            case COL_ISBN:
                coluna = "ISBN";
            default:
                throw new IllegalArgumentException("Coluna Invalida!");
        }
        return coluna;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == COL_ID){
            return Long.class;
        }else if (columnIndex == COL_EDITORA){
            return String.class;
        }else if (columnIndex == COL_TITULO) {
            return String.class;
        }else if (columnIndex == COL_ISBN) {
            return String.class;
        }
        return null;
    }
    public Livro get(int row){
        return valores.get(row);
    }
}
