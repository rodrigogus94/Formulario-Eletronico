/*RedHunter
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.upe.Controlador;




import br.upe.Negocio.Usuario;
import br.upe.Repositorio.RepositorioUsuario;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.swing.JOptionPane;


@ManagedBean(name = "ControladorUsuario")
@SessionScoped
public class ControladorUsuario {
    
    private RepositorioUsuario ru= null;
    private Usuario SelectUsuario = null;

    public Usuario getSelectUsuario() {
        return SelectUsuario;
    }

    public void setSelectUsuario(Usuario SelectUsuario) {
        this.SelectUsuario = SelectUsuario;
    }
    
    public ControladorUsuario(){
        this.ru = new RepositorioUsuario();
        
    }

    public String inserirUsuario(Usuario u){
        
        this.ru.inserir(u);
         
         return "ApresentaUsuario.xhtml";
    }
     public String alterarUsuario(Usuario u){
         
         this.ru.alterar(u);
         System.out.println("To antes do retrun");
        return "ApresentaUsuario.xhtml";
        
    }
   
    public Usuario recuperarUsuario(int id){
        return this.ru.recuperar(id);
    }
    
    public void deletarUsuario(Usuario u){
        this.ru.deletar(u);
        
    }
    
    public List<Usuario> recuperarTodosUsuarios(){
        return this.ru.recuperarTodos();
    }
   
    
  
}
