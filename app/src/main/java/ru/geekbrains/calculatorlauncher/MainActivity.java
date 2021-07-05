package ru.geekbrains.calculatorlauncher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn).setOnClickListener(v -> {
            EditText et = findViewById(R.id.edit_number);
            Uri uri = Uri.parse("calculator_launch://set_number");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.putExtra("calculator_launch", et.getText().toString());
            ActivityInfo activityInfo = intent.resolveActivityInfo(getPackageManager(), intent.getFlags());
            if (activityInfo != null) {
                startActivity(intent);
            } else {
                Toast.makeText(this, "Calculator not found!",Toast.LENGTH_LONG).show();
            }
        });

    }
}