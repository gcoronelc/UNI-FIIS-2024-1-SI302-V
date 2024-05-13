
package pe.edu.uni.parcial_auqui.pruebas;

import java.sql.Connection;
import pe.edu.uni.parcial_auqui.AccesoBD.AccesoBD;


public class Prueba01 {

    public static void main(String[] args) {

        try {
            Connection cn = AccesoBD.getConnection();
            System.out.println("Ok");
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
