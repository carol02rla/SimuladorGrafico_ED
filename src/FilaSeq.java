<<<<<<< HEAD
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
=======
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bárbara
 */

public class FilaSeq {
    private int dados[];
	private int inicio;
	private int fim;
	private int nElementos;
	//private int tamMax;
	
	public FilaSeq() {
		inicio = 0;
		fim = -1;
		nElementos = 0;
		
		dados =  new int[10];
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
	public int primeiro() {
		if (vazia()){
			return -1; // Erro: Fila vazia 
		}
		return dados[inicio];
	}

	/**Insere um elemento no fim de uma fila
    Retorna false se a fila estiver cheia, true caso contrário. */
	public boolean insere(int valor) {
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
	public int remove() {
		if (vazia())
			return -1;
	
		// Guarda o valor a ser removido
		//int valor = primeiro();
		int valor = dados[inicio];
		
		// Atualiza o atributo inicio;
		inicio = (inicio + 1) % dados.length; //Circularidade 
		nElementos--;
		return valor;
	}

	public int getInicio(){
		return inicio;
	}
	
	public int getFim() {
		return fim;
	}

}
>>>>>>> 2542cebfd222e2f7cb007356a97ff151dd931d41
