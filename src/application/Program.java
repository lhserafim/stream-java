package application;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Program {
    public static void main(String args[]) {
        List<Integer> list = Arrays.asList(3,4,5,6,7,8);

        // map aplica uma função a cada elemento da minha stream
        Stream<Integer> st1 = list.stream();
        // usar o toArray para imprimir os dados na tela
        System.out.println(Arrays.toString(st1.toArray()));

        // A Stream, uma vez usada é descartada, por isso criei uma nova.
        // map aplica uma função a cada elemento da minha stream
        Stream<Integer> st2 = list.stream().map(p -> p * 10);
        System.out.println(Arrays.toString(st2.toArray()));

        Stream<String> st3 = Stream.of("Maria","Alex","Bob");
        System.out.println(Arrays.toString(st3.toArray()));

        // Criando uma iteração infinita
        // 0 é o primeiro elemento da stream, x -> x + 2 regra de iteração
        Stream<Integer> st4 = Stream.iterate(0, x -> x + 2);
        // Usando uma operação de shortcircuit para limitar (pois é infinita)
        System.out.println(Arrays.toString(st4.limit(10).toArray()));

        // Implementar a regra do fibonati
        Stream<Long> st5 = Stream.iterate(new long[]{ 0L, 1L }, p->new long[]{ p[1], p[0]+p[1] }).map(p -> p[0]);
        System.out.println(Arrays.toString(st5.limit(10).toArray()));

        System.out.println("----- P I P E L I N E ------");
        // Pipeline: operações em streams retornam novas streams. Então é possível
        // criar uma cadeia de operações (fluxo de processamento).
        Stream<Integer> st6 = list.stream().map(p -> p * 10);
        System.out.println(Arrays.toString(st6.toArray()));

        // SOMATÓRIA DOS ELEMENTOS DA MINHA LISTA
        // transforma a lista em stream list.stream()
        // reduce pega o elemento inicial que é o elemento neutro da operação (na soma é zero, na multi é 1)
        // e depois uma função que pega 2 elementos e gera resultado (x,y)
        int sum = list.stream().reduce(0, (x,y) -> x + y);
        System.out.println("Sum = " + sum);

        // pego a lista de inteiros e transform em stream
        List<Integer> newList = list.stream() // fazer operaçoes intermediárias na linha de baixo
                .filter(x -> x % 2 == 0 ) // filtrar a lista pelo predicado % 2 = mod
                .map(x -> x * 10).collect(Collectors.toList()); // operacao terminal, transforma stream em lista

        System.out.println(Arrays.toString(newList.toArray()));

    }
}
