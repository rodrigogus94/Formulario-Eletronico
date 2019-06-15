/*RedHunter
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upe.Repositorio;

import br.upe.DAO.DaoManagerHiber;
import br.upe.Interface.Interface;
import br.upe.Negocio.Equipe;
import java.util.List;


public class RepositorioEquipe implements Interface<Equipe, String>{

    @Override
    public void inserir(Equipe e) {
        DaoManagerHiber.persist(e);
    }

    @Override
    public void alterar(Equipe e) {
        DaoManagerHiber.update(e);
    }

    @Override
    public Equipe recuperar(int id) {
        return (Equipe)DaoManagerHiber.recover("From Equipe where id=" + id).get(0);
    }

    @Override
    public void deletar(Equipe e) {
       DaoManagerHiber.delete(e);
    }
    

    @Override
    public List<Equipe> recuperarTodos() {
        return DaoManagerHiber.recover("From Equipe");
    }
    
}
