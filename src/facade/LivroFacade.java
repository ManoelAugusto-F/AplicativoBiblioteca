package facade;

import app.Livro;
import dao.ILivroDAO;
import dao.LivroDAO;

import java.util.List;

public class LivroFacade {
    private ILivroDAO dao;

    public LivroFacade() {
        this.dao = new LivroDAO();
    }

    public int save (Livro livro){
        return dao.save(livro);
    }
    public int update(Livro livro){
        return dao.update(livro);
    }
    public int remove(Long id){
        return dao.remove(id);
    }
    public List<Livro> findAll(){
        return dao.findAll();
    }
}
