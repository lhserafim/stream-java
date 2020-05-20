package application;

import java.util.Arrays;
import java.util.List;
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

    }
}
