/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hieu_ung;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import jdk.internal.foreign.LayoutPath;

/**
 *
 * @author haloi
 */
public class Hieuung {
    private JPanel jpn_view;
    private String Select = "";
    public Hieuung(JPanel jpn_view){
        this.jpn_view = jpn_view;
        
    }
    public void setView(JPanel jpn_sach, JLabel jlb_sach){
        Select = "Quan ly sach";
        jpn_sach.setBackground(new Color(204, 206, 107) );
        jlb_sach.setBackground(new Color(204, 198, 169) );
        jpn_view.removeAll();
        jpn_view.setLayout(new BorderLayout());
        jpn_view.add(new JPanel());
        jpn_view.validate();
        jpn_view.repaint();
    }
    private void seteVent(){
        
    }
}
