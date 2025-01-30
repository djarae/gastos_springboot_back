package gastos.serializers;
import java.sql.ResultSet;
import gastos.model.Registro;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegistroSerializer {
    public static String serializeRegistro(ResultSet rs) throws JsonProcessingException, SQLException {
        List<Registro> registroList = new ArrayList<>();
        while (rs.next()) {
            Registro itemRegistro = new Registro(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getInt("monto"),
                    rs.getInt("estado")
            );
            registroList.add(itemRegistro);
        };
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(registroList);
        return json;
    }
}
