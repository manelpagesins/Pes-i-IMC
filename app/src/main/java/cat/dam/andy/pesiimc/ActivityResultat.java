package cat.dam.andy.pesiimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ActivityResultat extends AppCompatActivity {

    TextView TextTitol;
    TextView TextIMC;
    TextView TextGrup;

    static Double resultat = MainActivity.resultatFinal;
    static Double pes =  MainActivity.pesFinal;
    static Double alçada = MainActivity.alçadaFinal;


    public static String GrupPes(){

        String paraulaGrup = "";

    /*
        IMC Classificació
        <18,5 Pes insuficient
        18,5-24,9 Pes normal
        25-26,9 Sobrepès grau I
        27-29,9 Sobrepès grau II (preobesitat)
        30-34,9 Obesitat de tipus I
        35-39,9 Obesitat de tipus II
        40-49,9 Obesitat de tipus III (mòrbida)
        >50 Obesitat de tipus IV (extrema)
      */

        if(resultat < 18.5){

            paraulaGrup = "Pes insuficient";

        }else if(resultat >= 18.5 && resultat <= 24.9){

            paraulaGrup = "Pes normal";

        }
        else if(resultat >= 25 && resultat <= 26.9){

            paraulaGrup = "Sobrepès grau I";

        }
        else if(resultat >= 27 && resultat <= 29.9){

            paraulaGrup = "Sobrepès grau II (preobesitat)";

        }
        else if(resultat >= 30 && resultat <= 34.9){

            paraulaGrup = "Obesitat de tipus I";

        }
        else if(resultat >= 35 && resultat <= 39.9){

            paraulaGrup = "Obesitat de tipus II";

        }
        else if(resultat >= 40 && resultat <= 49.9){

            paraulaGrup = "Obesitat de tipus III (mòrbida)";

        }
        else if(resultat >= 50){

            paraulaGrup = "Obesitat de tipus IV (extrema)";

        }

        return paraulaGrup;
    }

    public static String ConversioString(Double variable){

        String variableConvertida = Double.toString(variable);

        return variableConvertida;

    }

    public static void ConfiguracioTextViews(TextView TextTitol, TextView TextIMC, TextView TextGrup){

        String paraulaClau = GrupPes();

        String pesConvertit = ConversioString(pes);
        String pesAltura = ConversioString(alçada);
        String pesIMC = ConversioString(resultat);

        String titolText = "Per un pes de " + pesConvertit + " quilograms i una alçada de " + pesAltura + "metres,";
        String IMCText = "el seu IMC és: " + pesIMC;
        String GrupText = "Vostè es troba en el grup: " + paraulaClau ;

        TextTitol.setText(titolText);
        TextIMC.setText(IMCText);
        TextGrup.setText(GrupText);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat);

    TextTitol = (TextView) findViewById(R.id.TextTitol);
    TextIMC = (TextView) findViewById(R.id.TextIMC);
    TextGrup = (TextView) findViewById(R.id.TextGrup);

    ConfiguracioTextViews(TextTitol, TextIMC, TextGrup);

    }
}