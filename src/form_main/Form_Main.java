/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form_main;



/**
 *
 * @author haloi
 */
public class Form_Main extends javax.swing.JFrame {
    
    
    int width = 320;
    int hight = 570;

    /**
     * Creates new form Form_Main
     */
    public Form_Main() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_Frame = new javax.swing.JPanel();
        jPanel_menu = new javax.swing.JPanel();
        quanly_ke = new javax.swing.JLabel();
        quanly_docgia = new javax.swing.JLabel();
        quanly_sach = new javax.swing.JLabel();
        quanly_muontra = new javax.swing.JLabel();
        quanly_trehan = new javax.swing.JLabel();
        quanly_nhapsach = new javax.swing.JLabel();
        quanly_nguoidung = new javax.swing.JLabel();
        baocao_thongke = new javax.swing.JLabel();
        close_menu = new javax.swing.JLabel();
        close_form = new javax.swing.JLabel();
        logo_formMain = new javax.swing.JLabel();
        menu_bar = new javax.swing.JLabel();
        jPanel_main = new javax.swing.JPanel();
        quan_li_ke = new javax.swing.JPanel();
        quan_ly_doc_gia = new javax.swing.JPanel();
        quan_ly_sach = new javax.swing.JPanel();
        quan_ly_muon_tra = new javax.swing.JPanel();
        quan_ly_tre_han = new javax.swing.JPanel();
        quan_ly_nhap_sach = new javax.swing.JPanel();
        quan_ly_nguoi_dung = new javax.swing.JPanel();
        bao_cao_thong_ke = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel_Frame.setBackground(new java.awt.Color(204, 204, 204));

