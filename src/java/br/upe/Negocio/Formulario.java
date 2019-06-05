
package br.upe.Negocio;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@ManagedBean
@RequestScoped
@Entity
@Table(name = "Formulario")

public class Formulario implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    
    @Column(name = "titulo", length = 100)
    private String titulo;

    @Column(name = "Nome dos Autores", length = 100)
    private String nomeautores;
            
    @Column(name = "Jornal ou Evento", length = 100)
    private String jornalouevento;

    @Column(name = "ano", length = 100)
    private String ano;
    
      @Column(name = "paginas", length = 100)
    private String paginas;
            
    @Column(name = "doi", length = 100)
    private String doi;

    @Column(name = "isbn", length = 100)
    private String isbn;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNomeautores() {
        return nomeautores;
    }

    public void setNomeautores(String nomeautores) {
        this.nomeautores = nomeautores;
    }

    public String getJornalouevento() {
        return jornalouevento;
    }

    public void setJornalouevento(String jornalouevento) {
        this.jornalouevento = jornalouevento;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getPaginas() {
        return paginas;
    }

    public void setPaginas(String paginas) {
        this.paginas = paginas;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Formulario other = (Formulario) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
}
