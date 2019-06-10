package br.upe.Controlador;

import br.upe.Negocio.Formulario;
import br.upe.Repositorio.RepositorioFormulario;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped

public class ControladorFormulario {
    
    private RepositorioFormulario rf= null;
    private Formulario SelectFormulario = null;
   
    
    public Formulario getSelectFormulario(){
        return SelectFormulario;
    }
    
    public void setSelectFormulario(Formulario SelectForulario) {
        this.SelectFormulario = SelectFormulario;
    }
    
    public ControladorFormulario(){
        this.rf = new RepositorioFormulario();
        
    }
    
    public String inserirFormulario(Formulario f){
        
        this.rf.inserir(f);
         
         return "ApresentaFormulario.xhtml";
    }
    
    public String alterarFormulario(Formulario f){
         
         this.rf.alterar(f);
         System.out.println("To antes do retrun");
        return "ApresentaFormulario.xhtml";
        
    }
    public Formulario recuperarFormulario(int id){
        return this.rf.recuperar(id);
    }
    
    public void deletarFormulario(Formulario f){
        this.rf.deletar(f);
        
    }
    
    public List<Formulario> recuperarTodosFormularios(){
        return this.rf.recuperarTodos();
    }
    
}


