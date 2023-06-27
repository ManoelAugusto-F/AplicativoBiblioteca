package dao;

import app.Livro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO implements ILivroDAO {

    private static final String SQL_INSERT = "insert into livros (EDITORA, TITULO,ISBN) VALUES (?,?,?)";
    private static final String SQL_UPDATE = "update LIVROS set EDITORA = ?, TITULO = ?, ISBN = ? where ID = ?";
    private static final String SQL_REMOVE = "delete from LIVROS where ID = ?";
    private static final String SQL_FIND_ALL = "select * from LIVROS";

    @Override
    public int save(Livro livro) {
        Connection connection = dao.DBConnect.getConnection();
        PreparedStatement statement = null;
        int result = 0;
        try {
            statement = connection.prepareStatement(SQL_INSERT);
            statement.setString(1, livro.getEditora());
            statement.setString(2, livro.getTitulo());
            statement.setString(3, livro.getIsbn());
            result = statement.executeUpdate();
        } catch (SQLException e) {
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            } finally {
                dao.DBConnect.close(connection, statement, null);
            }
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(Livro livro) {
        Connection connection = dao.DBConnect.getConnection();
        PreparedStatement statement = null;
        int result = 0;
        try {
            statement = connection.prepareStatement(SQL_UPDATE);
            statement.setString(1, livro.getEditora());
            statement.setString(2, livro.getTitulo());
            statement.setString(3, livro.getIsbn());
            statement.setLong(4, livro.getId());
            result = statement.executeUpdate();
        } catch (SQLException e) {
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            } finally {
                dao.DBConnect.close(connection, statement, null);
            }
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int remove(Long id) {
        Connection connection = dao.DBConnect.getConnection();
        PreparedStatement statement = null;
        int result = 0;
        try {
            statement = connection.prepareStatement(SQL_REMOVE);
            statement.setLong(1, id);
            result = statement.executeUpdate();
        } catch (SQLException e) {
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            } finally {
                dao.DBConnect.close(connection, statement, null);
            }
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Livro> findAll() {
        Connection connection = dao.DBConnect.getConnection();
        PreparedStatement statement = null;
        List<Livro> livros = new ArrayList<>();
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(SQL_FIND_ALL);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Livro livro = new Livro();
                livro.setId(resultSet.getLong("ID"));
                livro.setEditora(resultSet.getString("EDITORA"));
                livro.setTitulo(resultSet.getString("TITULO"));
                livro.setIsbn(resultSet.getString("ISBN"));

                livros.add(livro);
            }
        } catch (SQLException e) {
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            } finally {
                dao.DBConnect.close(connection, statement, resultSet);
            }
            e.printStackTrace();
        }
        return livros;

    }
}
