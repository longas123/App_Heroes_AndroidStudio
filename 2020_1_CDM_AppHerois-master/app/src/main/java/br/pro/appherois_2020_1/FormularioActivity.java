package br.pro.appherois_2020_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormularioActivity extends AppCompatActivity {

    private EditText etNome, etGrupo;
    private Button btnSalvar;
    private String acao;
    private Heroi heroi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        etNome = (EditText) findViewById(R.id.etNome);
        etGrupo = findViewById(R.id.etGrupo);
        btnSalvar = findViewById(R.id.btnSalvar);

        acao = getIntent().getStringExtra("acao");

        if( acao.equals("editar")){
            carregarFormulario();
        }

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar();
            }
        });

    }

    private void salvar(){
        if( acao.equals("inserir")){
            heroi = new Heroi();
        }
        String nome = etNome.getText().toString();
        if( nome.isEmpty() ){
            Toast.makeText(this, "Você deve informar o nome do heroi!", Toast.LENGTH_LONG ).show();
        }else {
            heroi.setNome( nome );
            heroi.setGrupo( etGrupo.getText().toString() );

            if( acao.equals("inserir")){
                HeroiDAO.inserir( this, heroi );
                limpar();
            }else {
                HeroiDAO.editar( this, heroi);
                finish();
            }
        }
    }

    private void carregarFormulario(){
        int idHeroi =  getIntent().getIntExtra("idHeroi", 0) ;
        heroi = HeroiDAO.getHeroiById( this, idHeroi);
        etNome.setText( heroi.getNome() );
        etGrupo.setText( heroi.getGrupo() );

    }

    private void limpar(){
        heroi = null;
        etNome.setText("");
        etGrupo.setText("");
    }

}