        jPanel_menu.setPreferredSize(new java.awt.Dimension(320, 570));
        jPanel_menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel_menuMouseClicked(evt);
            }
        });

        quanly_ke.setText("Quản lý người dùng");

        quanly_docgia.setText("Quản lý nhập");

        quanly_sach.setText("Giao dịch");

        quanly_muontra.setText("Quản lý độc giả");

        quanly_trehan.setText("Quản lý sách");

        quanly_nhapsach.setText("Thống kê");

        quanly_nguoidung.setText("Quản lý trễ hạn");

        baocao_thongke.setText("Quản lý kệ");

        close_menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-x-48.png"))); // NOI18N

        close_form.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-logout-35.png"))); // NOI18N

        javax.swing.GroupLayout jPanel_menuLayout = new javax.swing.GroupLayout(jPanel_menu);
        jPanel_menu.setLayout(jPanel_menuLayout);
        jPanel_menuLayout.setHorizontalGroup(
            jPanel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_menuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(quanly_ke, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(quanly_sach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(quanly_muontra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(quanly_trehan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(quanly_nguoidung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel_menuLayout.createSequentialGroup()
                        .addComponent(baocao_thongke, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(close_menu))
                    .addGroup(jPanel_menuLayout.createSequentialGroup()
                        .addComponent(quanly_docgia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(quanly_nhapsach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel_menuLayout.createSequentialGroup()
                        .addComponent(close_form)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel_menuLayout.setVerticalGroup(
            jPanel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_menuLayout.createSequentialGroup()
                .addGroup(jPanel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_menuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(baocao_thongke, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(close_menu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quanly_muontra, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(quanly_trehan, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(quanly_sach, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(quanly_nguoidung, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(quanly_docgia, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(quanly_ke, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(quanly_nhapsach, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(close_form)
                .addGap(48, 48, 48))
        );

        logo_formMain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/image.png"))); // NOI18N

        menu_bar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-list-40.png"))); // NOI18N
        menu_bar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_barMouseClicked(evt);
            }
        });

        jPanel_main.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout quan_li_keLayout = new javax.swing.GroupLayout(quan_li_ke);
        quan_li_ke.setLayout(quan_li_keLayout);
        quan_li_keLayout.setHorizontalGroup(
            quan_li_keLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 868, Short.MAX_VALUE)
        );
        quan_li_keLayout.setVerticalGroup(
            quan_li_keLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );

        jPanel_main.add(quan_li_ke, "card2");

        javax.swing.GroupLayout quan_ly_doc_giaLayout = new javax.swing.GroupLayout(quan_ly_doc_gia);
        quan_ly_doc_gia.setLayout(quan_ly_doc_giaLayout);
        quan_ly_doc_giaLayout.setHorizontalGroup(
            quan_ly_doc_giaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 868, Short.MAX_VALUE)
        );
        quan_ly_doc_giaLayout.setVerticalGroup(
            quan_ly_doc_giaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );

        jPanel_main.add(quan_ly_doc_gia, "card3");

        javax.swing.GroupLayout quan_ly_sachLayout = new javax.swing.GroupLayout(quan_ly_sach);
        quan_ly_sach.setLayout(quan_ly_sachLayout);
        quan_ly_sachLayout.setHorizontalGroup(
            quan_ly_sachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 868, Short.MAX_VALUE)
        );
        quan_ly_sachLayout.setVerticalGroup(
            quan_ly_sachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );

        jPanel_main.add(quan_ly_sach, "card4");

        javax.swing.GroupLayout quan_ly_muon_traLayout = new javax.swing.GroupLayout(quan_ly_muon_tra);
        quan_ly_muon_tra.setLayout(quan_ly_muon_traLayout);
        quan_ly_muon_traLayout.setHorizontalGroup(
            quan_ly_muon_traLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 868, Short.MAX_VALUE)
        );
        quan_ly_muon_traLayout.setVerticalGroup(
            quan_ly_muon_traLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );

        jPanel_main.add(quan_ly_muon_tra, "card5");

        javax.swing.GroupLayout quan_ly_tre_hanLayout = new javax.swing.GroupLayout(quan_ly_tre_han);
        quan_ly_tre_han.setLayout(quan_ly_tre_hanLayout);
        quan_ly_tre_hanLayout.setHorizontalGroup(
            quan_ly_tre_hanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 868, Short.MAX_VALUE)
        );
        quan_ly_tre_hanLayout.setVerticalGroup(
            quan_ly_tre_hanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );

        jPanel_main.add(quan_ly_tre_han, "card6");

        javax.swing.GroupLayout quan_ly_nhap_sachLayout = new javax.swing.GroupLayout(quan_ly_nhap_sach);
        quan_ly_nhap_sach.setLayout(quan_ly_nhap_sachLayout);
        quan_ly_nhap_sachLayout.setHorizontalGroup(
            quan_ly_nhap_sachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 868, Short.MAX_VALUE)
        );
        quan_ly_nhap_sachLayout.setVerticalGroup(
            quan_ly_nhap_sachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );

        jPanel_main.add(quan_ly_nhap_sach, "card7");

        javax.swing.GroupLayout quan_ly_nguoi_dungLayout = new javax.swing.GroupLayout(quan_ly_nguoi_dung);
        quan_ly_nguoi_dung.setLayout(quan_ly_nguoi_dungLayout);
        quan_ly_nguoi_dungLayout.setHorizontalGroup(
            quan_ly_nguoi_dungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 868, Short.MAX_VALUE)
        );
        quan_ly_nguoi_dungLayout.setVerticalGroup(
            quan_ly_nguoi_dungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );

        jPanel_main.add(quan_ly_nguoi_dung, "card8");

        javax.swing.GroupLayout bao_cao_thong_keLayout = new javax.swing.GroupLayout(bao_cao_thong_ke);
        bao_cao_thong_ke.setLayout(bao_cao_thong_keLayout);
        bao_cao_thong_keLayout.setHorizontalGroup(
            bao_cao_thong_keLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 868, Short.MAX_VALUE)
        );
        bao_cao_thong_keLayout.setVerticalGroup(
            bao_cao_thong_keLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );

        jPanel_main.add(bao_cao_thong_ke, "card9");

        javax.swing.GroupLayout jPanel_FrameLayout = new javax.swing.GroupLayout(jPanel_Frame);
        jPanel_Frame.setLayout(jPanel_FrameLayout);
        jPanel_FrameLayout.setHorizontalGroup(
            jPanel_FrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_FrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menu_bar)
                .addGap(8, 8, 8)
                .addComponent(logo_formMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(882, 882, 882))
            .addGroup(jPanel_FrameLayout.createSequentialGroup()
                .addComponent(jPanel_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(229, 229, 229)
                .addComponent(jPanel_main, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
        );
        jPanel_FrameLayout.setVerticalGroup(
            jPanel_FrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_FrameLayout.createSequentialGroup()
                .addGroup(jPanel_FrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_FrameLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(logo_formMain, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel_FrameLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(menu_bar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel_FrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel_main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel_Frame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_Frame, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel_menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_menuMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel_menuMouseClicked

    private void menu_barMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_barMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_menu_barMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bao_cao_thong_ke;
    private javax.swing.JLabel baocao_thongke;
    private javax.swing.JLabel close_form;
    private javax.swing.JLabel close_menu;
    private javax.swing.JPanel jPanel_Frame;
    private javax.swing.JPanel jPanel_main;
    private javax.swing.JPanel jPanel_menu;
    private javax.swing.JLabel logo_formMain;
    private javax.swing.JLabel menu_bar;
    private javax.swing.JPanel quan_li_ke;
    private javax.swing.JPanel quan_ly_doc_gia;
    private javax.swing.JPanel quan_ly_muon_tra;
    private javax.swing.JPanel quan_ly_nguoi_dung;
    private javax.swing.JPanel quan_ly_nhap_sach;
    private javax.swing.JPanel quan_ly_sach;
    private javax.swing.JPanel quan_ly_tre_han;
    private javax.swing.JLabel quanly_docgia;
    private javax.swing.JLabel quanly_ke;
    private javax.swing.JLabel quanly_muontra;
    private javax.swing.JLabel quanly_nguoidung;
    private javax.swing.JLabel quanly_nhapsach;
    private javax.swing.JLabel quanly_sach;
    private javax.swing.JLabel quanly_trehan;
    // End of variables declaration//GEN-END:variables

   
     //To change body of generated methods, choose Tools | Templates.
    
}
