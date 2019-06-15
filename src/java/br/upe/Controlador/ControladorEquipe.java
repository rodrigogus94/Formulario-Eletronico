/*RedHunter
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upe.Controlador;

import br.upe.Negocio.Equipe;
import br.upe.Repositorio.RepositorioEquipe;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean (name = "ControladorEquipe")
@SessionScoped
public class ControladorEquipe {
    
    private RepositorioEquipe re = null;
    private Equipe SelectEquipe = null;

    public ControladorEquipe() {
     this.re = new RepositorioEquipe();
    }

    public Equipe getSelectEquipe() {
        return SelectEquipe;
    }

    public void setSelectEquipe(Equipe SelectEquipe) {
        this.SelectEquipe = SelectEquipe;
    }
    
     
    public String inserirEquipe(Equipe e) {
               
        this.re.inserir(e);
        return "ApresentaEquipe.xhtml";
    }
    
    public String addUsuario(Equipe e){
        
         
         ((ControladorUsuario)((HttpSession)FacesContext.getCurrentInstance().
                 getExternalContext().getSession(true)).getAttribute("ControladorUsuario")).
                 getSelectUsuario().getEquipes().add(e);
         
         ((ControladorUsuario)((HttpSession)FacesContext.getCurrentInstance().
                 getExternalContext().getSession(true)).getAttribute("ControladorUsuario")).
                 alterarUsuario(((ControladorUsuario)((HttpSession)FacesContext.getCurrentInstance().
                 getExternalContext().getSession(true)).getAttribute("ControladorUsuario")).
                 getSelectUsuario());
         
        this.re.inserir(e);
        return null;
    }

    public String alterarEquipe(Equipe e) {

        this.re.alterar(e);
        System.out.println("To antes do retren");
        return "ApresentaEquipe.xhtml";

    }

    public Equipe recuperarEquipe(int id) {
        return this.re.recuperar(id);
    }

    public void deletarEquipe(Equipe e) {
        this.re.deletar(e);

    }

    public List<Equipe> recuperarTodosEquipes() {
        return this.re.recuperarTodos();
    }
    
    
    
}
