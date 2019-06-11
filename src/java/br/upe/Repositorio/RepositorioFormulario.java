//RedHunter
package br.upe.Repositorio;

import br.upe.DAO.DaoManagerHiber;
import br.upe.Interface.Interface;
import br.upe.Negocio.Formulario;
import java.util.List;

public class RepositorioFormulario implements Interface <Formulario, String>{

    @Override
    public void inserir(Formulario f) {
       DaoManagerHiber.persist(f);
    }

    @Override
    public void alterar(Formulario f) {
        DaoManagerHiber.update(f);
    }

    @Override
    public Formulario recuperar(int id) {
        return (Formulario)DaoManagerHiber.recover("from Formulario where id= "+id).get(0);
    }

    @Override
    public void deletar(Formulario f) {
        DaoManagerHiber.delete(f);
    }

    @Override
    public List<Formulario> recuperarTodos() {
         return DaoManagerHiber.recover("from Formulario");
    }
    
}
