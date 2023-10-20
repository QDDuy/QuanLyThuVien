/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package form_main;

import Contructor.QuanLyMuonTra;
import java.util.Date;
import java.util.Comparator;
import java.util.List;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.naming.spi.DirStateFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;


/**
 *
 * @author haloi
 */
public class quan_ly_muon_traJPanel extends javax.swing.JPanel {

    List<QuanLyMuonTra> list = new QuanLyMuonTra().getList();
    QuanLyMuonTra muonTra;
    private int pos = 0;
    private boolean isAsc = true;
    private TableRowSorter<DefaultTableModel> tableRowSorter;
    public quan_ly_muon_traJPanel() {
        initComponents();
        view();
        table_view();
        
        this.jTable_view.setAutoCreateRowSorter(true);

        // Thêm phương thức sort() cho bảng
        this.jTable_view.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                // Kiểm tra xem người dùng có click chuột vào cột Ho va ten đệm hay không
                if (evt.getSource() == jTable_view && evt.getClickCount() == 1 && evt.getButton() == java.awt.event.MouseEvent.BUTTON1) {
                    // Lấy cột mà người dùng click chuột
                    int columnIndex = jTable_view.getColumnModel().getColumnIndexAtX(evt.getX());
                    // Kiểm tra xem cột đó có phải là cột Ho va ten đệm hay không
                    if (columnIndex == 2) {
                        // Sắp xếp dữ liệu trong bảng theo thứ tự tăng dần hoặc giảm dần
                        sort();
                    }
                }
            }
        });
        
        
        tableRowSorter = new TableRowSorter<>((DefaultTableModel) this.jTable_view.getModel());
        this.jTable_view.setRowSorter(tableRowSorter);

        // Thêm sự kiện keyTyped() cho ô textbox jsearch
        this.txtTimKiemmt.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                // Lấy giá trị được nhập vào ô textbox jsearch
                String text = txtTimKiemmt.getText();

                // Sử dụng phương thức setRowFilter() của đối tượng RowSorter để lọc dữ liệu trong bảng
                tableRowSorter.setRowFilter(RowFilter.regexFilter(text));
            }
        });
    }

    private void sort() {
        // Lấy mô hình của bảng
        DefaultTableModel model = (DefaultTableModel) this.jTable_view.getModel();

        // Tạo một đối tượng Comparator để so sánh dữ liệu trong cột Ho va ten đệm
        Comparator<QuanLyMuonTra> comparator = (o1, o2) -> {
            if (this.isAsc) {
                return o1.getNgaymuon().compareTo(o2.getNgaymuon());
            } else {
                return o2.getNgaymuon().compareTo(o1.getNgaymuon());
            }
        };

        
        // Đổi trạng thái sắp xếp của cột Ho va ten đệm
        this.isAsc = !this.isAsc;
    }
    
    public void view(){
        List<QuanLyMuonTra> list = new QuanLyMuonTra().getList();
        muonTra = list.get(pos);
        this.txtMaGD.setText(Integer.toString(muonTra.getMaGiaodich()));
        this.txtMaThe.setText(Integer.toString(muonTra.getMathe()));
        this.txtMaSach.setText(Integer.toString(muonTra.getMasach()));
        this.txtNgayMuon.setDate(muonTra.getNgaymuon());
        this.txtNgayHetHan.setDate(muonTra.getNgayhethan());
        this.txtNgayTraSach.setDate(muonTra.getNgaytrasach());
        this.txtSoTien.setText(Double.toString(muonTra.getSotien()));
        
    }
    
    
    public QuanLyMuonTra getmodel_create() throws Exception{
        QuanLyMuonTra muonTra = new QuanLyMuonTra();
        muonTra.setMaGiaodich(Integer.parseInt(txtMaGD.getText()));
        muonTra.setMathe(Integer.parseInt(txtMaSach.getText()));
        muonTra.setMasach(Integer.parseInt(txtMaSach.getText()));        
        muonTra.setNgaymuon((Date) txtNgayMuon.getDate());
        muonTra.setNgayhethan((Date) txtNgayHetHan.getDate());
        muonTra.setNgaytrasach((Date) txtNgayTraSach.getDate());
        muonTra.setSotien(Integer.parseInt(txtSoTien.getText()));
        muonTra.create(muonTra);
        return muonTra;
    }
    public QuanLyMuonTra getmodel_update() throws Exception{
        QuanLyMuonTra muonTra = new QuanLyMuonTra();
        muonTra.setMaGiaodich(Integer.parseInt(txtMaGD.getText()));
        muonTra.setMathe(Integer.parseInt(txtMaSach.getText()));
        muonTra.setMasach(Integer.parseInt(txtMaSach.getText()));      
        muonTra.setNgaymuon((Date) txtNgayMuon.getDate());
        muonTra.setNgayhethan((Date) txtNgayHetHan.getDate());
        muonTra.setNgaytrasach((Date) txtNgayTraSach.getDate());
        muonTra.setSotien(Integer.parseInt(txtSoTien.getText()));
        muonTra.edit(muonTra);
        return muonTra;
    }
    public QuanLyMuonTra getmodel_delete() throws Exception{
        QuanLyMuonTra muonTra = new QuanLyMuonTra();
        muonTra.setMaGiaodich(Integer.parseInt(txtMaGD.getText()));
        muonTra.delete(muonTra);
        return muonTra;
    }

    public void table_view(){
        DefaultTableModel model = (DefaultTableModel) this.jTable_view.getModel();
        model.setNumRows(0);
        
        for(QuanLyMuonTra x : list){
            model.addRow(new Object[]{ x.getMaGiaodich(), x.getMathe(), x.getMasach(), x.getNgaymuon(), x.getNgayhethan(), x.getNgaytrasach(), x.getSotien()});
        }
    }
     public void refreshTable() {
        DefaultTableModel model = (DefaultTableModel) jTable_view.getModel();
        model.setRowCount(0); // Xóa tất cả các dòng hiện tại trong bảng

        List<QuanLyMuonTra> updatedList = new QuanLyMuonTra().getList(); // Lấy danh sách mới từ cơ sở dữ liệu
        for (QuanLyMuonTra x : updatedList) {
            model.addRow(new Object[]{ x.getMaGiaodich(), x.getMathe(), x.getMasach(), x.getNgaymuon(), x.getNgayhethan(), x.getNgaytrasach(), x.getSotien()});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_view = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtTimKiemmt = new javax.swing.JTextField();
        txtMaGD = new javax.swing.JTextField();
        txtMaThe = new javax.swing.JTextField();
        txtMaSach = new javax.swing.JTextField();
        txtSoTien = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNgayMuon = new com.toedter.calendar.JDateChooser();
        txtNgayHetHan = new com.toedter.calendar.JDateChooser();
        txtNgayTraSach = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        btnXoaMT = new javax.swing.JButton();
        btnUpdateMT = new javax.swing.JButton();
        btnThemMT = new javax.swing.JButton();

        jTable_view.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã giao dịch", "Mã Thẻ", "Mã Sách", "Ngày Mượn", "Ngày Hết Hạn", "Ngày Trả Sách", "Số Tiền"
            }
        ));
        jTable_view.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_viewMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_view);

        jLabel1.setText("Mã GD :");

        jLabel2.setText("Mã Thẻ :");

        jLabel3.setText("Mã Sách :");

        jLabel4.setText("Ngày Mượn :");

        jLabel5.setText("Ngày HH :");

        jLabel6.setText("Ngày Trả :");

        jLabel7.setText("Số Tiền :");

        txtNgayMuon.setDateFormatString("yyyy/MM/dd");

        txtNgayHetHan.setDateFormatString("yyyy/MM/dd");

        txtNgayTraSach.setDateFormatString("yyyy/MM/dd");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTimKiemmt, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtMaGD, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSoTien, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(txtMaSach, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(txtMaThe, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(txtNgayMuon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNgayHetHan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNgayTraSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(txtTimKiemmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaGD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaThe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtNgayMuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtNgayHetHan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtNgayTraSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(28, 28, 28))
        );

        btnXoaMT.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btnXoaMT.setText("delete");
        btnXoaMT.setPreferredSize(new java.awt.Dimension(90, 30));
        btnXoaMT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaMTActionPerformed(evt);
            }
        });

        btnUpdateMT.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btnUpdateMT.setText("Update");
        btnUpdateMT.setPreferredSize(new java.awt.Dimension(90, 30));
        btnUpdateMT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateMTActionPerformed(evt);
            }
        });

        btnThemMT.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btnThemMT.setText("Insert");
        btnThemMT.setPreferredSize(new java.awt.Dimension(90, 30));
        btnThemMT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addComponent(btnThemMT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104)
                .addComponent(btnXoaMT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(119, 119, 119)
                .addComponent(btnUpdateMT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(404, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoaMT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateMT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemMT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemMTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMTActionPerformed
        // TODO add your handling code here:
        try {
            QuanLyMuonTra muonTra = getmodel_create();
            refreshTable();
            view();
        } catch (Exception ex) {
            System.out.println("Error" + ex);
        }
    }//GEN-LAST:event_btnThemMTActionPerformed

    private void jTable_viewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_viewMouseClicked
        // TODO add your handling code here:
         pos = this.jTable_view.getSelectedRow();
         view();
    }//GEN-LAST:event_jTable_viewMouseClicked

    private void btnXoaMTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaMTActionPerformed
        // TODO add your handling code here:
        try {
            QuanLyMuonTra muonTra = getmodel_delete();
            refreshTable();
            view();
        } catch (Exception ex) {
            System.out.println("Error" + ex);
        }
        
    }//GEN-LAST:event_btnXoaMTActionPerformed

    private void btnUpdateMTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateMTActionPerformed
        // TODO add your handling code here:
        try {
            QuanLyMuonTra muonTra = getmodel_update();
            refreshTable();
            view();
        } catch (Exception ex) {
            System.out.println("Error" + ex);
        }
    }//GEN-LAST:event_btnUpdateMTActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThemMT;
    private javax.swing.JButton btnUpdateMT;
    private javax.swing.JButton btnXoaMT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_view;
    private javax.swing.JTextField txtMaGD;
    private javax.swing.JTextField txtMaSach;
    private javax.swing.JTextField txtMaThe;
    private com.toedter.calendar.JDateChooser txtNgayHetHan;
    private com.toedter.calendar.JDateChooser txtNgayMuon;
    private com.toedter.calendar.JDateChooser txtNgayTraSach;
    private javax.swing.JTextField txtSoTien;
    private javax.swing.JTextField txtTimKiemmt;
    // End of variables declaration//GEN-END:variables
}
