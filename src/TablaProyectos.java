import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;

public class TablaProyectos extends JPanel {
    ModeloProyectos modelo = new ModeloProyectos(); //Instanciamos la clase MOdeloProyectos

    public void TablaLider(){
        modelo.ModeloLider();
        setLayout(new BorderLayout());
        JTable tablaL = new JTable(modelo);
    
        JScrollPane panel = new JScrollPane(tablaL);
        add(panel, BorderLayout.CENTER);
    }

    public void TablaProyecto(){
        modelo.ModeloProyecto();
        setLayout(new BorderLayout());
        JTable tablaP = new JTable(modelo);
    
        JScrollPane panel = new JScrollPane(tablaP);
        add(panel, BorderLayout.CENTER);
    }

    public void TablaCompra(){
        modelo.ModeloCompra();
        setLayout(new BorderLayout());
        JTable tablaC = new JTable(modelo);
    
        JScrollPane panel = new JScrollPane(tablaC);
        add(panel, BorderLayout.CENTER);
    }
}