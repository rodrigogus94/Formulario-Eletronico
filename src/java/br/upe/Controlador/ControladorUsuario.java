/*RedHunter
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
import org.apache.commons.codec.digest.DigestUtils;


@ManagedBean(name = "ControladorUsuario")
@SessionScoped
public class ControladorUsuario {

    private RepositorioUsuario ru = null;
    private Usuario SelectUsuario = null;
    private Usuario login;
    private Usuario senha;

    public ControladorUsuario() {
        this.ru = new RepositorioUsuario();

    }

    public Usuario getSelectUsuario() {
        return SelectUsuario;
    }

    public void setSelectUsuario(Usuario SelectUsuario) {
        this.SelectUsuario = SelectUsuario;
    }

    public Usuario getLogin() {
        return login;
    }

    public void setLogin(Usuario login) {
        this.login = login;
    }

    public Usuario getSenha() {
        return senha;
    }

    public void setSenha(Usuario senha) {
        this.senha = senha;
    }
    
    
    
    public String inserirUsuario(Usuario u) {
        
        u.setSenha(DigestUtils.md5Hex(DigestUtils.md2Hex(u.getSenha())));
        this.ru.inserir(u);
        return "ApresentaUsuario.xhtml";
    }

    public String alterarUsuario(Usuario u) {

        this.ru.alterar(u);
        System.out.println("To antes do retrun");
        return "ApresentaUsuario.xhtml";

    }

    public Usuario recuperarUsuario(int id) {
        return this.ru.recuperar(id);
    }

    public void deletarUsuario(Usuario u) {
        this.ru.deletar(u);

    }

    public List<Usuario> recuperarTodosUsuarios() {
        return this.ru.recuperarTodos();
    }

    public String validarLogin(String login, String senha) {
        String senhaCriptografada = DigestUtils.md5Hex(DigestUtils.md2Hex(senha));
        this.login = this.ru.recuperarPorLogin(login, senhaCriptografada);

        if(this.login != null){
            this.SelectUsuario = this.login;
            return "index.xhtml";
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro", "Login ou senha invalida"));
        return null;
    }

   
}
