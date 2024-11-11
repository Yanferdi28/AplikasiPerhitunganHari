/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.YearMonth;
import java.util.Calendar;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import javax.swing.JOptionPane;
/**
 *
 * @author Fetra
 */
public class PerhitunganHariFrame extends javax.swing.JFrame {

    /**
     * Creates new form PerhitunganHariFrame
     */
    public PerhitunganHariFrame() {
        initComponents();
        addActionListeners();
    }
    
    // Metode untuk menambahkan ActionListener pada tombol
    private void addActionListeners() {
        btnHitungHari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hitungHariDalamBulan();
            }
        });
        
        btnHitungSelisih.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            hitungSelisihHari();
        }
        });
        
        // Menambahkan listener untuk mengupdate utamaCalendar saat bulan atau tahun diubah
        cbBulan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateCalendar();
            }
        });
        
        spinTahun.addChangeListener(e -> updateCalendar());
    }

    // Metode untuk menghitung jumlah hari dalam bulan yang dipilih
    private void hitungHariDalamBulan() {
    try {
        // Mendapatkan bulan dan tahun dari komponen
        int bulan = cbBulan.getSelectedIndex() + 1; // Tambah 1 karena bulan dimulai dari 0
        int tahun = (int) spinTahun.getValue(); // Mengambil nilai dari JSpinner

        // Menghitung jumlah hari dalam bulan yang dipilih
        YearMonth yearMonth = YearMonth.of(tahun, bulan);
        int daysInMonth = yearMonth.lengthOfMonth();

        // Mendapatkan tanggal pertama dan terakhir dalam bulan tersebut
        String firstDay = translateDayToIndonesian(yearMonth.atDay(1).getDayOfWeek().toString()); // Hari pertama
        String lastDay = translateDayToIndonesian(yearMonth.atDay(daysInMonth).getDayOfWeek().toString()); // Hari terakhir

        // Menampilkan jumlah hari, hari pertama, dan hari terakhir dalam bulan
        JOptionPane.showMessageDialog(this, "Jumlah hari di bulan " + cbBulan.getSelectedItem() +
                " " + tahun + " adalah: " + daysInMonth + " hari.\n" +
                "Hari pertama dalam bulan ini: " + firstDay + "\n" +
                "Hari terakhir dalam bulan ini: " + lastDay);
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + ex.getMessage());
    }
}

// Metode untuk menerjemahkan hari ke Bahasa Indonesia
    private String translateDayToIndonesian(String day) {
        switch (day) {
            case "MONDAY":
                return "Senin";
            case "TUESDAY":
                return "Selasa";
            case "WEDNESDAY":
                return "Rabu";
            case "THURSDAY":
                return "Kamis";
            case "FRIDAY":
                return "Jumat";
            case "SATURDAY":
                return "Sabtu";
            case "SUNDAY":
                return "Minggu";
            default:
                return day; // Jika ada kesalahan, kembalikan teks aslinya
        }
    }
    
    private void hitungSelisihHari() {
        try {
            // Mengambil tanggal dari JCalendar
            LocalDate tanggalAwal = awalCalendar.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate tanggalAkhir = akhirCalendar.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            // Menghitung selisih hari antara tanggal awal dan tanggal akhir
            long selisihHari = ChronoUnit.DAYS.between(tanggalAwal, tanggalAkhir);

            // Menampilkan hasil
            JOptionPane.showMessageDialog(this, "Selisih hari antara kedua tanggal adalah: " + selisihHari + " hari.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + ex.getMessage());
        }
    }

    // Metode untuk memperbarui utamaCalendar berdasarkan bulan dan tahun yang dipilih
    private void updateCalendar() {
        int bulan = cbBulan.getSelectedIndex(); // Dapatkan bulan dari JComboBox (dimulai dari 0)
        int tahun = (int) spinTahun.getValue(); // Dapatkan tahun dari JSpinner
        
        // Set calendar ke tanggal 1 pada bulan dan tahun yang dipilih
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, tahun);
        cal.set(Calendar.MONTH, bulan);
        cal.set(Calendar.DAY_OF_MONTH, 1);

        // Perbarui utamaCalendar dengan tanggal baru
        utamaCalendar.setCalendar(cal);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbBulan = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        spinTahun = new javax.swing.JSpinner();
        jPanel5 = new javax.swing.JPanel();
        btnHitungSelisih = new javax.swing.JButton();
        btnHitungHari = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        utamaCalendar = new com.toedter.calendar.JCalendar();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        awalCalendar = new com.toedter.calendar.JCalendar();
        akhirCalendar = new com.toedter.calendar.JCalendar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Perhitungan Hari");

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Pilih Bulan dan Tahun"));

        jLabel1.setText("Pilih Bulan:");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        cbBulan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember" }));

        jLabel2.setText("Masukkan Tahun:");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        spinTahun.setModel(new javax.swing.SpinnerNumberModel(2024, null, null, 1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(291, 291, 291)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbBulan, 0, 393, Short.MAX_VALUE)
                    .addComponent(spinTahun))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbBulan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spinTahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(10, 10, 10))
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.NORTH);

        jPanel5.setPreferredSize(new java.awt.Dimension(809, 75));

        btnHitungSelisih.setText("Hitung Selisih Hari");

        btnHitungHari.setText("Hitung Hari Dalam Bulan");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHitungHari, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE)
                    .addComponent(btnHitungSelisih, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(btnHitungHari)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHitungSelisih)
                .addGap(12, 12, 12))
        );

        jPanel1.add(jPanel5, java.awt.BorderLayout.SOUTH);

        jPanel6.setLayout(new java.awt.GridBagLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Kalender"));

        utamaCalendar.setDate(new java.util.Date(1704106391000L));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(utamaCalendar, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(utamaCalendar, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 181;
        gridBagConstraints.ipady = 167;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel6.add(jPanel3, gridBagConstraints);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Hitung Selisih Hari Antara Dua Tanggal"));
        jPanel4.setPreferredSize(new java.awt.Dimension(392, 265));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel3.setText("Tanggal Awal:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(83, 99, 0, 0);
        jPanel4.add(jLabel3, gridBagConstraints);

        jLabel4.setText("Tanggal Akhir:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(68, 97, 0, 0);
        jPanel4.add(jLabel4, gridBagConstraints);

        awalCalendar.setDate(new java.util.Date(1704106535000L));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 0, 11);
        jPanel4.add(awalCalendar, gridBagConstraints);

        akhirCalendar.setDate(new java.util.Date(1704106547000L));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 18, 11, 11);
        jPanel4.add(akhirCalendar, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 28, 0, 0);
        jPanel6.add(jPanel4, gridBagConstraints);

        jPanel1.add(jPanel6, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 822, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(PerhitunganHariFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PerhitunganHariFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PerhitunganHariFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PerhitunganHariFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PerhitunganHariFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JCalendar akhirCalendar;
    private com.toedter.calendar.JCalendar awalCalendar;
    private javax.swing.JButton btnHitungHari;
    private javax.swing.JButton btnHitungSelisih;
    private javax.swing.JComboBox<String> cbBulan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSpinner spinTahun;
    private com.toedter.calendar.JCalendar utamaCalendar;
    // End of variables declaration//GEN-END:variables
}
