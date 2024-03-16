package com.example.dinaasitaquiz1;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etKodeBarang, etJumlahBarang, etNama;
    RadioGroup rgMembership;
    Button btnProses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etKodeBarang = findViewById(R.id.etKodeBarang);
        etJumlahBarang = findViewById(R.id.etJumlahBarang);
        etNama = findViewById(R.id.etNama);
        rgMembership = findViewById(R.id.rgMembership);
        btnProses = findViewById(R.id.btnProses);

        btnProses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungTotalBayar();
            }
        });
    }

    private void hitungTotalBayar() {
        String kodeBarang = etKodeBarang.getText().toString();
        int jumlahBarang;
        String nama = etNama.getText().toString();

        try {
            jumlahBarang = Integer.parseInt(etJumlahBarang.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(MainActivity.this, "Masukkan jumlah barang dengan benar", Toast.LENGTH_SHORT).show();
            return;
        }


        double hargaBarang;
        String namaBarang;

        switch (kodeBarang) {
            case "AAE":
                namaBarang = "Acer Aspire E14";
                hargaBarang = 8676981;
                break;
            case "LV3":
                namaBarang = "Lenovo V14 Gen 3";
                hargaBarang = 6666666;
                break;
            case "AA5":
                namaBarang = "Acer Aspire 5";
                hargaBarang = 9999999;
                break;
            default:
                Toast.makeText(MainActivity.this, "Kode barang tidak valid", Toast.LENGTH_SHORT).show();
                return;
        }

        // Mendapatkan harga barang berdasarkan kode barang
        double totalBayar = hargaBarang * jumlahBarang;

        int selectedId = rgMembership.getCheckedRadioButtonId();
        double discountMember = 0;
        String membership = null;

        if (selectedId != -1) {
            RadioButton radioButton = findViewById(selectedId);
            membership = radioButton.getText().toString();
            switch (membership) {
                case "Gold":
                    discountMember = totalBayar * 0.1;
                    break;
                case "Silver":
                    discountMember = totalBayar * 0.05;
                    break;
                case "Biasa":
                    discountMember = totalBayar * 0.02;
                    break;
            }
        }


        // Diskon berdasarkan ketentuan membership
        double diskon = totalBayar * discountMember;

        // Diskon tambahan jika total bayar di atas 10 juta
        if (totalBayar > 10000000) {
            diskon += 100000;
        }

        totalBayar -= diskon;

        Intent intent = new Intent(MainActivity.this, detail.class);
        intent.putExtra("nama", nama);
        intent.putExtra("tipe_member", membership);
        intent.putExtra("kode_barang", kodeBarang);
        intent.putExtra("nama_barang", namaBarang);
        intent.putExtra("harga_barang", hargaBarang);
        intent.putExtra("jumlah_barang", jumlahBarang);
        intent.putExtra("total_harga", totalBayar);
        intent.putExtra("discount_harga", diskon);
        intent.putExtra("discount_member", discountMember);
        intent.putExtra("jumlah_bayar", totalBayar); // Jumlah bayar sama dengan total bayar
        startActivity(intent);
    }}
