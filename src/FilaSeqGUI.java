import java.awt.Font;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;


public class FilaSeqGUI extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private static FilaSeq fila = new FilaSeq();
    private JButton posicoes[] = new JButton[10];

    public static void main(String[] args) {
        try {
            FilaSeqGUI dialog = new FilaSeqGUI();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public FilaSeqGUI() {

        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
        }

        setBounds(300, 100, 950, 500);
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setBackground(new Color(191, 228, 255));
        contentPanel.setLayout(null);

        JLabel lblFilaSeq = new JLabel("FILA SEQUENCIAL");
        lblFilaSeq.setForeground(new Color(0, 0, 0));
        lblFilaSeq.setFont(new Font("Courier", Font.BOLD, 25));
        lblFilaSeq.setBounds(30, 0, 700, 80);
        lblFilaSeq.setVisible(true);
        contentPanel.add(lblFilaSeq);

        JButton botaoFilaInserir = new JButton("Inserir");
        botaoFilaInserir.setBackground(new Color(0, 85, 90));
        botaoFilaInserir.setForeground(Color.WHITE);
        botaoFilaInserir.setFont(new Font("Courier", Font.BOLD, 18));
        botaoFilaInserir.setBounds(30, 130, 115, 30);
        contentPanel.add(botaoFilaInserir);

        ImageIcon home = new ImageIcon("Projeto-Final---ED-master/imagens/home-page.png");
        home = scaleImage(home, 18, 18);

        JButton b_homepage = new JButton();
        b_homepage.setIcon(home);
        b_homepage.setBounds(850, 30, 30, 30);
        b_homepage.setBackground(Color.WHITE);
        b_homepage.setAlignmentX(CENTER_ALIGNMENT);
        b_homepage.setAlignmentY(CENTER_ALIGNMENT);
        b_homepage.setFocusable(false);
        b_homepage.setVisible(true);
        contentPanel.add(b_homepage);
        b_homepage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        botaoFilaInserir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!fila.cheia()) {
                    JOptionPane input = new JOptionPane();
                    String conteudo = input.showInputDialog("Novo Elemento:");
                    if (conteudo != null && (conteudo.length()) > 0) {
                        try {
                            int valor = Integer.parseInt(conteudo);

                            int fim = fila.getFim();
                            fim = (fim + 1) % 10;
                            posicoes[fim].setText(conteudo);
                            posicoes[fim].setFont(new Font("Segoe UI", Font.PLAIN, 18));

                            fila.insere(valor);
                        } catch (Exception e1) {
                            JOptionPane.showMessageDialog(null, "Digite um elemento válido", "Erro",
                                    JOptionPane.WARNING_MESSAGE);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Fila cheia!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton botaoFilaRemover = new JButton("Remover");
        botaoFilaRemover.setForeground(Color.WHITE);
        botaoFilaRemover.setFont(new Font("Courier", Font.BOLD, 18));
        botaoFilaRemover.setBackground(new Color(0, 85, 90));
        botaoFilaRemover.setBounds(30, 180, 115, 30);
        contentPanel.add(botaoFilaRemover);

        botaoFilaRemover.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!fila.vazia()) {
                    int inicio = fila.getInicio();
                    String removido = posicoes[inicio].getText();
                    try {
                        posicoes[inicio].setText("");
                        inicio = (inicio) % 10;
                        fila.remove();

                        JOptionPane.showMessageDialog(null, "Elemento removido: " + removido, "Removido",
                                JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception e2) {
                        JOptionPane.showMessageDialog(null, "Último elemento removido: " +
                                removido, "Vazia!", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Fila vazia!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton botaoFilaBuscar = new JButton("Buscar");
        botaoFilaBuscar.setBackground(new Color(0, 85, 90));
        botaoFilaBuscar.setForeground(Color.WHITE);
        botaoFilaBuscar.setFont(new Font("Courier", Font.BOLD, 18));
        botaoFilaBuscar.setBounds(30, 230, 115, 30);
        contentPanel.add(botaoFilaBuscar);

        botaoFilaBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!fila.vazia()) {
                    int inicio = fila.getInicio();
                    String buscar = posicoes[inicio].getText();
                    inicio = (inicio + 1) % 10;
                    fila.primeiro();
                    JOptionPane.showMessageDialog(null, "Primeiro elemento da fila: " + buscar, "Busca",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Fila vazia!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Posições do array

        posicoes[0] = new JButton("");
        posicoes[0].setBackground(Color.WHITE);
        posicoes[0].setBounds(200, 170, 70, 70);
        contentPanel.add(posicoes[0]);

        posicoes[1] = new JButton("");
        posicoes[1].setBackground(Color.WHITE);
        posicoes[1].setBounds(270, 170, 70, 70);
        contentPanel.add(posicoes[1]);

        posicoes[2] = new JButton("");
        posicoes[2].setBackground(Color.WHITE);
        posicoes[2].setBounds(340, 170, 70, 70);
        contentPanel.add(posicoes[2]);

        posicoes[3] = new JButton("");
        posicoes[3].setBackground(Color.WHITE);
        posicoes[3].setBounds(410, 170, 70, 70);
        contentPanel.add(posicoes[3]);

        posicoes[4] = new JButton("");
        posicoes[4].setBackground(Color.WHITE);
        posicoes[4].setBounds(480, 170, 70, 70);
        contentPanel.add(posicoes[4]);

        posicoes[5] = new JButton("");
        posicoes[5].setBackground(Color.WHITE);
        posicoes[5].setBounds(550, 170, 70, 70);
        contentPanel.add(posicoes[5]);

        posicoes[6] = new JButton("");
        posicoes[6].setBackground(Color.WHITE);
        posicoes[6].setBounds(620, 170, 70, 70);
        contentPanel.add(posicoes[6]);

        posicoes[7] = new JButton("");
        posicoes[7].setBackground(Color.WHITE);
        posicoes[7].setBounds(690, 170, 70, 70);
        contentPanel.add(posicoes[7]);

        posicoes[8] = new JButton("");
        posicoes[8].setBackground(Color.WHITE);
        posicoes[8].setBounds(760, 170, 70, 70);
        contentPanel.add(posicoes[8]);

        posicoes[9] = new JButton("");
        posicoes[9].setBackground(Color.WHITE);
        posicoes[9].setBounds(830, 170, 70, 70);
        contentPanel.add(posicoes[9]);
    }

    //private ImageIcon scaleImage(ImageIcon home, int i, int j) {
      //  return null;
    //}
    
    private ImageIcon scaleImage(ImageIcon home, int i, int j) {
        int ni = home.getIconWidth();
        int nj = home.getIconHeight();

        if(home.getIconWidth() > i) {
          ni = i;
          nj = (ni * home.getIconHeight()) / home.getIconWidth();
        

        if(nj > j) {
          nj = j;
          ni = (home.getIconWidth() * nj) / home.getIconHeight();
        }

        return new ImageIcon(home.getImage().getScaledInstance(ni, nj, Image.SCALE_DEFAULT));
    }
        return home; 
    }
}
