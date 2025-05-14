import java.util.ArrayList;

public class App {

    public static int funcHash(String palavra, int tam){
        int hash = 0;
        hash = 13+palavra.toUpperCase().charAt(0);

        return hash % tam;
    }
    public static boolean buscarPalavra(String palavra, ArrayList<String>[] tabelaHash, int tam) {
        int cat = funcHash(palavra, tam);
        if(tabelaHash[cat].contains(palavra)){
            return true;
        }else{

        return false;
        }

        //Versão simplificada  
        // return tableHash[cat].contains(palavra);
    }

    public static void main(String[] args) throws Exception {
        String[] palavra = {    
            "Tela", 
            "sol",
            "abacate",
            "amizade",
            "banana",
            "carro",
            "computador",
            "escola",
            "gato",
            "janela",
            "livro",
            "zebra"};
        int totalCategorias = 26;
        ArrayList<String> tabelaHash[] =  new ArrayList[totalCategorias];
        // inicializar a tabela
        for (int i = 0; i < tabelaHash.length; i++) {
            System.out.println(i + "-> " + tabelaHash[i]);
            tabelaHash[i] = new ArrayList<String>();
        }
        System.out.println("---INSTANCIADAS---");
        for (int i = 0; i < tabelaHash.length; i++) {
            System.out.println(i + "-> " + tabelaHash[i]);
        }
        System.out.println("Adicionando palavras...");
        for (int i = 0; i < palavra.length; i++) {
            int categoria = funcHash(palavra[i], totalCategorias);
            tabelaHash[categoria].add(palavra[i]);            
        }
        System.out.println("---PREENCHIDA---");
        for (int i = 0; i < tabelaHash.length; i++) {
            System.out.println(i + "-> total = " + tabelaHash[i]);
        }
        //
        String palavraBusca = "sol";
        if (buscarPalavra(palavraBusca, tabelaHash, totalCategorias)) {
            System.out.println("Palavra '" + palavraBusca + "' foi encontrada.");
        } else {
            System.out.println("Palavra '" + palavraBusca + "' não encontrada.");
        }

    }
}