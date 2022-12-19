package construfacilorcamento.DAO;

import com.sun.jdi.connect.spi.Connection;
import java.beans.Statement;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class conexaoBancoPostgresql {

    /*
        Documentação DEVIMEDIA
        https://www.devmedia.com.br/lendo-dados-de-txt-com-java/23221
        https://pt.stackoverflow.com/questions/1823/como-ler-um-arquivo-de-texto-em-java#:~:text=A%20forma%20mais%20f%C3%A1cil%20de,readAllBytes(file.
        
        olhando este
        https://www.guj.com.br/t/fazer-o-programa-ler-um-arquivo/407009/2
        criado pasta em C:\construfacil\construfacil.txt
        
        Retornodo JOptionPane:
            YES_OPTION
            NO_OPTION
            CANCEL_OPTION
            OK_OPTION
            CLOSED_OPTION
    
         Usando extensoes em showmessagedialog
    Exemplo: JOptionPane.showInputDialog("Insira seu sexo:").charAt(0)    
    
    Indica qual o tipo de ícone a ser exibido na mensagem, definido pelas seguintes constantes (ou pelos números inteiros que as representam):
PLAIN_MESSAGE (valor: -1): Mensagem limpa, sem nenhum ícone.
ERROR_MESSAGE (valor: 0): Mensagem de erro.
INFORMATION_MESSAGE (valor: 1): Mensagem informativa.
WARNING_MESSAGE (valor: 2): Mensagem de alerta.
QUESTION_MESSAGE (valor: 3): Mensagem de requisição ou pergunta.
    
Esta é a opção padrão do método showInputDialog().

Ex.: O código JOptionPane.showInputDialog(null, “Qual o seu Nome?”, “Pergunta”, JOptionPane.PLAIN_MESSAGE) gera a caixa da Figura 04.
    
    god of war ragnarok
        https://www.youtube.com/watch?v=20w0KsT8JMo&list=PLrVhyUnEQMV_qEFs13R65qENVNXIL4FCJ&index=2
    
        
            
     */
    public conexaoBancoPostgresql() {

    }

    Path caminho = null;
    Scanner lendoArquivo = null;
    String chaveAutenticacao = null;
    String valorPadrao = null;
        private String local;
	private String user;
	private String senha;
	private Connection c;
	private Statement statment;
	private String str_conexao;
	private String driverjdbc;

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Connection getC() {
        return c;
    }

    public void setC(Connection c) {
        this.c = c;
    }

    public Statement getStatment() {
        return statment;
    }

    public void setStatment(Statement statment) {
        this.statment = statment;
    }

    public String getStr_conexao() {
        return str_conexao;
    }

    public void setStr_conexao(String str_conexao) {
        this.str_conexao = str_conexao;
    }

    public String getDriverjdbc() {
        return driverjdbc;
    }

    public void setDriverjdbc(String driverjdbc) {
        this.driverjdbc = driverjdbc;
    }
        

    public void encontrarArquivotxt() {
        int resposta = 3;
//Criar Variavel para encontrar o caminho do arquivo a ser lido
        resposta = JOptionPane.showConfirmDialog(null, "Deseja utilizar o caminho Padrão para Validação da Chave? ", "Caminho de Chave", JOptionPane.YES_NO_CANCEL_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            caminho = Paths.get("c:/construfacil/chave.txt");
            try {
                byte[] ArrayDadosArquivo = Files.readAllBytes(caminho);
                String converteParaString = new String(ArrayDadosArquivo);
                JOptionPane.showMessageDialog(null, converteParaString);
            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null,"Arquivo nao encontrado :\n" + erro,"importação de Chave",JOptionPane.WARNING_MESSAGE);
                System.out.println("Arquivo nao encontrado :" + erro);
            }
        } else if (resposta == JOptionPane.NO_OPTION) {
            String caminhoChave = JOptionPane.showInputDialog("Digite o Diretório ao qual encontra-se o arquivo de CHAVE:", "Caminho Padrão");
            caminho = Paths.get(caminhoChave);
            if (resposta != JOptionPane.CANCEL_OPTION || resposta == JOptionPane.CLOSED_OPTION) {
                if (caminhoChave.length() < 3 || caminhoChave.equals("")) {
                    System.out.println(caminhoChave.length());
                    JOptionPane.showMessageDialog(null, "Caminho Invalido");
                    JOptionPane.showMessageDialog(null, "Para validar a CHAVE repita o processo quando quiser!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Para validar a CHAVE repita o processo quando quiser!");
                // REVER Código
            }
        }

    }

    public void lerArquivotxt(boolean arquivo) throws IOException {
        /*
            Conteudo explicado nestevideo:
            https://www.youtube.com/watch?v=xLDViuYlqGM&t=874s
         */

        if (arquivo != false) {
                 int contador = 0;
                 
            try {
                
                //REVER Codigo
                lendoArquivo = new Scanner(caminho);
                while (lendoArquivo.hasNextLine()) {
                    // System.out.println(lendoArquivo.nextLine());
                    System.out.println("Trecho Metodo lerArquivotxt");
                    JOptionPane.showMessageDialog(null, lendoArquivo.nextLine());
                    String chave = lendoArquivo.next();
                    System.out.println(chave);
                    
                    /*
                    chaveAutenticacao = lendoArquivo.next();
                    System.out.println(chaveAutenticacao);
                    */
                    contador++;
                    JOptionPane.showMessageDialog(null, "Linhas Contadas: "+ contador);
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
        } else {
            System.out.println("Parametro não Encontrado!");
        }
    }

    public void compararChave(String chave) {

        /*
     Validando conteudo
     https://pt.stackoverflow.com/questions/359890/ler-um-arquivo-txt-a-partir-de-um-layout-determinado
         */
        if (chaveAutenticacao.equals(valorPadrao)) {

            JOptionPane.showMessageDialog(null, "Liberado Acesso");

        } else {
            JOptionPane.showMessageDialog(null, "Entre em contato com fabiano.fesilva@gmail.com");
        }
    }
    
    public void conexaoBancoPostgresql(String bd, String local, String porta,String banco, String user, String senha){
 if (bd.equals("PostgreSql")){
  			setStr_conexao("jdbc:postgresql://"+ local +":" + porta +"/"+ banco);
  			setLocal(local);
  			setSenha(senha);
  			setUser(user);
  			setDriverjdbc("org.postgresql.Driver");
  		 }else {
  			if (bd.equals("MySql")) {
     				setStr_conexao("jdbc:mysql://"+ local +":" + porta +"/"+ banco);
     				setLocal(local);
     				setSenha(senha);
     				setUser(user);
     				setDriverjdbc("com.mysql.jdbc.Driver");
 			}
		}
        
    }

    
public void configUser(String user, String senha){    
		setUser(user);
		setSenha(senha);
}

}
