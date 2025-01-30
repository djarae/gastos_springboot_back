package gastos.controllers;
import com.fasterxml.jackson.core.JsonProcessingException;
import gastos.queries.RegistroQuery;
import gastos.serializers.RegistroSerializer;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistroController {
    public static String getRegistros()  throws SQLException, JsonProcessingException {
        ResultSet rs = RegistroQuery.getListadoRegistros();//SQL obtener data
        return RegistroSerializer.serializeRegistro(rs);//ok
    }
}



