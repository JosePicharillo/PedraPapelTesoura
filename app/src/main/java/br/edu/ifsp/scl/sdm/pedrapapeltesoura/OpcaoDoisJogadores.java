package br.edu.ifsp.scl.sdm.pedrapapeltesoura;

public class OpcaoDoisJogadores {

    /**
     * Verifica as opções escolhidas pela computador
     */
    public StringBuilder verificaJogoDoisJogadores(Opcoes jogada, int jogadaComputador01) {
        Opcoes opComputador01 = Opcoes.NONE;

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

        return mensagemJogo(jogada, opComputador01);
    }

    /**
     * Mensagens das jogadas e mostra os resultados
     */
    private StringBuilder mensagemJogo(Opcoes jogada, Opcoes jogadaComputador01) {

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
        resultadoSB.append('\n');

        switch (jogada) {
            case PEDRA:
                resposta = pedra.calculoCondicaoPedraDoisJogadores(jogadaComputador01);
                break;
            case PAPEL:
                resposta = papel.calculoCondicaoPapelDoisJogadores(jogadaComputador01);
                break;
            case TESOURA:
                resposta = tesoura.calculoCondicaoTesouraDoisJogadores(jogadaComputador01);
                break;
            default:
                break;
        }

        resultadoSB.append(resposta);

        return resultadoSB;
    }

}
