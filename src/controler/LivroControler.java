package controler;

import app.Livro;
import facade.LivroFacade;

import java.util.List;

public class LivroControler {
    private LivroFacade facade;

    public LivroControler() {
        this.facade = new LivroFacade();
    }
    public int addLivro(Livro livro){
        return facade.save(livro);
    }

    public int alterarLivro(Livro livro){
        return facade.update(livro);

    }
    public int excluirLivro(Long id){
        return facade.remove(id);
    }

    public List<Livro> findLivros(){
        return facade.findAll();
    }
}
