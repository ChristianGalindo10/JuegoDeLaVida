package Services;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;

public class ObjetosGraficos {
    private static ObjetosGraficos servicio;
    private JPanel panel;
    private JButton boton;
    private JLabel label;
    private JCheckBox check;
    private GridLayout gridlayout;

    public JPanel construirPanel(int x, int y, int ancho, int alto, Color colorfondo, Border borde) {
        panel = new JPanel();
        panel.setSize(ancho, alto);
        panel.setLocation(x, y);
        panel.setLayout(null);
        panel.setBackground(colorfondo);
        panel.setBorder(borde);
        return panel;
    }

    public JButton construirJButton(String texto, int x, int y, int ancho, int alto, Cursor cursor, Color colorFondo, Color colorFuente) {
        boton = new JButton(texto);
        boton.setSize(ancho, alto);
        boton.setLocation(x, y);
        boton.setFocusable(false);
        boton.setCursor(cursor);
        boton.setBackground(colorFondo);
        boton.setForeground(colorFuente);
        return boton;
    }

    public JLabel construirJLabel(String texto, int x, int y, int ancho, int alto, Cursor cursor, ImageIcon imagen, Font fuente, Color colorFondo,
            Color colorFuente, Border borde) {
        label = new JLabel(texto);
        label.setLocation(x, y);
        label.setSize(ancho, alto);
        label.setLayout(null);
        label.setForeground(colorFuente);
        label.setCursor(cursor);
        label.setIcon(imagen);
        label.setBorder(borde);
        label.setFont(fuente);
        return label;
    }

    public GridLayout construirGridLayout(int columnas, int Hgap, int rows, int Vgap) {
        gridlayout = new GridLayout();
        gridlayout.setColumns(columnas);
        gridlayout.setHgap(Hgap);
        gridlayout.setVgap(Vgap);
        gridlayout.setRows(rows);
        return gridlayout;
    }

    public static ObjetosGraficos getServicio() {
        if (servicio == null)
            servicio = new ObjetosGraficos();
        return servicio;
    }
}
