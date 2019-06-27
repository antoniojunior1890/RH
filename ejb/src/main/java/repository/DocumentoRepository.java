package repository;

import model.Documento;
import model.Formacao;
import model.Servidor;

import java.util.Collection;

/**
 * Created by antonio on 20/07/16.
 */
public interface DocumentoRepository {
    public Collection<Documento> getDocumentos(Formacao formacao);
}
