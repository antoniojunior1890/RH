package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/**
 * Created by Renan on 21/07/16.
 */
@Entity
@Table(name = "CG16_USUARIO")
@SequenceGenerator(name = "CG16_SQC", sequenceName = "CG16_SQC", allocationSize = 1, initialValue = 1)
public class Usuario implements Serializable, AbstractEntity {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public static final String senhaPadraoDescriptografada = "123456";
    public static final String senhaPadraoCriptografada = "e10adc3949ba59abbe56e057f20f883e";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "CG16_SQC")
    @Column(name = "CG16_COD_USUARIO")
    private Long id;

    @Column(name = "CG16_CPF")
    private String cpf;

    @Column(name = "CG16_SENHA")
    private String senha;

    @Column(name = "CG16_EMAIL")
    private String email;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CG16_DATA_CADASTRO")
    private Date dataCadastro;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CG16_ULTIMO_ACESSO")
    private Date ultimoAcesso;

    @Column(name = "CG16_BLOQUEADO")
    private Integer bloqueado;

    @Column(name = "CG16_ID")
    private String idUsuario;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FKCG16RH01_COD_PESSOA")
    private Pessoa pessoa;

    @OneToOne
    @JoinColumn(name = "FKCG16CG18_COD_MOTIVO_BLOQUEIO")
    private MotivoBloqueio motivoBloqueio;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "FKCG17CG16_COD_USUARIO")
    private Collection<PerfilUsuario> perfisUsuario;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getUltimoAcesso() {
        return ultimoAcesso;
    }

    public void setUltimoAcesso(Date ultimoAcesso) {
        this.ultimoAcesso = ultimoAcesso;
    }

    public Integer getBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(Integer bloqueado) {
        this.bloqueado = bloqueado;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public MotivoBloqueio getMotivoBloqueio() {
        return motivoBloqueio;
    }

    public void setMotivoBloqueio(MotivoBloqueio motivoBloqueio) {
        this.motivoBloqueio = motivoBloqueio;
    }

    public Collection<PerfilUsuario> getPerfisUsuario() {
        return perfisUsuario;
    }

    public void setPerfisUsuario(Collection<PerfilUsuario> perfisUsuario) {
        this.perfisUsuario = perfisUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuario usuario = (Usuario) o;

        return id != null ? id.equals(usuario.id) : usuario.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", senha='" + senha + '\'' +
                ", email='" + email + '\'' +
                ", dataCadastro=" + dataCadastro +
                ", ultimoAcesso=" + ultimoAcesso +
                ", bloqueado=" + bloqueado +
                ", idUsuario='" + idUsuario + '\'' +
                ", pessoa=" + pessoa +
                ", motivoBloqueio=" + motivoBloqueio +
                ", perfisUsuario=" + perfisUsuario +
                '}';
    }
}
