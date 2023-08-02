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

            System.out.println("Conexão Estabelecida ---->  " + socket.getInetAddress().getHostAddress());

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

        try {
            File arquivo = new File("entrada.txt");
            Scanner scanner = new Scanner(arquivo);

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] partes = linha.split(",");

                System.out.println("Linha original: " + linha);

                total_Operacao[index_total_Operacao++] = (Operacao) new Operacao_Finalizada( Integer.parseInt(partes[0]), partes[1] );

            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
        }

        

//

    }

    private static void inicializar() throws FileNotFoundException {

        ColetarAtividades();
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
