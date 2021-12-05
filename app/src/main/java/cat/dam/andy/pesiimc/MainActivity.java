package cat.dam.andy.pesiimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button aplicar;
    EditText etKg;
    EditText etM;

    public static double resultatFinal;
    public static double pesFinal;
    public static double alçadaFinal;



    public Double calcul(Double etKg, Double etM){

        Double operacio = 0.0;

        operacio = etKg / (etM * etM);

        double resultat = Math.round(operacio * 100.0) / 100.0;

        return  resultat;
    }

    /**
     * Funcio on es dura a terme tot el process
     * @param etKg - Pes en Kg introduït per el usuari
     * @param etM - Altura en Metres entrada per el usuari
     */
    public void Funcionament(Double etKg, Double etM){

        Double resultat = calcul(etKg, etM);

        resultatFinal = resultat;
        pesFinal = etKg;
        alçadaFinal = etM;

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aplicar = (Button) findViewById(R.id.buttoCalcul);
        etM = (EditText)  findViewById(R.id.et_M);
        etKg = (EditText) findViewById(R.id.et_Kg);


        aplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double pes = 0;
                double altura = 0;

                pes = Double.parseDouble(String.valueOf(etKg.getText()));
                altura = Double.parseDouble(String.valueOf(etM.getText()));

                startActivity(new Intent(MainActivity.this, ActivityResultat.class));
                Funcionament(pes, altura);
            }
        });

    }


}