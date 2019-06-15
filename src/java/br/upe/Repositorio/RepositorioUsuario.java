package br.upe.Repositorio;


import br.upe.DAO.DaoManagerHiber;
import br.upe.Interface.Interface;
import br.upe.Negocio.Usuario;
import java.util.List;

public class RepositorioUsuario implements Interface<Usuario, String>{

    

    @Override
    public void inserir(Usuario u) {
        DaoManagerHiber.persist(u);
    }

    @Override
    public void alterar(Usuario u) {
        DaoManagerHiber.update(u);
    }
    

    @Override
    public Usuario recuperar(int id) {
        return (Usuario)DaoManagerHiber.recover("from Usuario where id ="+ id).get(0);
    }

    @Override
    public void deletar(Usuario u) {
       DaoManagerHiber.delete(u);
   
}

    @Override
    public List<Usuario> recuperarTodos() {
        return DaoManagerHiber.recover("from Usuario");
    }
    
    
    public Usuario recuperarPorLogin(String login, String senha){
        List<Usuario> list = DaoManagerHiber.recover("From Usuario where login= '"+ login +"' and senha= '"+ senha+"'");
        if(list.isEmpty()){
            return  null;
        }else{
            return (Usuario) list.get(0);
        }
    }
}
