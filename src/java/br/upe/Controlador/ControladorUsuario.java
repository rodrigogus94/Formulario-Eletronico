/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.upe.Controlador;


import br.upe.Negocio.Usuario;
import br.upe.Repositorio.RepositorioUsuario;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rodrigo-Casa
 */
@ManagedBean(name = "controladorUsuario")
@SessionScoped
public class ControladorUsuario {
    
    private RepositorioUsuario ru= null;
    private Usuario selectUsuario = null;

    public Usuario getSelectUsuario() {
        return selectUsuario;
    }

    public void setSelectTecnico(Usuario selectUsuario) {
        this.selectUsuario = selectUsuario;
    }
    
    
   
    public ControladorUsuario(){
        this.ru = new RepositorioUsuario();
        
    }

      
    public String inserirUsuario(Usuario t){
        
        this.ru.inserir(t);
         
         return "ApresentaUsuario.xhtml";
    }
     public String alterarUsuario(Usuario t){
         
         this.ru.alterar(t);
        
        return "ApresentaUsuario.xhtml";
    }
   
    public Usuario recuperarUsuario(int id){
        return this.ru.recuperar(id);
    }
    
    public void deletarUsuario(Usuario t){
        this.ru.deletar(t);
        
    }
    
    public List<Usuario> recuperarTodosUsuario(){
        return this.ru.recuperarTodos();
    }
  
    
    
  
}
