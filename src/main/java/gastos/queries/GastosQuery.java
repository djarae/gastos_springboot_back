package gastos.queries;
import gastos.configs.BDConfig;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class GastosQuery {

    public static ResultSet getListadoRegistros()  throws SQLException{
        Statement s = BDConfig.Conexion.createStatement();
        ResultSet rs = s.executeQuery ( "Select id,nombre,monto,estado from Registro");
        System.out.println("aa");
        return rs;
    }
}
