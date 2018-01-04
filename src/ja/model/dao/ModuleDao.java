package ja.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ja.model.entities.Module;

public class ModuleDao extends TemplateDao<Module> {

    public ModuleDao( Connection connexion ) {
        super( connexion );
        // TODO Auto-generated constructor stub
    }

    @Override
    public void completeObject( Module obj, ResultSet keys ) throws SQLException {
        obj.setIdModule( keys.getInt( 1 ) );

    }

    @Override
    public Module map( ResultSet result ) throws SQLException {
        Module module = new Module();
        module.setIdModule( result.getInt( "idModule" ) );
        module.setName( result.getString( "name" ) );
        return module;
    }

    @Override
    public PreparedStatement gettingSql( Object[] ids ) throws SQLException {
        String query = "SELECT * FROM Module WHERE idModule=?";
        PreparedStatement pStatement = this.connect.prepareStatement( query );
        pStatement.setObject( 1, ids[0] );
        return pStatement;
    }

    @Override
    public PreparedStatement creatingSql( Module obj ) throws SQLException {
        String query = "INSERT INTO Module (name) VALUES(?)";
        PreparedStatement pStatement = this.connect.prepareStatement( query, Statement.RETURN_GENERATED_KEYS );
        pStatement.setString( 1, obj.getName() );
        return pStatement;
    }

    @Override
    public boolean needReturnedValue() {
        return true;
    }

}
