package gastos.controllers;
import gastos.model.Registro;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import gastos.configs.BDConfig;

@RestController
@RequestMapping("apiGastos")
public class GastosController {
    //Constructor:
    public  GastosController()
    {
        BDConfig.ConexionDB();
    }

    //Ruta de testing , importante para comprobar que funciona app sin conexion bd:
    @GetMapping(value = "/tLocalDeploy" )
    public String testLocalDeploy() {
        return "Hola!Empoleon:ruta => http://127.0.0.1:8080/apiGastos/tLocalDeploy";
    }

    @GetMapping("/GetListRegistros")
    public String GetListRegistros() throws SQLException, JsonProcessingException {
        Statement s = BDConfig.Conexion.createStatement();
        //SQL: Obtenemos la data
        ResultSet rs = s.executeQuery ( "Select id,nombre,monto,estado from Registro");
        //Creamos el JSON
        List<Registro> registroList = new ArrayList<>();
        while (rs.next()) {
            System.out.println ("agregamos data al listado de ojbetos de escenario");
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
