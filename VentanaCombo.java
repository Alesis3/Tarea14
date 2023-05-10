import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class VentanaCombo extends JFrame {

    private JLabel lblNombre;
    private JTextField txtNombre;
    private JButton boton;
    private JComboBox combo;
    private VentanaCB modelo;

    public VentanaCombo(String title) throws HeadlessException {
        this.setSize(400,400);
        setLayout(new FlowLayout());
        lblNombre = new JLabel("Ingresa un nombre ");
        this.getContentPane().add(lblNombre);

        txtNombre= new JTextField(30);
        this.getContentPane().add(txtNombre);

        boton = new JButton("Agregar");
        this.getContentPane().add(boton);

        //configurando modelo
        modelo = new VentanaCB();
        modelo.agregarNombre("Juan");
        modelo.agregarNombre("HUgo");
        modelo.agregarNombre("Maria");

        combo = new JComboBox(modelo);
        this.getContentPane().add(combo);


        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                String nuevo = txtNombre.getText();
                modelo.agregarNombre(nuevo);
                txtNombre.setText("");
            }
        });
        combo.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(combo.getSelectedIndex());
                System.out.println(combo.getSelectedItem());
                JOptionPane.showMessageDialog(null, "Hola "+ combo.getSelectedItem());
            }
        });


        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}