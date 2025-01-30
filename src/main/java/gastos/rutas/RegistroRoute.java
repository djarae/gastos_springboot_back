package gastos.rutas;
import gastos.controllers.RegistroController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import gastos.configs.BDConfig;

@RestController
@RequestMapping("registros")
public class RegistroRoute {
    public RegistroRoute()
    {
      BDConfig.ConexionDB();
    }

    @GetMapping(value = "/LocalDeploy" )
    public String testLocalDeploy() {
        return "Ruta => http://127.0.0.1:8080/registros/LocalDeploy";
    }
    @GetMapping("/get")
    public String GetListRegistros() throws SQLException, JsonProcessingException {
        return RegistroController.getRegistros();
    }

}
