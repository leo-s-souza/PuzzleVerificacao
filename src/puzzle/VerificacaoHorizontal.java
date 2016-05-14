/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Leonardo
 */
public class VerificacaoHorizontal {

    int resposta[] = new int[9];

    int countMov, loop;

    public void setParametros(int[] resposta) {
        this.resposta = resposta;
        this.primeiraPos();
    }

    ArrayList<int[]> verificados = new ArrayList<>();
    HashMap<Integer, int[]> percorridos = new HashMap<>();

    ArrayList<int[]> linhaAtual = new ArrayList<>();
    ArrayList<int[]> linhaAnterior = new ArrayList<>();

    private void primeiraPos() {
        int[] linha = new int[10];
        linha[0] = 1;
        linha[1] = 2;
        linha[2] = 3;
        linha[3] = 4;
        linha[4] = 5;
        linha[5] = 6;
        linha[6] = 7;
        linha[7] = 8;
        linha[8] = 0;
//        System.out.println("___________________________________________________");
//        for (int a : atual) {
//            System.out.print(a);
//        }
        while (!defineFilhos()) {
            System.out.println(this.loop);
//            for (int s : atual) {
//                System.out.print(s);
//            }
//            System.out.println("");
        }

    }

    private boolean defineFilhos() {

        for (int[] posLinha : linhaAnterior) {

            ArrayList<int[]> filhos = new ArrayList<>();
            HashMap<Integer, int[]> filhosHash = new HashMap<>();

            int posicaoVazia = 0;
            for (int at : posLinha) {
                if (at == 0) {
                    break;
                } else {
                    posicaoVazia++;
                }
            }
            if (posicaoVazia == 4) {
                filhosHash.put(1, montaNovoFilho(posicaoVazia, 1, posLinha));
                filhosHash.put(2, montaNovoFilho(posicaoVazia, 3, posLinha));
                filhosHash.put(3, montaNovoFilho(posicaoVazia, 5, posLinha));
                filhosHash.put(4, montaNovoFilho(posicaoVazia, 7, posLinha));
            } else if (posicaoVazia == 0) {
                filhosHash.put(1, montaNovoFilho(posicaoVazia, 1, posLinha));
                filhosHash.put(2, montaNovoFilho(posicaoVazia, 3, posLinha));
            } else if (posicaoVazia == 2) {
                filhosHash.put(1, montaNovoFilho(posicaoVazia, 1, posLinha));
                filhosHash.put(2, montaNovoFilho(posicaoVazia, 5, posLinha));
            } else if (posicaoVazia == 6) {
                filhosHash.put(1, montaNovoFilho(posicaoVazia, 3, posLinha));
                filhosHash.put(2, montaNovoFilho(posicaoVazia, 7, posLinha));
            } else if (posicaoVazia == 8) {
                filhosHash.put(1, montaNovoFilho(posicaoVazia, 5, posLinha));
                filhosHash.put(2, montaNovoFilho(posicaoVazia, 7, posLinha));
            } else if (posicaoVazia == 1) {
                filhosHash.put(1, montaNovoFilho(posicaoVazia, 0, posLinha));
                filhosHash.put(2, montaNovoFilho(posicaoVazia, 2, posLinha));
                filhosHash.put(3, montaNovoFilho(posicaoVazia, 4, posLinha));
            } else if (posicaoVazia == 3) {
                filhosHash.put(1, montaNovoFilho(posicaoVazia, 0, posLinha));
                filhosHash.put(2, montaNovoFilho(posicaoVazia, 4, posLinha));
                filhosHash.put(3, montaNovoFilho(posicaoVazia, 6, posLinha));
            } else if (posicaoVazia == 5) {
                filhosHash.put(1, montaNovoFilho(posicaoVazia, 2, posLinha));
                filhosHash.put(2, montaNovoFilho(posicaoVazia, 4, posLinha));
                filhosHash.put(3, montaNovoFilho(posicaoVazia, 8, posLinha));
            } else if (posicaoVazia == 7) {
                filhosHash.put(1, montaNovoFilho(posicaoVazia, 4, posLinha));
                filhosHash.put(2, montaNovoFilho(posicaoVazia, 6, posLinha));
                filhosHash.put(3, montaNovoFilho(posicaoVazia, 7, posLinha));
            }

            int contador = 0;
            int[] verRetirar = new int[4];
            for (Map.Entry<Integer, int[]> entrySet : filhosHash.entrySet()) {
                Integer key = entrySet.getKey();
                int[] value = entrySet.getValue();

                if (!verificaExistencia(value)) {
                    contador++;
                    verRetirar[contador] = key;
                }
            }

            for (int g : verRetirar) {
                filhosHash.remove(g);
            }

            for (Map.Entry<Integer, int[]> entrySet : filhosHash.entrySet()) {
                Integer key = entrySet.getKey();
                int[] value = entrySet.getValue();
                filhos.add(value);
            }

        }

        return true;

    }

    private int[] montaNovoFilho(int posVazia, int posTroca, int[] filho) {

        int[] resultado = filho.clone();

        resultado[posVazia] = resultado[posTroca];
        resultado[posTroca] = 0;

        return resultado;
    }

    private boolean verificaExistencia(int[] filho) {
        boolean dif = false;
        for (int[] value : verificados) {

            for (int i = 0; i < 9; i++) {
                if (value[i] != filho[i]) {
                    dif = true;
                    break;
                }
            }
            if (!dif) {
                verificados.add(filho);
                return true;
            }
            dif = false;
        }
        return dif;
    }

    private boolean verificaResposta(int[] filho) {
        for (int i = 0; i > 9; i++) {
            if (filho[i] != resposta[i]) {
                countMov++;
                for (int j = 0; j > 10; j++) {
                    if (j != 9) {
//                        percorridos
                    }
                }
                return false;
            }
        }
        for (int j = 0; j > 10; j++) {
            if (j != 9) {

            }
        }
        return true;
    }

}
