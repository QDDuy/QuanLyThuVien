
package form_main;

import Contructor.QuanLyNhapSach;
import java.util.Date;
import java.util.Comparator;
import java.util.List;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class quan_ly_nhapJPanel extends javax.swing.JPanel {

    List<QuanLyNhapSach> list = new QuanLyNhapSach().getList();
    QuanLyNhapSach nhapSach;
    private int pos = 0;
    private boolean isAsc = true;
    private TableRowSorter<DefaultTableModel> tableRowSorter;
    public quan_ly_nhapJPanel() {
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
        this.txtSearchPN.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                // Lấy giá trị được nhập vào ô textbox jsearch
                String text = txtSearchPN.getText();

                // Sử dụng phương thức setRowFilter() của đối tượng RowSorter để lọc dữ liệu trong bảng
                tableRowSorter.setRowFilter(RowFilter.regexFilter(text));
            }
        });
    }
    private void sort() {
        // Lấy mô hình của bảng
        DefaultTableModel model = (DefaultTableModel) this.jTable_view.getModel();

        // Tạo một đối tượng Comparator để so sánh dữ liệu trong cột Ho va ten đệm
        Comparator<QuanLyNhapSach> comparator = (o1, o2) -> {
            if (this.isAsc) {
                return o1.getNgaynhap().compareTo(o2.getNgaynhap());
            } else {
                return o2.getNgaynhap().compareTo(o1.getNgaynhap());
            }
        };

        
        // Đổi trạng thái sắp xếp của cột Ho va ten đệm
        this.isAsc = !this.isAsc;
    }
    
    public void view(){
        List<QuanLyNhapSach> list = new QuanLyNhapSach().getList();
        nhapSach = list.get(pos);
        this.txtMaPN.setText(Integer.toString(nhapSach.getMaphieunhap()));
        this.txtMaSach.setText(Integer.toString(nhapSach.getMasach()));
        this.txtNguoiNhap.setText((nhapSach.getNguoinhap()));
        this.txtNgayNhap.setDate(nhapSach.getNgaynhap());
        this.txtSoLuong.setText(Integer.toString(nhapSach.getSoluong()));
        
    }
    public QuanLyNhapSach getmodel_create() throws Exception{
        QuanLyNhapSach nhapSach = new QuanLyNhapSach();
        nhapSach.setMaphieunhap(Integer.parseInt(txtMaPN.getText()));
        nhapSach.setMasach(Integer.parseInt(txtMaSach.getText()));
        nhapSach.setNguoinhap(txtNguoiNhap.getText());        
        nhapSach.setNgaynhap((Date) txtNgayNhap.getDate());
        nhapSach.setSoluong(Integer.parseInt( txtSoLuong.getText()));
        nhapSach.create(nhapSach);
        return nhapSach;
    }
    public QuanLyNhapSach getmodel_update() throws Exception{
        QuanLyNhapSach nhapSach = new QuanLyNhapSach();
        nhapSach.setMaphieunhap(Integer.parseInt(txtMaPN.getText()));
        nhapSach.setMasach(Integer.parseInt(txtMaSach.getText()));
        nhapSach.setNguoinhap(txtNguoiNhap.getText());        
        nhapSach.setNgaynhap((Date) txtNgayNhap.getDate());
        nhapSach.setSoluong(Integer.parseInt( txtSoLuong.getText()));
        nhapSach.edit(nhapSach);
        return nhapSach;
    }
    public QuanLyNhapSach getmodel_delete() throws Exception{
        QuanLyNhapSach muonTra = new QuanLyNhapSach();
        muonTra.setMaphieunhap(Integer.parseInt(txtMaPN.getText()));
        muonTra.delete(muonTra);
        return muonTra;
    }
     public void table_view(){
        DefaultTableModel model = (DefaultTableModel) this.jTable_view.getModel();
        model.setNumRows(0);
        
        for(QuanLyNhapSach x : list){
            model.addRow(new Object[]{ x.getMaphieunhap(), x.getMasach(), x.getNguoinhap(), x.getNgaynhap(), x.getSoluong() });
        }
    }
     public void refreshTable() {
        DefaultTableModel model = (DefaultTableModel) jTable_view.getModel();
        model.setRowCount(0); // Xóa tất cả các dòng hiện tại trong bảng

        List<QuanLyNhapSach> updatedList = new QuanLyNhapSach().getList(); // Lấy danh sách mới từ cơ sở dữ liệu
        for (QuanLyNhapSach x : updatedList) {
            model.addRow(new Object[]{ x.getMaphieunhap(), x.getMasach(), x.getNguoinhap(), x.getNgaynhap(), x.getSoluong() });
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_view = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtMaPN = new javax.swing.JTextField();
        txtNguoiNhap = new javax.swing.JTextField();
        txtMaSach = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        txtSearchPN = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNgayNhap = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        btnThemPN = new javax.swing.JButton();
        btnXoaPN = new javax.swing.JButton();
        btnUpdatePN = new javax.swing.JButton();

        jTable_view.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Phiếu Nhập", "Mã Sách", "Người Nhập", "Ngày Nhập", "Số Lượng"
            }
        ));
        jTable_view.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_viewMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_view);

        jLabel1.setText("Search");

        jLabel2.setText("Mã Phiếu Nhập :");

        jLabel3.setText("Mã Sách");

        jLabel4.setText("Người nhập :");

        jLabel5.setText("Ngày Nhập :");

        jLabel6.setText("Số Lượng :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaPN)
                            .addComponent(txtMaSach)
                            .addComponent(txtNguoiNhap)
                            .addComponent(txtSoLuong)
                            .addComponent(txtNgayNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(txtSearchPN, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNguoiNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtNgayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(64, 64, 64))
        );

        btnThemPN.setText("Insert");
        btnThemPN.setPreferredSize(new java.awt.Dimension(90, 30));
        btnThemPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemPNActionPerformed(evt);
            }
        });

        btnXoaPN.setText("Delete");
        btnXoaPN.setPreferredSize(new java.awt.Dimension(90, 30));
        btnXoaPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaPNActionPerformed(evt);
            }
        });

        btnUpdatePN.setText("Update");
        btnUpdatePN.setPreferredSize(new java.awt.Dimension(90, 30));
        btnUpdatePN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdatePNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(btnThemPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(151, 151, 151)
                .addComponent(btnXoaPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137)
                .addComponent(btnUpdatePN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdatePN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTable_viewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_viewMouseClicked
        // TODO add your handling code here:
           pos = this.jTable_view.getSelectedRow();
         view();
    }//GEN-LAST:event_jTable_viewMouseClicked

    private void btnThemPNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemPNActionPerformed
        // TODO add your handling code here:
        try {
            QuanLyNhapSach nhapSach = getmodel_create();
            refreshTable();
        } catch (Exception ex) {
            System.out.println("Error" + ex);
        }
    }//GEN-LAST:event_btnThemPNActionPerformed

    private void btnXoaPNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaPNActionPerformed
        // TODO add your handling code here:
          try {
            QuanLyNhapSach nhapSach = getmodel_delete();
            refreshTable();
        } catch (Exception ex) {
            System.out.println("Error" + ex);
        }
    }//GEN-LAST:event_btnXoaPNActionPerformed

    private void btnUpdatePNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdatePNActionPerformed
        // TODO add your handling code here:
        
        try {
            QuanLyNhapSach nhapSach = getmodel_update();
            refreshTable();
        } catch (Exception ex) {
            System.out.println("Error" + ex);
        }
    }//GEN-LAST:event_btnUpdatePNActionPerformed

   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThemPN;
    private javax.swing.JButton btnUpdatePN;
    private javax.swing.JButton btnXoaPN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_view;
    private javax.swing.JTextField txtMaPN;
    private javax.swing.JTextField txtMaSach;
    private com.toedter.calendar.JDateChooser txtNgayNhap;
    private javax.swing.JTextField txtNguoiNhap;
    private javax.swing.JTextField txtSearchPN;
    private javax.swing.JTextField txtSoLuong;
    // End of variables declaration//GEN-END:variables
}
