package model;


import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.print.Doc;

@Entity
@Table(name = "RH13_DOCUMENTO")
@SequenceGenerator(name = "RH13_SQC", sequenceName = "RH13_SQC", allocationSize = 1, initialValue = 1)
public class Documento implements Serializable, AbstractEntity {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RH13_SQC")
    @Column(name = "RH13_COD_DOCUMENTO")
    private Long id;

    @Column(name = "RH13_ARQUIVO")
    private String arquivo;

    @Column(name = "RH13_EXTENSAO")
    private String extensao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RH13_DATA")
    private Date data;

    @ManyToOne
    @JoinColumn(name = "FKRH13RH12_COD_FORMACAO")
    private Formacao formacao;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    public String getExtensao() {
        return extensao;
    }

    public void setExtensao(String extensao) {
        this.extensao = extensao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Formacao getFormacao() {
        return formacao;
    }

    public void setFormacao(Formacao formacao) {
        this.formacao = formacao;
    }

    @Override
    public String toString() {
        return "Documento{" +
                "id=" + id +
                ", arquivo='" + arquivo + '\'' +
                ", extensao='" + extensao + '\'' +
                ", data=" + data +
                ", formacao=" + formacao +
                '}';
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Documento other = (Documento) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
