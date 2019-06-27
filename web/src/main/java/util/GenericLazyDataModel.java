package util;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import model.AbstractEntity;

/**
 * Responsável por gerir a <code>DataTable</code> do <b>Primefaces</b> que lida
 * com grandes conjuntos de dados.
 *
 * @author Renan Costa
 * @see org.primefaces.model.LazyDataModel
 */
public class GenericLazyDataModel<T extends AbstractEntity> extends
        LazyDataModel<T> {
    private static final long serialVersionUID = 1L;

    private List<T> rows;
    private LazyFilterable<T> lazy;

    public GenericLazyDataModel(LazyFilterable<T> lazy) {
        this.lazy = lazy;
    }

    @Override
    public List<T> load(int first, int pageSize, String sortField,
                        SortOrder sortOrder, Map<String, Object> filters) {
        rows = lazy.tableFilter(first, pageSize, sortField, sortOrder, filters);
        setPageSize(pageSize);
        return rows;
    }

    @Override
    public Number getRowKey(T entity) {
        return entity.getId();
    }

}
