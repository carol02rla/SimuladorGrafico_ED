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
		labelSobre.setFont(new Font("Courier", Font.BOLD, 30));
		labelSobre.setBounds(40, 40, 100, 50);
		contentPanel.add(labelSobre);
		
        JLabel texto = new JLabel("<html>"
        + "<p>Projeto final da disciplina de Estrutura de Dados, do periodo 2022.1, com o professor Tiago Maritan.</p>"
        + "<p>Grupo formado por Ana Carolina Aguiar, Barbara, Leticia e Jayanne. "
        + "O seguinte trabalho apresenta as estruturas de dados estudadas na disciplina de forma grafica: "
        + "Lista Sequencial, Lista Simplemente Encadeada, Pilha, Fila e Arvore Binaria de Pesquisa.</p>"
        + "</html>");
		texto.setForeground(new Color(34, 38, 45));
		texto.setFont(new Font("Courier", Font.PLAIN, 26));
		texto.setBounds(40, 100, 920, 300);
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
		botaoVoltar.setFont(new Font("Courier", Font.PLAIN, 22));
		botaoVoltar.setBounds(430, 450, 140, 30);
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
