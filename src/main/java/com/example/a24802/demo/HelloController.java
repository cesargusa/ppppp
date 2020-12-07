package com.example.a24802.demo;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.stream.IntStream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hi")
    public String Hello() {
         var string = "Hello world from Spring :-]";
         var a = 0;
        return string;
    }
    /*
     * @GetMapping("/longstring")ULAA public String longstring() { var string ="";
     * for (int e=0;e<=10;e++){ string += "Escribiendo numeros:"+ e + "<br>";
     * 
     * } return string;
     */

    @GetMapping("/intList")
    public Integer[] ArrayNumeros() {
        return new Integer[] { 1, 2, 3, 4, 5 };
    }

    @GetMapping("/intList2")
    public ArrayList<Integer> numeros() {

        final ArrayList<Integer> numeros = new ArrayList<>();
        for (int f = 1; f <= 5; f++) {
            numeros.add(f);
        }
        return numeros;

    }

    @GetMapping("/Remplazar/{letra}")
    public String Remplazar(@PathVariable("letra") final String letra) {
        final String espacio = "";
        final String mensaje = "Hola me llamo Cesar";

        return mensaje.replace(letra, espacio);

    }

    @GetMapping("/bye")
    public String bye() {
         var string = "Bye World";
         var a = 0;
        return string;
    }

    @GetMapping("/fibonacci/{numElements}")
    private ArrayList<Integer> Fibonacci(@PathVariable("numElements") int numElements) throws Exception {

        int fibo1, fibo2, i;
        ArrayList<Integer> fibonacci = new ArrayList<Integer>();

        fibo1 = 0;
        fibo2 = 1;
        if (numElements < 0) {

            throw new Exception("Error");
        }
        fibonacci.add(fibo1);
        fibonacci.add(fibo2);

        for (i = 2; i <= numElements; i++) {

            fibo2 = fibo1 + fibo2;
            fibo1 = fibo2 - fibo1;

            fibonacci.add(fibo2);
        }
        return fibonacci;

    }

    @GetMapping("/fibonacci/{numElements}/table")
    public String FibonacciTabla(@PathVariable("numElements") int numElements) throws Exception {
        ArrayList<Integer> fibonacciNumeros = Fibonacci(numElements);

        StringBuilder fibonacci = new StringBuilder();

        fibonacci.append("<table style='width:100%'>");

        for (int i = 0; i < fibonacciNumeros.size(); i++) {
            if (i % 4 == 0) {
                fibonacci.append("<tr>");
            }

            fibonacci.append("<td>");
            fibonacci.append(fibonacciNumeros.get(i));
            fibonacci.append("</td>");

            if (fibonacciNumeros.size() % 4 == 0) {
                fibonacci.append("</tr>");
            }

        }
        fibonacci.append("</table>");
        return fibonacci.toString();

    }

    @GetMapping("/fibonacci2/{numValores}/table")
    public String fibonacciTabla(@PathVariable("numValores") int numValores) throws Exception {
        ArrayList<Integer> FibonacciNumeros = Fibonacci(numValores);

        StringBuilder fibonacci = new StringBuilder();

        fibonacci.append("<table style='width:100%; text-align:center;'>");

        for (int i = 0; i < numValores; i++) {
            if (i % 4 == 0) {
                fibonacci.append("<tr style='border: 1px solid black;background-color:#00ffff;'>");
            }
            fibonacci.append("<td style='border: 1px solid black;background-color:#00ffff;padding:20px;'>");
            fibonacci.append(FibonacciNumeros.get(i));
            fibonacci.append("</td>");

        }

        fibonacci.append("</tr>");
        fibonacci.append("</table>");
        return fibonacci.toString();
    }

    @GetMapping("/Mostrar/{nombre}")
    public String mostrar(@PathVariable("nombre") String nombre) {

        return nombre;
    }

    @GetMapping("/Repetir/{palabra}/{numVeces}")
    public String repetir(@PathVariable("palabra") String palabra, @PathVariable("numVeces") Integer numVeces) {
        String mensaje = "";

        for (int num = 0; num < numVeces; num++) {
            mensaje += palabra + "<br>";

        }

        return mensaje;
    }

    @GetMapping("/longstring")
    public String ConcatString() {
        StringBuilder c = new StringBuilder();

        for (int e = 0; e <= 20000; e++) {
            c.append("Escribiendo mensaje: ");
            c.append(e);
            c.append("<br>");

        }
        return c.toString();

    }

    @GetMapping("/longstring/lambda")
    public String ConcatStringWLambdaExp() {
        return IntStream.range(0, ARRAY_NUM_ELEMENTS).mapToObj(n -> "Escribiendo número:" + n + "<br>").reduce("",
                (partialResult, item) -> partialResult + item);
    }

    @GetMapping("/longstring/nonlambda")
    public String ConcatStringWoLambdaExp() {

        long tStart = System.currentTimeMillis();
        int[] array = IntStream.range(0, ARRAY_NUM_ELEMENTS).toArray();
        long tMid = System.currentTimeMillis();
        String result = "";
        for (int i = 0; i < array.length; i++)
            result += "Escribiendo número:" + i + "<br>";
        long tEnd = System.currentTimeMillis();

        return result;
    }

    @GetMapping("/longstring/nonlambda/builder")
    public String ConcatStringWoLambdaExpSB() {
        int[] array = IntStream.range(0, ARRAY_NUM_ELEMENTS).toArray();
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < array.length; i++)
            b.append("Escribiendo número:" + i + "<br>");
        return b.toString();
    }


    private int ARRAY_NUM_ELEMENTS = 20000;

}
