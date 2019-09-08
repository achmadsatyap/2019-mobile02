package id.ac.polinema.tebakangka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

	//  TODO: deklarasikan variabel di sini
	private int random;
	private  EditText numberInput;
	private Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// TODO: bind layout di sini
		numberInput = findViewById(R.id.number_input);
//		button = findViewById(R.id.guess_button);
	}

	// TODO: generate angka random di sini
	private void initRandomNumber() {
		Random random = new Random();
		int rand = random.nextInt(101 );
		this.random = rand;
	}

	public void handleGuess(View view) {
		// TODO: Tambahkan logika untuk melakukan pengecekan angka
		numberInput = findViewById(R.id.number_input);
		int in = Integer.parseInt(String.valueOf(numberInput.getText()));

			if (in > random){
				Toast.makeText(this,"tebakan anda terlalu beasr", Toast.LENGTH_SHORT).show();
			}
			else if (in < random){
				Toast.makeText(this, "tebakan anda terlalu kecil", Toast.LENGTH_SHORT).show();
			}
			else if (in == random){
				Toast.makeText(this, "Tebakan anda benar", Toast.LENGTH_SHORT).show();
				Button button = (Button) findViewById(R.id.guess_button);
				button.setEnabled(false);
			}
	}

	public void handleReset(View view) {
		// TODO: Reset tampilan
		numberInput.setText("");
		button.setEnabled(true);
		initRandomNumber();
	}
}
