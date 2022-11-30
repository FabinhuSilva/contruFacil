package construfacilorcamento.DAO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class conexaoBancoPostgresql {

    public conexaoBancoPostgresql() {
    }

    Path caminho = null;
    Scanner lendoArquivo = null;

    public void encontrarArquivotxt() {

        /*
        Documentação DEVIMEDIA
        https://www.devmedia.com.br/lendo-dados-de-txt-com-java/23221
        https://pt.stackoverflow.com/questions/1823/como-ler-um-arquivo-de-texto-em-java#:~:text=A%20forma%20mais%20f%C3%A1cil%20de,readAllBytes(file.
        
        olhando este
        https://www.guj.com.br/t/fazer-o-programa-ler-um-arquivo/407009/2
        criado pasta em C:\construfacil\construfacil.txt
        
        god of war ragnarok
        https://www.youtube.com/watch?v=20w0KsT8JMo&list=PLrVhyUnEQMV_qEFs13R65qENVNXIL4FCJ&index=2
        
         */
//Criar Variavel para encontrar o caminho do arquivo a ser lido
        caminho = Paths.get("c:/construfacil/construfacil.txt");
        try {
            byte[] ArrayDadosArquivo = Files.readAllBytes(caminho);
            String converteParaString = new String(ArrayDadosArquivo);

            JOptionPane.showMessageDialog(null, converteParaString);

        } catch (Exception erro) {
            System.out.println("Arquivo nao encontrado :" + erro);
        }

    }

    public void lerArquivotxt(boolean arquivo) throws IOException {
        /*
            Conteudo explicado nestevideo:
            https://www.youtube.com/watch?v=xLDViuYlqGM&t=874s
         */
        
        if(arquivo != false){
        try {
            lendoArquivo = new Scanner(caminho);
            while (lendoArquivo.hasNextLine()) {
                System.out.println(lendoArquivo.nextLine());
            }

        } catch (IOException erro) {
            System.out.println(erro.getMessage());
        } finally { //utilizado para encerrar o comando Scanner aberto
            /* Se faz necessario o if, pois se acaso vir de uma exceção 
               daria o erro de nullpointexception, pois caso ocorra o 
               erro ja tera sido encerrado o scanner
             */
            if (lendoArquivo != null) {
                lendoArquivo.close();
            }
        }
    }else{
            System.out.println("Parametro não Encontrado!");
}
    } 
}
