public class FilaSeq {
	private NoABP dados[];
	private int inicio;
	private int fim;
	private int nElementos;
	
	public FilaSeq() {
		inicio = 0;
		fim = -1;
		nElementos = 0;
		
		dados =  new NoABP[100];
	}
	
	public FilaSeq(int n) {
		inicio = 0;
		fim = -1;
		nElementos = 0;
		
		dados =  new NoABP[n];
	}

	/** Verifica se a Fila está vazia */
	public boolean vazia () {
		if (nElementos == 0)
			return true;
		else
			return false;
	}

	/**Verifica se a Fila está cheia */
	public boolean cheia () {
		if (nElementos == dados.length)
			return true;
		else
			return false;
	}

	/** Obtém o tamanho da Fila */
	public int tamanho() {
		return nElementos;
	}

	/** Consulta o elemento do início da fila.
	    Retorna -1 se a fila estiver vazia. */
	public NoABP primeiro() {
		if (vazia())
			return null; // Erro: Fila vazia 
		
		return dados[inicio];
	}

	/**Insere um elemento no fim de uma fila
    Retorna false se a fila estiver cheia, true caso contrário. */
	public boolean insere(NoABP valor) {
		if (cheia()){
			return false;
		}
	
		fim = (fim + 1) % dados.length; // Circularidade 
	    dados[fim] = valor;
		nElementos++;
		return true;
	}

	/**Remove o elemento do início da fila e retorna o valor removido.
	    Retorna -1 se a fila estiver vazia.*/
	public NoABP remove() {
		if (vazia())
			return null;
	
		// Guarda o valor a ser removido
		//int valor = primeiro();
		NoABP valor = dados[inicio];
		
		// Atualiza o atributo inicio;
		inicio = (inicio + 1) % dados.length; //Circularidade 
		nElementos--;
		return valor;
	}

}
