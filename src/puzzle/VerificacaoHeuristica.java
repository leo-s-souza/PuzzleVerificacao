/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Leonardo
 */
public class VerificacaoHeuristica {

    public void setParametros(int[] resposta) {
        this.resposta = resposta;
        this.primeiroAtual();
    }

    int resposta[] = new int[9];
    int atual[] = new int[9];
    int antigo[] = new int[9];
    int loop = 0;

    ArrayList<int[]> verificados = new ArrayList<>();
    ArrayList<int[]> inutilizaveis = new ArrayList<>();

    HashMap<Integer, int[]> passos = new HashMap<>();

    private void primeiroAtual() {
        atual[0] = 1;
        atual[1] = 2;
        atual[2] = 3;
        atual[3] = 0;
        atual[4] = 4;
        atual[5] = 5;
        atual[6] = 6;
        atual[7] = 7;
        atual[8] = 8;
        this.passos.put(passos.size() + 1, atual);
        this.verificados.add(atual);

        while (!defineFilhos()) {
////            System.out.println(this.loop);
        }

        for (Map.Entry<Integer, int[]> entrySet : passos.entrySet()) {
            Integer key = entrySet.getKey();
            int[] value = entrySet.getValue();
            System.out.print("[");
            for (int w : value) {
                System.out.print(w);
            }
            System.out.println("]");
        }

    }

    private int verPosVazia(int[] pai) {
        int posicaoVazia = 0;
        for (int at : atual) {
            if (at == 0) {
                break;
            } else {
                posicaoVazia++;
            }
        }
        return posicaoVazia;
    }

    private boolean defineFilhos() {

        ArrayList<int[]> filhos = new ArrayList<>();
        HashMap<Integer, int[]> filhosHash = new HashMap<>();

        int posicaoVazia = verPosVazia(atual);
        filhos = (defineFilhos(posicaoVazia, atual));

        for (int[] filho : filhos) {
            verificados.add(filho.clone());
        }
        if (!verificaH1H2(filhos)) {
            this.loop++;
        } else {
            return true;
        }

        return false;
    }

