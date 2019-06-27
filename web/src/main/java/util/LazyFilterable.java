package util;

import java.util.List;
import java.util.Map;

import org.primefaces.model.SortOrder;

/**
 * Componente para auxiliar a flexiblidade para a manipulação de filtros em
 * uma <code>DataTable</code> do <b>primefaces</b>.
 *
 * @param <T>
 * @author Renan Costa
 */
public interface LazyFilterable<T> {

    /**
     * Utilizado para criar o filtro na <code>DataTable</code>.
     *
     * @param first
     * @param pageSize
     * @param sortField
     * @param sortOrder
     * @param filters
     * @return
     */
    public List<T> tableFilter(int first, int pageSize, String sortField,
                               SortOrder sortOrder, Map<String, Object> filters);
}
