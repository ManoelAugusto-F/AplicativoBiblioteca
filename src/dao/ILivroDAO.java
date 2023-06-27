package dao;

import app.Livro;

import java.util.List;

public interface ILivroDAO {
    int save(Livro livro);
    int update(Livro livro);
    int remove(Long id);

    List<Livro> findAll();


}