    private ArrayList<int[]> defineFilhos(int posicaoVazia, int[] pai) {
        ArrayList<int[]> filhos = new ArrayList<>();

        if (posicaoVazia == 4) {
            if (!verificaUtilizados(montaNovoFilho(posicaoVazia, 1, pai))) {
                if (!verificaInutilizaveis(montaNovoFilho(posicaoVazia, 1, pai))) {
                    filhos.add(montaNovoFilho(posicaoVazia, 1, pai));
                }
            }
            if (!verificaUtilizados(montaNovoFilho(posicaoVazia, 3, pai))) {
                if (!verificaInutilizaveis(montaNovoFilho(posicaoVazia, 3, pai))) {
                    filhos.add(montaNovoFilho(posicaoVazia, 3, pai));
                }
            }
            if (!verificaUtilizados(montaNovoFilho(posicaoVazia, 5, pai))) {
                if (!verificaInutilizaveis(montaNovoFilho(posicaoVazia, 5, pai))) {
                    filhos.add(montaNovoFilho(posicaoVazia, 5, pai));
                }
            }
            if (!verificaUtilizados(montaNovoFilho(posicaoVazia, 7, pai))) {
                if (!verificaInutilizaveis(montaNovoFilho(posicaoVazia, 7, pai))) {
                    filhos.add(montaNovoFilho(posicaoVazia, 7, pai));
                }
            }
        } else if (posicaoVazia == 0) {
            if (!verificaUtilizados(montaNovoFilho(posicaoVazia, 1, pai))) {
                if (!verificaInutilizaveis(montaNovoFilho(posicaoVazia, 1, pai))) {
                    filhos.add(montaNovoFilho(posicaoVazia, 1, pai));
                }
            }
            if (!verificaUtilizados(montaNovoFilho(posicaoVazia, 3, pai))) {
                if (!verificaInutilizaveis(montaNovoFilho(posicaoVazia, 3, pai))) {
                    filhos.add(montaNovoFilho(posicaoVazia, 3, pai));
                }
            }
        } else if (posicaoVazia == 2) {
            if (!verificaUtilizados(montaNovoFilho(posicaoVazia, 1, pai))) {
                if (!verificaInutilizaveis(montaNovoFilho(posicaoVazia, 1, pai))) {
                    filhos.add(montaNovoFilho(posicaoVazia, 1, pai));

                }

            }
            if (!verificaUtilizados(montaNovoFilho(posicaoVazia, 5, pai))) {
                if (!verificaInutilizaveis(montaNovoFilho(posicaoVazia, 5, pai))) {
                    filhos.add(montaNovoFilho(posicaoVazia, 5, pai));

                }
            }
        } else if (posicaoVazia == 6) {
            if (!verificaUtilizados(montaNovoFilho(posicaoVazia, 3, pai))) {
                if (!verificaInutilizaveis(montaNovoFilho(posicaoVazia, 3, pai))) {
                    filhos.add(montaNovoFilho(posicaoVazia, 3, pai));

                }
            }
            if (!verificaUtilizados(montaNovoFilho(posicaoVazia, 7, pai))) {
                if (!verificaInutilizaveis(montaNovoFilho(posicaoVazia, 7, pai))) {
                    filhos.add(montaNovoFilho(posicaoVazia, 7, pai));

                }
            }
        } else if (posicaoVazia == 8) {
            if (!verificaUtilizados(montaNovoFilho(posicaoVazia, 5, pai))) {
                if (!verificaInutilizaveis(montaNovoFilho(posicaoVazia, 5, pai))) {
                    filhos.add(montaNovoFilho(posicaoVazia, 5, pai));

                }
            }
            if (!verificaUtilizados(montaNovoFilho(posicaoVazia, 7, pai))) {
                if (!verificaInutilizaveis(montaNovoFilho(posicaoVazia, 7, pai))) {
                    filhos.add(montaNovoFilho(posicaoVazia, 7, pai));

                }
            }
        } else if (posicaoVazia == 1) {
            if (!verificaUtilizados(montaNovoFilho(posicaoVazia, 0, pai))) {
                if (!verificaInutilizaveis(montaNovoFilho(posicaoVazia, 0, pai))) {
                    filhos.add(montaNovoFilho(posicaoVazia, 0, pai));

                }

            }
            if (!verificaUtilizados(montaNovoFilho(posicaoVazia, 2, pai))) {
                if (!verificaInutilizaveis(montaNovoFilho(posicaoVazia, 2, pai))) {
                    filhos.add(montaNovoFilho(posicaoVazia, 2, pai));

                }
            }
            if (!verificaUtilizados(montaNovoFilho(posicaoVazia, 4, pai))) {
                if (!verificaInutilizaveis(montaNovoFilho(posicaoVazia, 4, pai))) {
                    filhos.add(montaNovoFilho(posicaoVazia, 4, pai));

                }
            }
        } else if (posicaoVazia == 3) {
            if (!verificaUtilizados(montaNovoFilho(posicaoVazia, 0, pai))) {
                if (!verificaInutilizaveis(montaNovoFilho(posicaoVazia, 0, pai))) {
                    filhos.add(montaNovoFilho(posicaoVazia, 0, pai));

                }
            }
            if (!verificaUtilizados(montaNovoFilho(posicaoVazia, 4, pai))) {
                if (!verificaInutilizaveis(montaNovoFilho(posicaoVazia, 4, pai))) {
                    filhos.add(montaNovoFilho(posicaoVazia, 4, pai));

                }
            }
            if (!verificaUtilizados(montaNovoFilho(posicaoVazia, 6, pai))) {
                if (!verificaInutilizaveis(montaNovoFilho(posicaoVazia, 6, pai))) {
                    filhos.add(montaNovoFilho(posicaoVazia, 6, pai));

                }
            }
        } else if (posicaoVazia == 5) {
            if (!verificaUtilizados(montaNovoFilho(posicaoVazia, 2, pai))) {
                if (!verificaInutilizaveis(montaNovoFilho(posicaoVazia, 2, pai))) {
                    filhos.add(montaNovoFilho(posicaoVazia, 2, pai));

                }
            }
            if (!verificaUtilizados(montaNovoFilho(posicaoVazia, 4, pai))) {
                if (!verificaInutilizaveis(montaNovoFilho(posicaoVazia, 4, pai))) {
                    filhos.add(montaNovoFilho(posicaoVazia, 4, pai));

                }
            }
            if (!verificaUtilizados(montaNovoFilho(posicaoVazia, 8, pai))) {
                if (!verificaInutilizaveis(montaNovoFilho(posicaoVazia, 8, pai))) {
                    filhos.add(montaNovoFilho(posicaoVazia, 8, pai));

                }
            }
        } else if (posicaoVazia == 7) {
            if (!verificaUtilizados(montaNovoFilho(posicaoVazia, 4, pai))) {
                if (!verificaInutilizaveis(montaNovoFilho(posicaoVazia, 4, pai))) {
                    filhos.add(montaNovoFilho(posicaoVazia, 4, pai));
                }
            }
            if (!verificaUtilizados(montaNovoFilho(posicaoVazia, 6, pai))) {
                if (!verificaInutilizaveis(montaNovoFilho(posicaoVazia, 6, pai))) {
                    filhos.add(montaNovoFilho(posicaoVazia, 6, pai));
                }
            }
            if (!verificaUtilizados(montaNovoFilho(posicaoVazia, 8, pai))) {
                if (!verificaInutilizaveis(montaNovoFilho(posicaoVazia, 8, pai))) {
                    filhos.add(montaNovoFilho(posicaoVazia, 8, pai));
                }
            }
        }

        for (int[] filho : filhos) {

        }
        return filhos;
    }

