package chuque.com.notes;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by rafael on 07/11/17.
 */

public class NoteActivity extends AppCompatActivity {

    //nunca usar atributos estáticos, pois quase sempre dá merda.
    //esse atributo pode ser acessado de qualquer acttivity e de qualquer lugar do sistema, pois é estática.
    //o sistema android, quando fica sem memória, limpa todas as variaveis static, e isso pode ser perigoso
    static ArrayList<Note> noteList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);//seta um layout para essa activity

        final EditText edtTextTitle = (EditText) findViewById(R.id.edt_title);
        final EditText edtTextDescription = (EditText) findViewById(R.id.edt_description);

        Button btnSalvar = (Button) findViewById(R.id.btn_salvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Note note = new Note();
                String title = edtTextTitle.getText().toString();
                String description = edtTextDescription.getText().toString();

                note.setTitle(title);
                note.setDescription(description);

                Toast.makeText(NoteActivity.this, note.getTitle() + " salvo", Toast.LENGTH_SHORT).show();

                noteList.add(note);

                //finaliza a activity
                finish();
            }
        });
    }
}
