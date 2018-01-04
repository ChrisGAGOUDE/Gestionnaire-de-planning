package ja.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

public abstract class TemplateDao<T> implements Dao<T> {
    protected Connection connect;

    public TemplateDao( Connection connexion ) {
        this.connect = connexion;
    }

    @Override
    public void create( T obj ) {
        try {
            PreparedStatement pStatement = creatingSql( obj );
            int status = pStatement.executeUpdate();
            if ( status == 0 ) {
                System.out.println( "Echec de l'enregistrement du batiment." );
            } else {
                if ( needReturnedValue() ) {

                    ResultSet keys = pStatement.getGeneratedKeys();
                    keys.next();
                    completeObject( obj, keys );
                }
            }

        } catch ( SQLException e ) {
            e.printStackTrace();
        }
    }

    public abstract void completeObject( T obj, ResultSet keys ) throws SQLException;

    @Override
    public void update( T obj ) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete( T obj ) {
        // TODO Auto-generated method stub

    }

    public T get( Object... ids ) {
        try {
            PreparedStatement pStatement = gettingSql( ids );
            ResultSet result = pStatement.executeQuery();
            if ( result.next() )
                return map( result );
            else
                return null;
        } catch ( SQLException e ) {
            e.printStackTrace();
            return null;
        }
    }

    public abstract T map( ResultSet result ) throws SQLException;

    public abstract PreparedStatement gettingSql( Object[] ids ) throws SQLException;

    @Override
    public Set<T> getMany() {
        // TODO Auto-generated method stub
        return null;
    }

    public abstract PreparedStatement creatingSql( T obj ) throws SQLException;

    public abstract boolean needReturnedValue();

}
