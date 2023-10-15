/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hieu_ung;

import Dao.danhmuc;
import form_main.quan_ly_doc_giaJPanel;
import form_main.quan_ly_muon_traJPanel;
import form_main.quan_ly_nguoi_dungJPanel;
import form_main.quan_ly_nhapJPanel;
import form_main.quan_ly_sach_JPanel;
import form_main.quan_ly_thong_keJPanel;
import form_main.quan_ly_tre_hanJPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.constant.DirectMethodHandleDesc;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import jdk.internal.foreign.LayoutPath;
import jdk.internal.jimage.ImageReader;

/**
 *
 * @author haloi
 */
public class Hieuung {
    private JPanel jpn_view;
    private String Select = "";
    private List<danhmuc> list = null;
    public Hieuung(JPanel jpn_view){
        this.jpn_view = jpn_view;
        
    }
    public void setView(JPanel jpn_sach, JLabel jlb_sach){
        Select = "Quan ly sach";
        jpn_sach.setBackground(new Color(217,235,255) );
        jlb_sach.setBackground(new Color(217, 235, 255) );
        jpn_view.removeAll();
        jpn_view.setLayout(new BorderLayout());
        jpn_view.add(new quan_ly_doc_giaJPanel());
        jpn_view.validate();
        jpn_view.repaint();
    }
    public void seteVent(List<danhmuc> list){
        this.list = list;
        for(danhmuc menu: list ){
           menu.getJlb().addMouseListener(new hieuung_label(menu.getKind(), menu.getJpn(), menu.getJlb()));
        }
    }
    
    class hieuung_label implements MouseListener{
        
        private JPanel node;

        private String kind;
        private JPanel jpnItem;
        private JLabel jlbItem;

        public hieuung_label(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch(kind){
                case "quan_ly_doc_gia":
                    node = new quan_ly_doc_giaJPanel();
                    break;
                case "quan_ly_sach":
                    node = new quan_ly_sach_JPanel();
                    break;
                case "quan_ly_muon_tra":
                    node = new quan_ly_muon_traJPanel();
                    break;
                case "quan_ly_tre_han":
                    node = new quan_ly_tre_hanJPanel();
                    break;
                case "quan_ly_nhap_sach":
                    node = new  quan_ly_nhapJPanel();
                    break;
                case "thong_ke":
                    node = new quan_ly_thong_keJPanel();
                    break;
                case "quan_ly_nguoi_dung":
                    node = new quan_ly_nguoi_dungJPanel();
                    break;
                default:
                    break;
            }
            jpn_view.removeAll();
            jpn_view.setLayout(new BorderLayout());
            jpn_view.add(node);
            jpn_view.validate();
            jpn_view.repaint();
            set_change_bg(kind);
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
            Select = kind;
            jpnItem.setBackground(new Color(204, 206, 107));
            jlbItem.setBackground(new Color(204, 206, 107));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(204, 206, 107));
            jlbItem.setBackground(new Color(204, 206, 107));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(!Select.equalsIgnoreCase(kind)){
                jpnItem.setBackground(new Color(217, 235, 255));
                jlbItem.setBackground(new Color(217, 235, 255));
            }
        }
    private void set_change_bg(String kind){
        for(danhmuc lis: list){
            if(lis.getKind().equalsIgnoreCase(kind)){
                lis.getJpn().setBackground(new Color(204, 206, 107));
                lis.getJlb().setBackground(new Color(204, 206, 107));
            }else{
                lis.getJpn().setBackground(new Color(217, 235, 255));
                lis.getJlb().setBackground(new Color(217, 235, 255));
            }
        }
    }
        
        
    }
}
