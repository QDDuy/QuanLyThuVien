/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package form_main;

import DAO.QuanLyNguoiDung;
import java.util.Comparator;
import java.util.List;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class quan_ly_nguoi_dungJPanel extends javax.swing.JPanel {

   List<QuanLyNguoiDung> list = new QuanLyNguoiDung().getList();
    QuanLyNguoiDung nguoiDung;
    private static int pos = 0;
    private boolean isAsc = true;
    private TableRowSorter<DefaultTableModel> tableRowSorter;
    public quan_ly_nguoi_dungJPanel() {
        initComponents();
        view();
        table_view();
        
        this.jTable_view.setAutoCreateRowSorter(true);

        // Thêm phương thức sort() cho bảng
        this.jTable_view.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                
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
        this.txtSearchND.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                // Lấy giá trị được nhập vào ô textbox jsearch
                String text = txtSearchND.getText();

                // Sử dụng phương thức setRowFilter() của đối tượng RowSorter để lọc dữ liệu trong bảng
                tableRowSorter.setRowFilter(RowFilter.regexFilter(text));
            }
        });
    }
     private void sort() {
        // Lấy mô hình của bảng
        DefaultTableModel model = (DefaultTableModel) this.jTable_view.getModel();

        // Tạo một đối tượng Comparator để so sánh dữ liệu trong cột Ho va ten đệm
        Comparator<QuanLyNguoiDung> comparator = (o1, o2) -> {
            if (this.isAsc) {
                return o1.getTennguoidung().compareToIgnoreCase(o2.getTennguoidung());
            } else {
                return o2.getTennguoidung().compareToIgnoreCase(o1.getTennguoidung());
            }
        };

        
        

        // Đổi trạng thái sắp xếp của cột Ho va ten đệm
        this.isAsc = !this.isAsc;
    }
    
    public void view(){
        List<QuanLyNguoiDung> list = new QuanLyNguoiDung().getList();
        nguoiDung = list.get(pos);
        this.txtMaND.setText(Integer.toString(nguoiDung.getManguoidung()));
        this.txtTenND.setText(nguoiDung.getTennguoidung());
        this.txtMatKhau.setText(nguoiDung.getMatkhau());
        this.txtChucVu.setText(nguoiDung.getChucvu());
        
    }

    public void table_view(){
        DefaultTableModel model = (DefaultTableModel) this.jTable_view.getModel();
        model.setNumRows(0);
        
        for(QuanLyNguoiDung x : list){
            model.addRow(new Object[]{ x.getManguoidung(), x.getTennguoidung(), x.getMatkhau(), x.getChucvu()});
        }
    }
    public void refreshTable() {
        DefaultTableModel model = (DefaultTableModel) jTable_view.getModel();
        model.setRowCount(0); // Xóa tất cả các dòng hiện tại trong bảng

        List<QuanLyNguoiDung> updatedList = new QuanLyNguoiDung().getList(); // Lấy danh sách mới từ cơ sở dữ liệu
        for (QuanLyNguoiDung x : updatedList) {
            model.addRow(new Object[]{x.getManguoidung(), x.getTennguoidung(), x.getMatkhau(), x.getChucvu()});
        }
    }
    public QuanLyNguoiDung getmodel_create() throws Exception{
        QuanLyNguoiDung nguoiDung = new QuanLyNguoiDung();
        nguoiDung.setManguoidung(Integer.parseInt(txtMaND.getText()));
        nguoiDung.setTennguoidung(txtTenND.getText());
        nguoiDung.setMatkhau(txtMatKhau.getText());
        nguoiDung.setChucvu("Nhân Viên");
        nguoiDung.create(nguoiDung);
        return nguoiDung;
    }
    public QuanLyNguoiDung getmodel_update() throws Exception{
        QuanLyNguoiDung nguoiDung = new QuanLyNguoiDung();
        nguoiDung.setManguoidung(Integer.parseInt(txtMaND.getText()));
        nguoiDung.setTennguoidung(txtTenND.getText());
        nguoiDung.setMatkhau(txtMatKhau.getText());
        nguoiDung.setChucvu("Nhân Viên");
        nguoiDung.edit(nguoiDung);
        return nguoiDung;
    }
    public QuanLyNguoiDung getmodel_delete() throws Exception{
        QuanLyNguoiDung nguoiDung = new QuanLyNguoiDung();
        nguoiDung.setManguoidung(Integer.parseInt(txtMaND.getText()));
        nguoiDung.delete(nguoiDung);
        return nguoiDung;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnThemPN = new javax.swing.JButton();
        btnXoaPN = new javax.swing.JButton();
        btnUpdatePN = new javax.swing.JButton();
        btnTimKiemPN = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_view = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtMaND = new javax.swing.JTextField();
        txtMatKhau = new javax.swing.JTextField();
        txtTenND = new javax.swing.JTextField();
        txtChucVu = new javax.swing.JTextField();
        txtSearchND = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnThemND = new javax.swing.JButton();
        btnXoaND = new javax.swing.JButton();
        btnUpdateND = new javax.swing.JButton();

        btnThemPN.setText("Thêm");
        btnThemPN.setPreferredSize(new java.awt.Dimension(90, 30));

        btnXoaPN.setText("Xóa");
        btnXoaPN.setPreferredSize(new java.awt.Dimension(90, 30));

        btnUpdatePN.setText("Update");
        btnUpdatePN.setPreferredSize(new java.awt.Dimension(90, 30));

        btnTimKiemPN.setText("Tìm kiếm");
        btnTimKiemPN.setPreferredSize(new java.awt.Dimension(90, 30));

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
                .addGap(143, 143, 143)
                .addComponent(btnTimKiemPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdatePN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiemPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );

        setPreferredSize(new java.awt.Dimension(1070, 570));

        jTable_view.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Người Dùng", "Tên Người Dùng", "Mật Khẩu", "Chức Vụ"
            }
        ));
        jTable_view.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_viewMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_view);

        txtChucVu.setEditable(false);
        txtChucVu.setBackground(new java.awt.Color(204, 204, 204));
        txtChucVu.setText("Nhân Viên");

        jLabel2.setText("Mã Người Dùng :");

        jLabel3.setText("Tên Người Dùng :");

        jLabel4.setText("Mật Khẩu :");

        jLabel5.setText("Chức Vụ :");

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
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaND)
                            .addComponent(txtTenND)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(44, 44, 44)
                        .addComponent(txtMatKhau))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(51, 51, 51)
                        .addComponent(txtChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))
                    .addComponent(txtSearchND, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(txtSearchND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(143, 143, 143))
        );

        btnThemND.setText("Insert");
        btnThemND.setPreferredSize(new java.awt.Dimension(90, 30));
        btnThemND.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNDActionPerformed(evt);
            }
        });

        btnXoaND.setText("Delete");
        btnXoaND.setPreferredSize(new java.awt.Dimension(90, 30));
        btnXoaND.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaNDActionPerformed(evt);
            }
        });

        btnUpdateND.setText("Update");
        btnUpdateND.setPreferredSize(new java.awt.Dimension(90, 30));
        btnUpdateND.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateNDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(btnThemND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(151, 151, 151)
                .addComponent(btnXoaND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137)
                .addComponent(btnUpdateND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(327, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 716, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents
                                 

    private void btnThemNDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNDActionPerformed
        // TODO add your handling code here:
        try {
            QuanLyNguoiDung nguoiDung = getmodel_create();
            refreshTable();
        } catch (Exception ex) {
            System.out.println("Error" + ex);
        }
    }//GEN-LAST:event_btnThemNDActionPerformed

    private void btnXoaNDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaNDActionPerformed
        // TODO add your handling code here:
        try {
            QuanLyNguoiDung nguoiDung = getmodel_delete();
            refreshTable();
        } catch (Exception ex) {
            System.out.println("Error" + ex);
        }
    }//GEN-LAST:event_btnXoaNDActionPerformed

    private void btnUpdateNDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateNDActionPerformed
        // TODO add your handling code here:
        try {
            QuanLyNguoiDung nguoiDung = getmodel_update();
            refreshTable();
        } catch (Exception ex) {
            System.out.println("Error" + ex);
        }
    }//GEN-LAST:event_btnUpdateNDActionPerformed

    private void jTable_viewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_viewMouseClicked
        // TODO add your handling code here:
        pos = this.jTable_view.getSelectedRow();
        view();
    }//GEN-LAST:event_jTable_viewMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThemND;
    private javax.swing.JButton btnThemPN;
    private javax.swing.JButton btnTimKiemPN;
    private javax.swing.JButton btnUpdateND;
    private javax.swing.JButton btnUpdatePN;
    private javax.swing.JButton btnXoaND;
    private javax.swing.JButton btnXoaPN;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_view;
    private javax.swing.JTextField txtChucVu;
    private javax.swing.JTextField txtMaND;
    private javax.swing.JTextField txtMatKhau;
    private javax.swing.JTextField txtSearchND;
    private javax.swing.JTextField txtTenND;
    // End of variables declaration//GEN-END:variables
}
