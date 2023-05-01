import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class torreHanoi {
    public int movimentos = 0;

    public  void torreHanoi(int n, PilhaInt pilhaOrigem, PilhaInt pilhaDestino, PilhaInt pilhaAux){
        if (n > 0) {
            torreHanoi(n-1, pilhaOrigem, pilhaAux, pilhaDestino);
            pilhaDestino.push(pilhaOrigem.pop());
            this.movimentos++;
            torreHanoi(n-1, pilhaAux, pilhaDestino, pilhaOrigem);
        }
       
        
    }

    public int getMovimentos(){
        return this.movimentos;

    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite a quantidade de dicos");
        int n =  scan.nextInt(); 
        PilhaInt pilhaOrigem = new PilhaInt(n);
        PilhaInt pilhaDestino = new PilhaInt(n);
        PilhaInt pilhaAux = new PilhaInt(n);
        
        for (int i = 1; i <= n; i++) {
            pilhaOrigem.push(i);
        }
        

        LocalDateTime inicio = LocalDateTime.now();
        torreHanoi torre = new torreHanoi();
        torre.torreHanoi( n,  pilhaOrigem,  pilhaDestino,  pilhaAux);

        LocalDateTime fim = LocalDateTime.now();
        Duration duracao = Duration.between(inicio, fim);
        long horas = duracao.toHours();
        long minutos = duracao.toMinutes() % 60;
        long segundos = duracao.getSeconds() % 60;
        long milissegundos = duracao.toMillis() % 1000;

String duracaoFormatada = String.format("%02d:%02d:%02d.%03d", horas, minutos, segundos, milissegundos);
        System.out.println("Número de movimentos: " + torre.getMovimentos());
        System.out.println("Tempo de execução: " + duracaoFormatada);
        
        
        
    }
    
}
