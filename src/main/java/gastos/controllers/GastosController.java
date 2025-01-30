package gastos.controllers;
import gastos.queries.GastosQuery;
import gastos.serializers.GastosSerializer;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import gastos.configs.BDConfig;

@RestController
@RequestMapping("apiGastos")
public class GastosController {
    //Constructor:
    public  GastosController()
    {
      BDConfig.ConexionDB();
    }

    @GetMapping(value = "/LocalDeploy" )
    public String testLocalDeploy() {
        return "Ruta => http://127.0.0.1:8080/apiGastos/LocalDeploy";
    }
    @GetMapping("/GetListRegistros")
    public String GetListRegistros() throws SQLException, JsonProcessingException {
        ResultSet rs = GastosQuery.getListadoRegistros();//SQL obtener data
        return GastosSerializer.serializeRegistro(rs);//ok
    }

}
