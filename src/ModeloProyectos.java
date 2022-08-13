// import javax.swing.*;
// import java.awt.*;
import javax.swing.table.*;
import java.sql.*;

public class ModeloProyectos extends DefaultTableModel {
    ResultSet datos;
    
    public void ModeloLider(){
        this.addColumn("ID_Lider");
        this.addColumn("Nombre");
        this.addColumn("Primer_Apellido");
        this.addColumn("Ciudad_Residencia");


        try { // Para establecer la conexion con la base de datos
            Connection c = DriverManager.getConnection("jdbc:sqlite://C:/Cursos/Base_Datos/ProyectosConstruccion.db");
            System.out.println("Conexion abierta con la base de datos"); 

            Statement stmt = c.createStatement(); // para poder hacer la consulta con sql
            
            String consulta = "select ID_Lider, Nombre, Primer_Apellido, Ciudad_Residencia from Lider order BY Ciudad_Residencia";
            datos = stmt.executeQuery(consulta); // Se ejecuta la consulta
            
            while(datos.next()){ //Para traer el resultado de la consulta hacia el modelo de datos
                Object [] fila = new Object[4];
                for(int i=0; i<4; i++){
                    fila[i] = datos.getObject(i+1);
                }
                this.addRow(fila);

            }
            
            stmt.close();
            c.close();
            System.out.println("La consulta se realizó con éxito!!");
           
        }
        catch (Exception e) { // si no se puede realizar la consulta imprime en consola el error que se produjo
            System.err.println( e.getClass().getName()+ ": " + e.getMessage());
        }
    }

    public void ModeloProyecto(){
        this.addColumn("ID_Proyecto");
        this.addColumn("Constructora");
        this.addColumn("Numero_Habitaciones");
        this.addColumn("Ciudad");


        try { // Para establecer la conexion con la base de datos
            Connection c = DriverManager.getConnection("jdbc:sqlite://C:/Cursos/Base_Datos/ProyectosConstruccion.db");
            System.out.println("Conexion abierta con la base de datos"); 

            Statement stmt = c.createStatement(); // para poder hacer la consulta con sql
            
            String consulta = "SELECT ID_Proyecto, Constructora, Numero_Habitaciones, Ciudad FROM Proyecto WHERE Clasificacion = 'Casa Campestre' AND Ciudad IN ('Santa Marta', 'Barranquilla', 'Cartagena')";
            datos = stmt.executeQuery(consulta); // Se ejecuta la consulta
            
            while(datos.next()){ //Para traer el resultado de la consulta hacia el modelo de datos
                Object [] fila = new Object[4];
                for(int i=0; i<4; i++){
                    fila[i] = datos.getObject(i+1);
                }
                this.addRow(fila);

            }
            
            stmt.close();
            c.close();
            System.out.println("La consulta se realizó con éxito!!");
           
        }
        catch (Exception e) { // si no se puede realizar la consulta imprime en consola el error que se produjo
            System.err.println( e.getClass().getName()+ ": " + e.getMessage());
        }
    }

    public void ModeloCompra(){
        this.addColumn("ID_Compra");
        this.addColumn("Constructora");
        this.addColumn("Banco_Vinculado");


        try { // Para establecer la conexion con la base de datos
            Connection c = DriverManager.getConnection("jdbc:sqlite://C:/Cursos/Base_Datos/ProyectosConstruccion.db");
            System.out.println("Conexion abierta con la base de datos"); 

            Statement stmt = c.createStatement(); // para poder hacer la consulta con sql
            
            String consulta = "SELECT ID_Compra, Constructora, Banco_Vinculado FROM Compra JOIN Proyecto ON Compra.ID_Proyecto = Proyecto.ID_Proyecto WHERE Proveedor = 'Homecenter' AND Ciudad = 'Salento'";
            datos = stmt.executeQuery(consulta); // Se ejecuta la consulta
            
            while(datos.next()){ //Para traer el resultado de la consulta hacia el modelo de datos
                Object [] fila = new Object[3];
                for(int i=0; i<3; i++){
                    fila[i] = datos.getObject(i+1);
                }
                this.addRow(fila);

            }
            
            stmt.close();
            c.close();
            System.out.println("La consulta se realizó con éxito!!");
           
        }
        catch (Exception e) { // si no se puede realizar la consulta imprime en consola el error que se produjo
            System.err.println( e.getClass().getName()+ ": " + e.getMessage());
        }
    }
}
