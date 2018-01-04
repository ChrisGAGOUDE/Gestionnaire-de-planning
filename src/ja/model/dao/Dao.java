package ja.model.dao;

import java.util.Set;

public interface Dao<T> {

    public void create( T obj );

    public void update( T obj );

    public void delete( T obj );

    public T get( Object... ids );

    public Set<T> getMany();
}
