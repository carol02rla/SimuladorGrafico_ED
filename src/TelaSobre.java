import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaSobre extends JDialog {
    
    private JPanel contentPanel;

    public TelaSobre() {
        contentPanel = new JPanel();

		this.setModal(true);
        
		contentPanel.setBackground(new Color(255, 245, 195));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(null);
		
		this.setBounds(100, 100, 1000, 600);
		this.setLocation(250, 50);
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel labelSobre = new JLabel("SOBRE");
		labelSobre.setForeground(new Color(34, 38, 45));
		labelSobre.setFont(new Font("Courier", Font.BOLD, 25));
		labelSobre.setBounds(40, 40, 100, 50);
		contentPanel.add(labelSobre);
		
        JLabel texto = new JLabel("<html>"
        + "<p>Projeto final da disciplina de Estrutura de Dados, no periodo 2022.1, com o professor Tiago Maritan.</p> <p></p>"
        + "<p>Grupo formado por: </p> <p>&#9Ana Carolina Rodrigues Lima de Aguiar [20210024326] </p> <p>&#9Bárbara Hellen Padilha da Silva [20200004867] </p> <p>&#9Letícia Serrano Dantas [20170118575] </p> <p>&#9Jayanne Laysa Cruz Morais [20190026757] </p>"
        + "<p></p> <p>Este projeto apresenta, de forma gráfica, as seguintes estruturas de dados estudadas na disciplina: "
        + "Lista Sequencial, Lista Simplemente Encadeada, Pilha, Fila e Árvore Binária de Pesquisa.</p>"
        + "</html>");
		texto.setForeground(new Color(34, 38, 45));
		texto.setFont(new Font("Courier", Font.PLAIN, 20));
		texto.setBounds(40, 90, 920, 350);
		contentPanel.add(texto);
        
        JButton botaoVoltar = new JButton("VOLTAR");
        botaoVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		botaoVoltar.setForeground(new Color(34, 38, 45));
		botaoVoltar.setBackground(Color.WHITE);
        botaoVoltar.setFocusable(false);
		botaoVoltar.setFont(new Font("Courier", Font.PLAIN, 20));
		botaoVoltar.setBounds(440, 470, 120, 30);
		contentPanel.add(botaoVoltar);

        this.setVisible(true);
    }
    
    public static void main(String[] args) {
        try {
			TelaSobre sobre = new TelaSobre();
			sobre.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			sobre.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}
