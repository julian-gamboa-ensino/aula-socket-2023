import java.io.IOException;
import java.io.PrintWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;  

import java.net.ServerSocket;
import java.net.Socket;

import Models.Operacao;
import Models.Operacao_Finalizada;
import Models.Operacao_Planejamento;

public class Program {

    public static Operacao[] total_Operacao = new Operacao[15];
    public static int index_total_Operacao=0;

    public static void main(String[] args) throws IOException {
        
        // Create a new server socket.
        ServerSocket serverSocket = new ServerSocket(8080);

        System.out.println("Servidor iniciado. Aguardando conexões...");

        // Listen for incoming connections.
        while (true) {
            // Accept an incoming connection.
            Socket socket = serverSocket.accept();

            System.out.println("Conexão estabelecida com o cliente: " + socket.getInetAddress().getHostAddress());

            // Create a new PrintWriter to write to the client.
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Write a message to the client.
            inicializar();
            enviarResposta(out);

            // Close the connection.
            out.close();
            socket.close();
        }
    }

    private static void ColetarAtividades() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("entrada.txt"));  
        sc.useDelimiter(",");   //sets the delimiter pattern  
        while (sc.hasNext())  //returns a boolean value  
        {  
            //System.out.print(sc.next());  
            total_Operacao[index_total_Operacao++] = (Operacao) new Operacao_Finalizada(0, sc.next());

        }   
        sc.close();  //closes the scanner  
    }

    private static void inicializar() throws FileNotFoundException {

        ColetarAtividades();
        
        //Operacao_Finalizada fim = new Operacao_Finalizada(2, "Operacao_Finalizada");
//total_Operacao[index_total_Operacao++] = (Operacao) new Operacao_Finalizada(2, "Operacao_Finalizada");
        
        //Operacao_Planejamento op = new Operacao_Planejamento(0, "Operacao_Planejamento");
        
        //total_Operacao[index_total_Operacao++] = (Operacao) new Operacao_Planejamento(0, "Operacao_Planejamento");

        
    }

    private static void enviarResposta(PrintWriter out) {
        for (Operacao elemento : total_Operacao) {
            if (elemento != null) {
                out.println("enviarResposta: " + elemento);
            } else {
                out.println("Elemento: Nulo");
            }
        }
    }
}
