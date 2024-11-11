# Tugas 4: Aplikasi Perhitungan Hari

### Pembuat
- **Nama**: Ferdhyan Dwi Rangga Saputra
- **NPM**: 2210010171

---

## 1. Deskripsi Program
Aplikasi ini memungkinkan pengguna untuk:
- Memilih bulan dan memasukkan tahun menggunakan **JComboBox** dan **JSpinner**.
- Menggunakan **JCalendar** untuk memilih bulan dan tahun secara langsung.
- Menghitung jumlah hari dalam bulan tertentu pada tahun yang dipilih.
- Menampilkan hasil perhitungan setelah tombol **Hitung Jumlah Hari** ditekan.

## 2. Komponen GUI
- **JFrame**: Window utama aplikasi.
- **JPanel**: Panel untuk menampung komponen.
- **JLabel**: Label untuk menunjukkan informasi jumlah hari, hari pertama, dan hari terakhir.
- **JComboBox**: Dropdown untuk memilih bulan.
- **JSpinner**: Input angka untuk memilih tahun.
- **JButton**: Tombol untuk memulai perhitungan jumlah hari.
- **JCalendar**: Kalender untuk memilih tanggal secara interaktif.

## 3. Logika Program
- Menggunakan API **LocalDate** untuk menghitung jumlah hari dalam bulan dan tahun yang dipilih.
- Menghitung apakah tahun yang dipilih adalah tahun kabisat.
- Mendapatkan hari pertama dan hari terakhir dari bulan yang dipilih, serta menampilkannya dalam bahasa Indonesia.

## 4. Events
Menggunakan **ActionListener** dan **ChangeListener** untuk menangani interaksi pengguna:

### A. Tombol Hitung
Menghitung jumlah hari dalam bulan yang dipilih, hari pertama, hari terakhir, dan menampilkan informasi tambahan jika tahun adalah tahun kabisat.

```java
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
```  

### B. ChangeListener pada JSpinner
Mendeteksi perubahan tahun untuk memperbarui kalender secara dinamis.

```java
spinTahun.addChangeListener(e -> updateCalendar());
```

## 5. Variasi
Aplikasi ini memiliki variasi tambahan berikut:

### A. Hari Pertama dan Hari Terakhir
Menampilkan informasi hari pertama dan hari terakhir dari bulan yang dipilih dalam bahasa Indonesia.

```java
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
```

### B. Menghitung Selisih Hari antara Dua Tanggal
Menambahkan fitur untuk menghitung selisih hari antara dua tanggal yang dipilih di **JCalendar**.

```java
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

```

## 6. Tampilan Aplikasi Saat di Run

![image](https://github.com/user-attachments/assets/e616f7c6-16de-4b26-89c8-4fb5712849b4)

## 7. Indikator Penilaian

| No  | Komponen          | Persentase |
| :-: | ------------------ | :--------: |
|  1  | Komponen GUI      |     10%    |
|  2  | Logika Program    |     20%    |
|  3  | Events            |     20%    |
|  4  | Kesesuaian UI     |     20%    |
|  5  | Memenuhi Variasi  |     30%    |
|     | **TOTAL**         |  **100%**  |

--- 
