/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle;

import java.util.ArrayList;

/**
 *
 * @author Leonardo
 */
public class XogosDigitais {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int[] resposta = new int[9];
        ArrayList<int[]> possibilidades = new ArrayList<>();
        for (int i = 1; i < 9; i++) {
            resposta[i] = i;
        }

        boolean heuristica = true;

        if (heuristica) {
            VerificacaoHeuristica vh = new VerificacaoHeuristica();
            vh.setParametros(resposta);
        } else {
            VerificacaoHorizontal vh = new VerificacaoHorizontal();
            vh.setParametros(resposta);
            
        }

    }

}
