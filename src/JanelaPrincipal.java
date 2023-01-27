import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaPrincipal extends JFrame {

    private JPanel contentPane;
    
    private JButton botaoLS;
    private JButton botaoLSE;
    private JButton botaoPilha;
    private JButton botaoFila;
    private JButton botaoABP;
    private JButton botaoSobre;
    private JButton botaoQuit;

    public JanelaPrincipal() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(new Color(255, 255, 255));
		this.setBounds(100, 100, 1000, 600);
		this.setLocation(250, 50);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(213, 253, 219));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.setLayout(null);

		this.setContentPane(contentPane);
        this.setVisible(true);

        JLabel labelED = new JLabel("ESTRUTURAS DE DADOS");
		labelED.setForeground(new Color(34, 38, 45));
		labelED.setBackground(new Color(34, 38, 45));
		labelED.setFont(new Font("Courier", Font.BOLD, 34));
		labelED.setBounds(310, 10, 380, 80);
		contentPane.add(labelED);

        botaoLS = new JButton("LISTA SEQUENCIAL");
        botaoLS.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ListaSeqGUI le = new ListaSeqGUI();
                le.setVisible(true);
            }
        });
        addButton(botaoLS, 375, 140);

        botaoLSE = new JButton("LISTA ENCADEADA");
		botaoLSE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                new LSE_GUI();
			}
		});
        addButton(botaoLSE, 375, 190);
        
        botaoPilha = new JButton("PILHA");
        botaoPilha.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PilhaSeqGUI le = new PilhaSeqGUI();
                le.setVisible(true);
            }
        });
        addButton(botaoPilha, 375, 240);
        
        botaoFila = new JButton("FILA");
        botaoFila.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FilaSeqGUI le = new FilaSeqGUI();
                le.setVisible(true);
            }
        });
        addButton(botaoFila, 375, 290);
        
        botaoABP = new JButton("ÁRVORE BINÁRIA");
		botaoABP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ABP_GUI();
			}
		});
        addButton(botaoABP, 375, 340);
        
        botaoSobre = new JButton("SOBRE");
		botaoSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                new TelaSobre();
			}
		});
        addButton(botaoSobre, 240, 400);
        botaoSobre.setForeground(Color.WHITE);
        botaoSobre.setBackground(new Color(255, 162, 173));
        botaoSobre.setBounds(350, 430, 100, 30);
        botaoSobre.setFont(new Font("Courier", Font.BOLD, 18));
        
        botaoQuit = new JButton("SAIR");
		botaoQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
        addButton(botaoQuit, 510, 400);
        botaoQuit.setForeground(new Color(215, 61, 23));
        botaoQuit.setBackground(Color.WHITE);
        botaoQuit.setBounds(550, 430, 100, 30);
        botaoQuit.setFont(new Font("Courier", Font.BOLD, 18));
    }

    public ImageIcon scaleImage(ImageIcon icon, int w, int h) {
        int nw = icon.getIconWidth();
        int nh = icon.getIconHeight();

        if(icon.getIconWidth() > w)
        {
          nw = w;
          nh = (nw * icon.getIconHeight()) / icon.getIconWidth();
        }

        if(nh > h)
        {
          nh = h;
          nw = (icon.getIconWidth() * nh) / icon.getIconHeight();
        }

        return new ImageIcon(icon.getImage().getScaledInstance(nw, nh, Image.SCALE_DEFAULT));
    }
    
    private void addButton(JButton button, int x, int y) {
        button.setForeground(Color.BLACK);
        button.setBackground(Color.WHITE);
        button.setBounds(x, y, 250, 30);
        button.setFont(new Font("Courier", Font.PLAIN, 18));
        button.setFocusable(false);
        contentPane.add(button);
    }

    public static void main(String[] args) {
        new JanelaPrincipal();
    }

}
