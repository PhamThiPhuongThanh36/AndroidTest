package com.example.chisobmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edtHoVaTen, edtChieuCao, edtCanNang, edtBMI;
    Button btnTinhBMI;
    TextView txvKetQua;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addControl();
    }

    private void addControl() {
        edtHoVaTen = (EditText) findViewById(R.id.edtHoVaTen);
        edtChieuCao = (EditText) findViewById(R.id.edtChieuCao);
        edtCanNang = (EditText) findViewById(R.id.edtCanNang);
        edtBMI = (EditText) findViewById(R.id.edtBMI);
        btnTinhBMI = (Button) findViewById(R.id.bthTinhBMI);
        txvKetQua = (TextView) findViewById(R.id.txvKetQua);
    }

    public void TinhBMI(View view) {
        float chieuCao = Float.parseFloat(edtChieuCao.getText().toString());
        float canNang = Float.parseFloat(edtCanNang.getText().toString());
        float BMI = canNang / (chieuCao * chieuCao);
        edtBMI.setText(""+BMI);
        if (BMI < 18){
            txvKetQua.setText("Người gầy");
        } else if (BMI <= 24.9){
            txvKetQua.setText("Người bình thường");
        } else if (BMI <= 29.9) {
            txvKetQua.setText("Người béo phì độ I");
        } else if (BMI <= 34.9) {
            txvKetQua.setText("Người béo phì độ II");
        } else {
            txvKetQua.setText("Người bép phì độ III");
        }
    }
}


