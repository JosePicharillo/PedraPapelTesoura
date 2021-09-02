package br.edu.ifsp.scl.sdm.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

public class OpcaoTresJogadores extends AppCompatActivity {

    /**
     * Verifica as opções escolhidas pela computador
     */
    public StringBuilder verificaJogoTresJogadores(Opcoes jogada, int jogadaComputador01, int jogadaComputador02) {
        Opcoes opComputador01 = Opcoes.NONE;
        Opcoes opComputador02 = Opcoes.NONE;

        switch (jogadaComputador01) {
            case 0:
                opComputador01 = Opcoes.PEDRA;
                break;
            case 1:
                opComputador01 = Opcoes.PAPEL;
                break;
            case 2:
                opComputador01 = Opcoes.TESOURA;
            default:
                break;
        }

        switch (jogadaComputador02) {
            case 0:
                opComputador02 = Opcoes.PEDRA;
                break;
            case 1:
                opComputador02 = Opcoes.PAPEL;
                break;
            case 2:
                opComputador02 = Opcoes.TESOURA;
            default:
                break;
        }

        return mensagemJogo(jogada, opComputador01, opComputador02);
    }

    /**
     * Mensagens das jogadas e mostra os resultados
     */
    private StringBuilder mensagemJogo(Opcoes jogada, Opcoes jogadaComputador01, Opcoes jogadaComputador02) {

        StringBuilder resultadoSB = new StringBuilder();
        CondicaoPedra pedra = new CondicaoPedra();
        CondicaoPapel papel = new CondicaoPapel();
        CondicaoTesoura tesoura = new CondicaoTesoura();
        String resposta = "";

        resultadoSB.append("Sua Jogada: ");
        resultadoSB.append(jogada);
        resultadoSB.append('\n');
        resultadoSB.append("Jogada Computador 01: ");
        resultadoSB.append(jogadaComputador01);
        resultadoSB.append('\n');
        resultadoSB.append("Jogada Computador 02: ");
        resultadoSB.append(jogadaComputador02);
        resultadoSB.append('\n');
        resultadoSB.append('\n');

        switch (jogada) {
            case PEDRA:
                resposta = pedra.calculoCondicaoPedra(jogadaComputador01, jogadaComputador02);
                break;
            case PAPEL:
                resposta = papel.calculoCondicaoPapelTresJogadores(jogadaComputador01, jogadaComputador02);
                break;
            case TESOURA:
                resposta = tesoura.calculoCondicaoTesoura(jogadaComputador01, jogadaComputador02);
                break;
            default:
                break;
        }

        resultadoSB.append(resposta);

        return resultadoSB;
    }

}
