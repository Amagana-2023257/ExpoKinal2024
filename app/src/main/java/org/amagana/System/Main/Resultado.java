package org.amagana.System.Main;

import android.os.Bundle;

import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Resultado extends AppCompatActivity {

    TextView carreraTextView;
    TextView gradoTextView;
    TextView alumnoTextView;
    TextView proyectoTextView;

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        // Obtener referencias de TextView e ImageView
        carreraTextView = findViewById(R.id.carrera);
        gradoTextView = findViewById(R.id.grado);
        alumnoTextView = findViewById(R.id.alumno);
        proyectoTextView = findViewById(R.id.Proyecto);
        imageView = findViewById(R.id.imageView2);

        // Obtener el valor enviado desde MainActivity
        String scanResult = getIntent().getStringExtra("SCAN");

        if (scanResult.equals("1")) {
            carreraTextView.setText("Informatica");
            gradoTextView.setText("5to Perito");
            alumnoTextView.setText("Angel Magaña");
            proyectoTextView.setText("AppExpoKinal");
            imageView.setImageResource(R.drawable.kinal);
        } else if (scanResult.equals("2")) {
            carreraTextView.setText("Mecanica");
            gradoTextView.setText("4to Perito");
            alumnoTextView.setText("Alumno x");
            proyectoTextView.setText("Expo");
            imageView.setImageResource(R.drawable.kinal1);
        } else {
            // Aquí puedes manejar otros casos según sea necesario
        }
    }
}
