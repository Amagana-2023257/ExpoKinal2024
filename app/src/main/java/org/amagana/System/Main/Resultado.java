package org.amagana.System.Main;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class Resultado extends AppCompatActivity {

    TextView carreraTextView;
    TextView gradoTextView;
    TextView alumnoTextView;
    TextView proyectoTextView;

    ImageView imageView;

    // Agrega una referencia a Firestore
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    // Agrega una referencia a Firebase Storage
    FirebaseStorage storage = FirebaseStorage.getInstance();

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

        // Llama al método para obtener los datos de Firestore
        getProjectData(scanResult);
    }

    private void getProjectData(String projectId) {
        db.collection("proyectos").document(projectId)
                .get()
                .addOnSuccessListener(documentSnapshot -> {

                    if (documentSnapshot.exists()) {
                        // Aquí puedes manejar los datos obtenidos de Firestore
                        carreraTextView.setText(documentSnapshot.getString("carrera"));
                        gradoTextView.setText(documentSnapshot.getString("grado"));
                        alumnoTextView.setText(documentSnapshot.getString("alumno"));
                        proyectoTextView.setText(documentSnapshot.getString("proyecto"));

                        switch(Integer.parseInt(projectId)){
                            case 1:
                                loadImage("compu.jpg");
                                break;
                            case 2:
                                loadImage("carro.jpg");
                                break;
                        }

                    } else {
                        Toast.makeText(this, "No era 1: ", Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(this, "Error al obtener los datos: " + e.getMessage(), Toast.LENGTH_LONG).show();
                });
    }

    private void loadImage(String imageName) {
        StorageReference storageRef = storage.getReference();
        StorageReference imageRef = storageRef.child(imageName);

        imageRef.getDownloadUrl().addOnSuccessListener(uri -> {
            Picasso.get().load(uri).into(imageView);
        }).addOnFailureListener(e -> {
            Toast.makeText(this, "Error al cargar la imagen: " + e.getMessage(), Toast.LENGTH_LONG).show();
        });
    }
}
