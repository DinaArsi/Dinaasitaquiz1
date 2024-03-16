package com.example.dinaasitaquiz1;

        import android.os.Bundle;
        import android.widget.TextView;

        import androidx.annotation.Nullable;
        import androidx.appcompat.app.AppCompatActivity;

public class detail extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Get intent extras
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String nama = extras.getString("nama");
            String tipeMember = extras.getString("tipe_member"); // Perbaikan disini
            String kodeBarang = extras.getString("kode_barang"); // Perbaikan disini
            String namaBarang = extras.getString("nama_barang");
            double hargaBarang = extras.getDouble("harga_barang"); // Perbaikan disini
            int jumlahBarang = extras.getInt("jumlah_barang"); // Perbaikan disini
            double totalHarga = extras.getDouble("total_harga"); // Perbaikan disini
            double discountHarga = extras.getDouble("discount_harga"); // Perbaikan disini
            double discountMember = extras.getDouble("discount_member"); // Perbaikan disini
            double jumlahBayar = extras.getDouble("jumlah_bayar"); // Perbaikan disini

            // Set TextViews with the received data
            TextView textNama = findViewById(R.id.text_nama);
            TextView textTipeMember = findViewById(R.id.text_tipe_member);
            TextView textKodeBarang = findViewById(R.id.text_kode_barang);
            TextView textNamaBarang = findViewById(R.id.text_nama_barang);
            TextView textHargaBarang = findViewById(R.id.text_harga_barang);
            TextView textJumlahBarang = findViewById(R.id.text_jumlah_barang);
            TextView textTotalHarga = findViewById(R.id.text_total_harga);
            TextView textDiscountHarga = findViewById(R.id.text_discount_harga);
            TextView textDiscountMember = findViewById(R.id.text_discount_member);
            TextView textJumlahBayar = findViewById(R.id.text_jumlah_bayar);

            textNama.setText("Welcome " + nama);
            textTipeMember.setText("Tipe Member: " + tipeMember);
            textKodeBarang.setText("Kode Barang: " + kodeBarang);
            textNamaBarang.setText("Nama Barang: " + namaBarang);
            textHargaBarang.setText("Harga Barang: " + hargaBarang);
            textJumlahBarang.setText("Jumlah Barang: " + jumlahBarang);
            textTotalHarga.setText("Total Harga: " + totalHarga);
            textDiscountHarga.setText("Discount Harga: " + discountHarga);
            textDiscountMember.setText("Discount Member: " + discountMember);
            textJumlahBayar.setText("Jumlah Bayar: " + jumlahBayar);
        }
    }
}