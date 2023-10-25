/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package form_main;


import Contructor.QuanLySach;
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
public class quan_ly_sach_JPanel extends javax.swing.JPanel {

    /**
     * Creates new form quan_ly_sach_JPanel
     */
    List<QuanLySach> list = new QuanLySach().getList();
    QuanLySach sach;
    private static int pos = 0;
    private boolean isAsc = true;
    private TableRowSorter<DefaultTableModel> tableRowSorter;
    public quan_ly_sach_JPanel() {
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
        this.txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                // Lấy giá trị được nhập vào ô textbox jsearch
                String text = txtsearch.getText();

                // Sử dụng phương thức setRowFilter() của đối tượng RowSorter để lọc dữ liệu trong bảng
                tableRowSorter.setRowFilter(RowFilter.regexFilter(text));
            }
        });
    }

    private void sort() {
        // Lấy mô hình của bảng
        DefaultTableModel model = (DefaultTableModel) this.jTable_view.getModel();

        // Tạo một đối tượng Comparator để so sánh dữ liệu trong cột Ho va ten đệm
        Comparator<QuanLySach> comparator = (o1, o2) -> {
            if (this.isAsc) {
                return o1.getTensach().compareTo(o2.getTensach());
            } else {
                return o2.getTensach().compareTo(o1.getTensach());
            }
        };        
        // Đổi trạng thái sắp xếp của cột Ho va ten đệm
        this.isAsc = !this.isAsc;
    }
    
    public void view(){
        List<QuanLySach> list = new QuanLySach().getList();
        sach = list.get(pos);
        this.txtma_sach.setText(Integer.toString(sach.getMasach()));
        this.txtma_ke_sach.setText(Integer.toString(sach.getMakesach()));
        this.txtten_sach.setText(sach.getTensach());
        this.txtthe_loai.setText(sach.getTheloai());
        this.txttac_gia.setText(sach.getTacgia());
        this.txtso_luong.setText(Integer.toString(sach.getSoluong()));
        this.jDatengay_xuat_ban.setDate(sach.getNgayxuatban());
        this.txtnha_xuat_ban.setText(sach.getNhasanxuat());
        this.txttinh_trang_sach.setText(sach.getTinhtrangsach());
        
        
    }
    
    public QuanLySach getmodel_create() throws Exception{
        QuanLySach sach = new QuanLySach();
        sach.setMasach(Integer.parseInt(txtma_sach.getText()));
        sach.setMakesach(Integer.parseInt(txtma_ke_sach.getText()));
        sach.setTensach(txtten_sach.getText());
        sach.setTheloai(txtthe_loai.getText());
        sach.setTacgia(txttac_gia.getText());
        sach.setSoluong(Integer.parseInt(txtso_luong.getText()));        
        sach.setNgayxuatban((Date) jDatengay_xuat_ban.getDate());
        sach.setNhasanxuat(txtnha_xuat_ban.getText());
        sach.setTinhtrangsach(txttinh_trang_sach.getText());
        sach.create(sach);
        return sach;
    }
    public QuanLySach getmodel_update() throws Exception{
        QuanLySach sach = new QuanLySach();
        sach.setMasach(Integer.parseInt(txtma_sach.getText()));
        sach.setMakesach(Integer.parseInt(txtma_ke_sach.getText()));
        sach.setTensach(txtten_sach.getText());
        sach.setTheloai(txtthe_loai.getText());
        sach.setTacgia(txttac_gia.getText());
        sach.setSoluong(Integer.parseInt(txtso_luong.getText()));        
        sach.setNgayxuatban((Date) jDatengay_xuat_ban.getDate());
        sach.setNhasanxuat(txtnha_xuat_ban.getText());
        sach.setTinhtrangsach(txttinh_trang_sach.getText());
        sach.edit(sach);
        return sach;
    }
    public QuanLySach getmodel_delete() throws Exception{
        QuanLySach sach = new QuanLySach();
        sach.setMasach(Integer.parseInt(txtma_sach.getText()));
        sach.delete(sach);
        return sach;
    }

    public void table_view(){
        DefaultTableModel model = (DefaultTableModel) this.jTable_view.getModel();
        model.setNumRows(0);
        
        for(QuanLySach x : list){
            model.addRow(new Object[]{ x.getMasach(), x.getMakesach(), x.getTensach(), x.getTheloai(), x.getTacgia(), x.getSoluong(), x.getNgayxuatban(), x.getNhasanxuat(), x.getTinhtrangsach()});
        }
    }
     public void refreshTable() {
        DefaultTableModel model = (DefaultTableModel) jTable_view.getModel();
        model.setRowCount(0); // Xóa tất cả các dòng hiện tại trong bảng

        List<QuanLySach> updatedList = new QuanLySach().getList(); // Lấy danh sách mới từ cơ sở dữ liệu
        for (QuanLySach x : updatedList) {
            model.addRow(new Object[]{ x.getMasach(), x.getMakesach(), x.getTensach(), x.getTheloai(), x.getTacgia(), x.getSoluong(), x.getNgayxuatban(), x.getNhasanxuat(), x.getTinhtrangsach()});
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_view = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        txtThemSach = new javax.swing.JButton();
        btnUpdateSach = new javax.swing.JButton();
        btnDeleteSach = new javax.swing.JButton();
        txtsearch = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtma_ke_sach = new javax.swing.JTextField();
        txtten_sach = new javax.swing.JTextField();
        txttac_gia = new javax.swing.JTextField();
        txtso_luong = new javax.swing.JTextField();
        txtnha_xuat_ban = new javax.swing.JTextField();
        txttinh_trang_sach = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtma_sach = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtthe_loai = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jDatengay_xuat_ban = new com.toedter.calendar.JDateChooser();

        setPreferredSize(new java.awt.Dimension(1070, 570));

        jTable_view.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sách", "Mã kệ sách", "Tên sách", "Thể Loại", "Tác Giả", "Số lượng", "Ngày Sản Xuất", "Nhà Xuất Bản", "Tình Trạng Sách"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable_view.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_viewMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_view);

        txtThemSach.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        txtThemSach.setText("Insert");
        txtThemSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtThemSachActionPerformed(evt);
            }
        });

        btnUpdateSach.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btnUpdateSach.setText("Update");
        btnUpdateSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateSachActionPerformed(evt);
            }
        });

        btnDeleteSach.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btnDeleteSach.setText("Delete");
        btnDeleteSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteSachActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addComponent(btnUpdateSach, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtThemSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnDeleteSach, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtsearch))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtThemSach, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(btnUpdateSach, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(btnDeleteSach, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 885, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        jLabel2.setText("Mã Kệ Sách");

        jLabel3.setText("Tên Sách");

        jLabel5.setText("Tác Giả");

        jLabel6.setText("Số Lượng");

        jLabel8.setText("Nhà Xuất bản");

        jLabel9.setText("Tình trạng sách");

        txtma_ke_sach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtma_ke_sachActionPerformed(evt);
            }
        });

        txtten_sach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtten_sachActionPerformed(evt);
            }
        });

        jLabel1.setText("Mã sách");

        jLabel4.setText("Thể loại");

        jLabel7.setText("Ngày xuất bản");

        jDatengay_xuat_ban.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtma_ke_sach, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                    .addComponent(txtten_sach)
                    .addComponent(txtma_sach))
                .addGap(73, 73, 73)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txttac_gia))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtso_luong, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(26, 26, 26)
                        .addComponent(txtthe_loai)))
                .addGap(73, 73, 73)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txttinh_trang_sach)
                    .addComponent(txtnha_xuat_ban)
                    .addComponent(jDatengay_xuat_ban, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
                .addContainerGap(307, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jDatengay_xuat_ban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(txttinh_trang_sach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(txtnha_xuat_ban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtma_sach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)
                                .addComponent(txtthe_loai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(txtso_luong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtma_ke_sach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(txttac_gia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtten_sach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtThemSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtThemSachActionPerformed
        // TODO add your handling code here:
        try {
            QuanLySach sach = getmodel_create();
            refreshTable();
        } catch (Exception ex) {
            System.out.println("Error" + ex);
        }
    }//GEN-LAST:event_txtThemSachActionPerformed

    private void btnUpdateSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateSachActionPerformed
        // TODO add your handling code here:
        try {
            QuanLySach sach = getmodel_update();
            refreshTable();
        } catch (Exception ex) {
            System.out.println("Error" + ex);
        }

    }//GEN-LAST:event_btnUpdateSachActionPerformed

    private void btnDeleteSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteSachActionPerformed
        // TODO add your handling code here:
        try {
            QuanLySach sach = getmodel_delete();
            refreshTable();
        } catch (Exception ex) {
            System.out.println("Error" + ex);
        }

    }//GEN-LAST:event_btnDeleteSachActionPerformed

    private void jTable_viewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_viewMouseClicked
        // TODO add your handling code here:
        pos = this.jTable_view.getSelectedRow();
        view();
    }//GEN-LAST:event_jTable_viewMouseClicked

    private void txtten_sachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtten_sachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtten_sachActionPerformed

    private void txtma_ke_sachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtma_ke_sachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtma_ke_sachActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteSach;
    private javax.swing.JButton btnUpdateSach;
    private com.toedter.calendar.JDateChooser jDatengay_xuat_ban;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_view;
    private javax.swing.JButton txtThemSach;
    private javax.swing.JTextField txtma_ke_sach;
    private javax.swing.JTextField txtma_sach;
    private javax.swing.JTextField txtnha_xuat_ban;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JTextField txtso_luong;
    private javax.swing.JTextField txttac_gia;
    private javax.swing.JTextField txtten_sach;
    private javax.swing.JTextField txtthe_loai;
    private javax.swing.JTextField txttinh_trang_sach;
    // End of variables declaration//GEN-END:variables
}