    private int[] montaNovoFilho(int posVazia, int posTroca, int[] pai) {

        int[] resultado = pai.clone();

        resultado[posVazia] = resultado[posTroca];
        resultado[posTroca] = 0;

        return resultado;
    }

    private boolean verificaH1H2(ArrayList<int[]> filhos) {

        int[] resultado = new int[9];
        int[] resultAtual = new int[3];

        HashMap<Integer, Integer> posIncorretas = new HashMap<>();

        int linhaInutilizavel = 1;
        for (int[] filho : filhos) {
            int h1 = 0;
            int h2;
            int total;
            for (int i = 0; i < 9; i++) {
                if (this.resposta[i] != filho[i]) {
                    if (filho[i] != 0) {
                        h1++;
                        posIncorretas.put(this.resposta[i], i);
                    }
                }
            }
            if (h1 == 0) {
                atual = filho;
                this.passos.put(passos.size() + 1, atual);
                return true;
            } else {
                h2 = verificaH2(posIncorretas, filho);
            }

            total = h1 + h2;
            if (resultAtual[2] != 0) {
                if (!rollBack(filho)) {
                    if (resultAtual[2] > total) {
                        resultAtual[0] = h1;
                        resultAtual[1] = h2;
                        resultAtual[2] = total;
                        resultado = filho;
                    } else if (resultAtual[2] == total) {
                        if (resultAtual[1] > h1) {
                            resultAtual[0] = h1;
                            resultAtual[1] = h2;
                            resultAtual[2] = total;
                            resultado = filho;
                        } else if (resultAtual[1] == h2) {
                            if (resultAtual[1] > h2) {
                                resultAtual[0] = h1;
                                resultAtual[1] = h2;
                                resultAtual[2] = total;
                                resultado = filho;
                            }
                        }
                    }
                } else {
                    if (linhaInutilizavel == filhos.size()) {
                        inutilizaveis.add(atual);
                        atual = antigo;
                    }
                }
            } else {
                resultAtual[0] = h1;
                resultAtual[1] = h2;
                resultAtual[2] = total;
                resultado = filho;
            }
        }

        antigo = atual;
        this.atual = resultado;
        this.passos.put(passos.size() + 1, atual);
        return false;
    }

    private int verificaH2(HashMap<Integer, Integer> posIncorretas, int[] filho) {

        int h2 = 0;

        for (int i = 0; i < 9; i++) {
            if (posIncorretas.get(filho[i]) != null) {
                if (posIncorretas.get(filho[i]) != 0) {
                    h2 = h2 + calculaDistancia(i, posIncorretas.get(filho[i]));
                }
            }
        }

        return h2;
    }

    private int calculaDistancia(int posAtual, int posFinal) {
        int resultado;

        int[] linColAtual = calculaLinhaColuna(posAtual);
        int[] linColFinal = calculaLinhaColuna(posFinal);

        int resultLinha;
        int resultColuna;

        resultLinha = (linColAtual[0] <= linColFinal[0]) ? linColFinal[0] - linColAtual[0] : linColAtual[0] - linColFinal[0];
        resultColuna = (linColAtual[1] <= linColFinal[1]) ? linColFinal[1] - linColAtual[1] : linColAtual[1] - linColFinal[1];

        resultado = (resultLinha <= resultColuna) ? resultColuna - resultLinha : resultLinha - resultColuna;

        return resultado;
    }

    private int[] calculaLinhaColuna(int pos) {

        int linha = 0;
        int coluna = 0;

        if (pos == 0) {
            linha = 1;
            coluna = 1;
        } else if (pos == 1) {
            linha = 1;
            coluna = 2;
        } else if (pos == 2) {
            linha = 1;
            coluna = 3;
        } else if (pos == 3) {
            linha = 2;
            coluna = 1;
        } else if (pos == 4) {
            linha = 2;
            coluna = 2;
        } else if (pos == 5) {
            linha = 2;
            coluna = 3;
        } else if (pos == 6) {
            linha = 3;
            coluna = 1;
        } else if (pos == 7) {
            linha = 3;
            coluna = 2;
        } else if (pos == 8) {
            linha = 3;
            coluna = 3;
        }

        int[] resultado = new int[2];

        resultado[0] = linha;
        resultado[1] = coluna;

        return resultado;

    }

    private boolean verificaUtilizados(int[] filho) {

//        boolean dif = false;
        for (int[] value : verificados) {
            if (Arrays.equals(value, filho)) {
                return true;
            }
        }
        return false;

    }

    private boolean verificaInutilizaveis(int[] filho) {

//        boolean dif = false;
        for (int[] value : inutilizaveis) {
            if (Arrays.equals(value, filho)) {
                return true;
            }
        }
        return false;

    }

    private boolean rollBack(int[] verFilho) {

        ArrayList<int[]> resultados = defineFilhos(verPosVazia(verFilho), verFilho);

        int ver = 0;
        for (int[] resultado : resultados) {
            for (int s : resultado) {
                if (s == 0) {
                    ver++;
                    if (ver == 2) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
