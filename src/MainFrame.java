import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MainFrame extends JFrame{
    final Font fuenteBotones = new Font("Times New Roman", Font.BOLD, 30);
    final Font fuenteEtiqueta = new Font("Rockwell", Font.BOLD, 34);
    public void inicializar(){

        JPanel panelPrincipal = new JPanel();
        TablaProyectos tablaLid = new TablaProyectos();
        TablaProyectos tablaProy = new TablaProyectos();
        TablaProyectos tablaCom = new TablaProyectos();
        tablaLid.TablaLider();
        tablaProy.TablaProyecto();
        tablaCom.TablaCompra();

        JPanel panelInforme = new JPanel();
        panelInforme.setLayout(new BorderLayout(2,2));
        JLabel lbMensaje = new JLabel("Seleccione el informe que desea revisar");
        lbMensaje.setFont(fuenteEtiqueta);
        JLabel lbimagen = new JLabel();
        Image img = new ImageIcon("C:/Cursos/image.jpg").getImage();
        ImageIcon img2 = new ImageIcon(img.getScaledInstance(700, 450, Image.SCALE_SMOOTH));
        lbimagen.setIcon(img2);
        // lbimagen.setIcon(new ImageIcon("C:/Cursos/image.jpg"));
        
        panelInforme.add(lbMensaje, BorderLayout.NORTH); 
        panelInforme.add(lbimagen, BorderLayout.CENTER);

        JButton btnLider = new JButton("Lider");
        btnLider.setFont(fuenteBotones);
        btnLider.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                panelInforme.removeAll(); //Se remueven todos lo elementos que estan en este panel
                panelInforme.add(tablaLid, BorderLayout.CENTER);
                panelInforme.revalidate(); // llama a un contenedor una vez que se añaden nuevos componentes o se eliminan los antiguos.
            }
        });

        JButton btnProyecto = new JButton("Proyecto");
        btnProyecto.setFont(fuenteBotones);
        btnProyecto.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                panelInforme.removeAll();
                panelInforme.add(tablaProy, BorderLayout.CENTER); //colocacion del componente (tabla) en el panel
                panelInforme.revalidate();
            }               
        });

        JButton btnCompra = new JButton("Compra");
        btnCompra.setFont(fuenteBotones);
        btnCompra.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                panelInforme.removeAll();
                panelInforme.add(tablaCom, BorderLayout.CENTER);
                panelInforme.revalidate();
            }               
        });
        
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1,3));
        panelBotones.add(btnLider);
        panelBotones.add(btnProyecto);
        panelBotones.add(btnCompra);
        
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(panelInforme, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        add(panelPrincipal);
        setTitle("Programa del Ministerio de Vivienda");
        setSize(700, 600);
        setMinimumSize(new Dimension(400, 400));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
        
    public static void main(String[] args) {
        MainFrame ventana = new MainFrame();
        ventana.inicializar();
    }
}
