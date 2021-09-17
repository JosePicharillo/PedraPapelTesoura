package br.edu.ifsp.scl.sdm.pedrapapeltesoura.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

import br.edu.ifsp.scl.sdm.pedrapapeltesoura.OpcaoDoisJogadores;
import br.edu.ifsp.scl.sdm.pedrapapeltesoura.OpcaoTresJogadores;
import br.edu.ifsp.scl.sdm.pedrapapeltesoura.Opcoes;
import br.edu.ifsp.scl.sdm.pedrapapeltesoura.R;
import br.edu.ifsp.scl.sdm.pedrapapeltesoura.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * Referências para objetos de UI no layout
     */
    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        exibirOpcoes();
        clickButtonSelect();
        mostrarOcultarCampos();
    }

    /**
     * Exibi ou oculta as opções
     */
    private void exibirOpcoes() {
        activityMainBinding.opcoesJogadores.setOnCheckedChangeListener((__, mostrarOpcoes) -> {
            activityMainBinding.selecinarOpcaoLl.setVisibility(mostrarOpcoes ? View.VISIBLE : View.GONE);
        });
    }

    /**
     * Menu Opções
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_opcoes, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.opt_opcoes) {
            Intent intent = new Intent(this, OpcoesActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Deixa os campos do computador 02 visíveis ou ocultos
     */
    private void mostrarOcultarCampos() {
        activityMainBinding.opTres.setOnCheckedChangeListener((__, dois) -> {
            activityMainBinding.labelJogadaComputador02.setVisibility(View.GONE);
            activityMainBinding.jogadaComputador02Img.setVisibility(View.GONE);
        });

        activityMainBinding.opDois.setOnCheckedChangeListener((__, tres) -> {
            activityMainBinding.labelJogadaComputador02.setVisibility(View.VISIBLE);
            activityMainBinding.jogadaComputador02Img.setVisibility(View.VISIBLE);
        });
    }


    /**
     * Referência dos botões criados no layout
     */
    private void clickButtonSelect() {
        activityMainBinding.pedraBT.setOnClickListener(this);
        activityMainBinding.papelBT.setOnClickListener(this);
        activityMainBinding.tesouraBT.setOnClickListener(this);
    }

    /**
     * Verifica qual botão foi selecionado
     */
    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        Opcoes jogada = Opcoes.NONE;
        switch (v.getId()) {
            case R.id.pedraBT:
                jogada = Opcoes.PEDRA;
                break;
            case R.id.papelBT:
                jogada = Opcoes.PAPEL;
                break;
            case R.id.tesouraBT:
                jogada = Opcoes.TESOURA;
            default:
                break;
        }

        jogadasComputador(jogada);
    }

    /**
     * Jogadas do computador 01 e/ou 02
     */
    private void jogadasComputador(Opcoes jogada) {

        OpcaoTresJogadores op3 = new OpcaoTresJogadores();
        OpcaoDoisJogadores op2 = new OpcaoDoisJogadores();
        StringBuilder resultadoSB = new StringBuilder();
        Random random = new Random(System.currentTimeMillis());

        //Opção com 3 Jogadores
        if (activityMainBinding.opTres.isChecked()) {
            int jogadaComputador01 = random.nextInt(3);
            int jogadaComputador02 = random.nextInt(3);

            resultadoSB = op3.verificaJogoTresJogadores(jogada, jogadaComputador01, jogadaComputador02);
            imageSelectComputador01(jogadaComputador01);
            imageSelectComputador02(jogadaComputador02);

            //Mensagem com os resultados
            activityMainBinding.resultado.setText(resultadoSB.toString());

        } else {
            //Opção com 2 jogadores
            int jogadaComputador01 = random.nextInt(3);
            resultadoSB = op2.verificaJogoDoisJogadores(jogada, jogadaComputador01);
            imageSelectComputador01(jogadaComputador01);

            //Mensagem com os resultados
            activityMainBinding.resultado.setText(resultadoSB.toString());
        }
    }

    /**
     * Setando a imagem da jogada do computador 01
     */
    public void imageSelectComputador01(int jogadaComputador01) {
        int imgJogadaPC = -1;

        switch (jogadaComputador01) {
            case 0:
                imgJogadaPC = R.mipmap.pedra;
                break;
            case 1:
                imgJogadaPC = R.mipmap.papel;
                break;
            case 2:
                imgJogadaPC = R.mipmap.tesoura;
                break;
            default:
                break;
        }
        activityMainBinding.jogadaComputador01Img.setImageResource(imgJogadaPC);
    }

    /**
     * Setando a imagem da jogada do computador 02
     */
    public void imageSelectComputador02(int jogadaComputador02) {
        int imgJogada02PC = -1;

        switch (jogadaComputador02) {
            case 0:
                imgJogada02PC = R.mipmap.pedra;
                break;
            case 1:
                imgJogada02PC = R.mipmap.papel;
                break;
            case 2:
                imgJogada02PC = R.mipmap.tesoura;
                break;
            default:
                break;
        }
        activityMainBinding.jogadaComputador02Img.setImageResource(imgJogada02PC);
    }

}