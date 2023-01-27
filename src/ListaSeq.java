public class ListaSeq{
    private int dados[];
    private int numMaxElemento; 
    private int tamAtual;

    public ListaSeq(){
        numMaxElemento = 10;
        tamAtual = 0;
        dados = new int[numMaxElemento];
    }
    public boolean vazia(){
        if(tamAtual == 0){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean cheia(){
        if(tamAtual == numMaxElemento){
            return true;
        }
        else{
            return false;
        }
    }
    public int tamanhoAtual(){
        return tamAtual;
    }
    public int posicao(int valor){
        for(int i = 0; i < tamAtual; i++){
            if(dados[i] == valor){
                return(i + 1);
            }
        }
        return -1;
    }
    public int elemento(int posicao){
        if(posicao > numMaxElemento || posicao < 1){
            return -1;
        }
        else{
            return dados[posicao-1];
        }
    }
    public boolean insere(int posicao, int valor){
        if(cheia() || posicao > (tamAtual+1) || posicao < 1){
            return false;
        }
        else{
            for(int i = tamAtual; i >= posicao; i--){
                dados[i] = dados[i-1];
            }
            dados[posicao-1] = valor;
            tamAtual++;
            return true;
        }
    }
    public int remove(int posicao){
        int aux;
        if(posicao > tamAtual || posicao < 1){
            return -1;
        }
        else{
          aux  = dados[posicao-1];
            for(int i = (posicao - 1); i < tamAtual - 1; i++){
                dados[i] = dados[i+1];
            }
            tamAtual--;
            return aux;
        }
    }

}