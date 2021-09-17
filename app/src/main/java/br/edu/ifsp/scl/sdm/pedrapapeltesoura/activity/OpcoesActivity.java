package br.edu.ifsp.scl.sdm.pedrapapeltesoura.activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import br.edu.ifsp.scl.sdm.pedrapapeltesoura.databinding.ActivityOpcoesBinding;

public class OpcoesActivity extends AppCompatActivity  {

    /**
     * Referências para objetos de UI no layout
     */
    private ActivityOpcoesBinding activityOpcoesBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityOpcoesBinding = ActivityOpcoesBinding.inflate(getLayoutInflater());
        setContentView(activityOpcoesBinding.getRoot());
    }

}
