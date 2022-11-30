
package construfacilorcamento;

import construfacilorcamento.DAO.conexaoBancoPostgresql;
import java.io.IOException;


public class ConstruFacilOrcamento {

 
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        conexaoBancoPostgresql lendo = new conexaoBancoPostgresql();
        lendo.lerArquivotxt(true);
        
    }
    
}
