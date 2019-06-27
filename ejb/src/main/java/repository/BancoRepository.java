package repository;

import model.Banco;

import java.util.Collection;

/**
 * Created by Renan on 06/07/16.
 */
public interface BancoRepository {
    public Collection<Banco> getBancos();
}
