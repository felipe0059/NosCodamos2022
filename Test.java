import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


class Result {
    /*
     * Complete the 'acharMinimoDeDias' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts FLOAT_ARRAY duracoes as parameter.
     */
    
    public static int acharMinimoDeDias(List<Float> duracoes) {
        int minimo_de_dias = 0;
        Collections.sort(duracoes);
        
        while (duracoes.size() != 0) {
            if (duracoes.size() == 1) {
                minimo_de_dias++;
                duracoes.remove(0);
            } 
            else if (duracoes.get(0) + duracoes.get((duracoes.size() - 1)) <= 3.0) {
                minimo_de_dias++;
                duracoes.remove(0);
                duracoes.remove((duracoes.size() - 1));
            }
            else {
                duracoes.remove((duracoes.size() - 1));
                minimo_de_dias++;
            }
        }
        return minimo_de_dias;
    }
}

public class Solution {
     public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int duracao_total_colecao = scanner.nextInt();

        List<Float> duracoes = new ArrayList<>();

        for (int n = 0; n < duracao_total_colecao; n++) {
            float duracao_item = scanner.nextFloat();
            duracoes.add(duracao_item);
        }

        int result = Result.acharMinimoDeDias(duracoes);

        System.out.println(result);
        scanner.close();
    }
}