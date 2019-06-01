package br.upe.Repositorio;


import br.upe.Interface.Interface;
import br.upe.Negocio.Usuario;
import br.upe.DAO.DaoManagerHiber;
import java.util.List;

public class RepositorioUsuario implements Interface<Usuario, String>{

    

    @Override
    public void inserir(Usuario t) {
        DaoManagerHiber.persist(t);
    }

    @Override
    public void alterar(Usuario t) {
        DaoManagerHiber.update(t);
    }
    

    @Override
    public Usuario recuperar(int id) {
        return (Usuario)DaoManagerHiber.recover("from Usuario where id ="+ id).get(0);
    }

    @Override
    public void deletar(Usuario t) {
       br.upe.DAO.DaoManagerHiber.delete(t);
   
}
    @Override
    public List<Usuario> recuperarTodos() {
        return br.upe.DAO.DaoManagerHiber.recover("from Usuario");
    }
   
}
