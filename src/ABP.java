public class ABP {
	private NoABP raiz;
	
	public ABP(){
		raiz = null;
	}
	
	/** Verifica se a árvore está vazia */
	public boolean vazia (){
		return (raiz == null);
	}

	/**Buscar recursivamente a partir da raiz.
	    Retorna o endereço se o elemento for
	    encontrado, caso contrário retorna NULL*/
	private NoABP busca(NoABP T, int valor) {
		if (T == null)
			return null;  // Arvore Vazia

		if(T.getConteudo() == valor)
			return T; 	// Elem. encontrado na raiz
		
		if (valor < T.getConteudo())
			return busca(T.getEsq(), valor);
	    else
			return busca(T.getDir(), valor);
	}
	
	/**Buscar um elemento na ABP
    		Retorna o endereço se o elemento for
    		encontrado, caso contrário retorna NULL*/
	public NoABP busca(int valor) {          
		//if (raiz != null) 
			return busca(raiz, valor);
		
		//return null;
	}
	
	public int buscaIterativa(int valor) {          
		String ordem = "";
		int pos = 0;

		if (vazia())
			return -1;
		
		NoABP aux = raiz;
		while (aux != null) {
			// Verificando se o conteudo do no atual 
			// é igual ao valor procurado
			if (aux.getConteudo() == valor) {
				pos = posicoes(ordem);
				return pos;
			}
			
			// Se o valor procurado for menor que raiz,
			// continue pesquisando na sub-arv da esq.
			if (valor < aux.getConteudo()){
				aux = aux.getEsq();
				ordem += "0";
			}
			// Caso contratio, pesquise na sub-arv 
			// da direita
			else {
				aux = aux.getDir();
				ordem += "1";
			}
		}

		return -1;
	}
	
	
	/**Exibe o conteúdo de uma árvore no formato in-ordem
	    (preserva a ordenação)*/
	private void exibe (NoABP T){
		if (T != null) {
			exibe(T.getEsq());
			System.out.print(" " + T.getConteudo());
			exibe(T.getDir());
		}
	}

	public void exibe() {
		if (raiz == null)
			System.out.println("Arvore vazia");
		else
			exibe(raiz);
	}
	
	/**Exibe o conteúdo de uma árvore no formato in-ordem
    (preserva a ordenação)*/
	private void exibeDec(NoABP T){
		if (T != null) {
			exibeDec(T.getDir());
			System.out.print(" " + T.getConteudo());
			exibeDec(T.getEsq());
		}
	}
	
	public void exibeDec() {
		if (raiz == null)
			System.out.println("Arvore vazia");
		else
			exibeDec(raiz);
	}
	
	/**Insere um nó em uma árvore ABP
	    Retorna 1 se a inserção for com sucesso.
	    Caso contrário retorna 0*/
	public int insere(int valor) {

		NoABP novoNo = new NoABP();
		novoNo.setConteudo(valor);
		novoNo.setEsq(null);
		novoNo.setDir(null);

		String seq = "";
		int pos;

		// Quando a arvore estiver vazia, o novoNó será a raiz da arv
		if (raiz == null){ 
	 		raiz = novoNo;
			return 8;
		}

	    // Procura a posicao correta pra inserir o novo no
	    NoABP aux = raiz;
	    NoABP p = null;
	    while (aux != null) {
	    	p = aux;
			if (valor < aux.getConteudo()) {
				aux = aux.getEsq();
				seq += "0";
			} else {
				aux = aux.getDir();
				seq += "1";
			}
		}

		pos = posicoes(seq);

		if(pos == -1) {
			return pos;
		} else {
			// Encontrou um nó folha para inserir
			if (valor < p.getConteudo()) {
				p.setEsq(novoNo);
			} else {
				p.setDir(novoNo);
			}
		}
		
		return pos;
	}

	private int posicoes(String seq) {
		int posicao = 0;

		if(seq.equals("0")) { posicao = 4; } 
		else if (seq.equals("00")) { posicao = 2; }
		else if (seq.equals("000")) { posicao = 1; }
		else if (seq.equals("001")) { posicao = 3; }
		else if (seq.equals("01")) { posicao = 6; }
		else if (seq.equals("010")) { posicao = 5; }
		else if (seq.equals("011")) { posicao = 7; }
		else if (seq.equals("1")) { posicao = 12; }
		else if (seq.equals("10")) { posicao = 10; }
		else if (seq.equals("100")) { posicao = 9; }
		else if (seq.equals("101")) { posicao = 11; }
		else if (seq.equals("11")) { posicao = 14; }
		else if (seq.equals("110")) { posicao = 13; }
		else if (seq.equals("111")) { posicao = 15; }
		else { posicao = -1; }
		
		return posicao;
	}

	/** Exibe o conteúdo de uma árvore em pré-ordem*/
	private void exibePreOrdem(NoABP T) {
		if (T == null)
			return;
	
		// Imprime a raiz
		System.out.print(" " + T.getConteudo());
		
		// Caminha recursivamente na sub-arv da esq (pre-ordem)
		if (T.getEsq() != null)
			exibePreOrdem(T.getEsq());
	
		// Caminha recursivamente na sub-arv da dir (pre-ordem)
	 	if (T.getDir() != null)
			exibePreOrdem(T.getDir());
	}

	/** Exibe o conteúdo de uma árvore em pré-ordem*/
	public void exibePreOrdem() {
		if (raiz == null)
			System.out.println("Arvore vazia");
		else
			exibePreOrdem(raiz);
	}	
	
	
	/** Exibe o conteúdo de uma árvore em pré-ordem*/
	private void exibeInOrdem(NoABP T) {
		if (T == null)
			return ;

		if (T.getEsq() != null)
			exibeInOrdem(T.getEsq());
	
	    System.out.print(" " + T.getConteudo());
	
	 	if (T.getDir() != null)
			exibeInOrdem(T.getDir());
	}

	
	/** Exibe o conteúdo de uma árvore em pré-ordem*/
	public void exibeInOrdem() {
		if (raiz == null)
			System.out.println("Arvore vazia");
		else
			exibeInOrdem(raiz);
	}	
	
	/** Exibe o conteúdo de uma árvore em pré-ordem*/
	private void exibePosOrdem(NoABP T) {
		if (T == null)
			return ;

		if (T.getEsq() != null)
			exibePosOrdem(T.getEsq());
	
	 	if (T.getDir() != null)
			exibePosOrdem(T.getDir());

	 	System.out.print(" " + T.getConteudo());
	}
	
	/** Exibe o conteúdo de uma árvore em pré-ordem*/
	public void exibePosOrdem() {
		if (raiz == null)
			System.out.println("Arvore vazia");
		else
			exibePosOrdem(raiz);
	}
}
