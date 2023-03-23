package com.example.View.BackgroundImages;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
public class BGIHomePage extends JLabel {
   
    private Image image;

    public BGIHomePage(String imagePath) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        image = imageIcon.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension size = getSize();
        g.drawImage(image, 0, 0, size.width, size.height, null);
    }
}
