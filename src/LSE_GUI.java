import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.lang.Math;

public class LSE_GUI extends JDialog {
    
    private JPanel contentPanel = new JPanel();
    private LSE lista = new LSE();

    private int valor;
    private int pos;

    private JLabel elementos[] = new JLabel[12];
    private JLabel setas[] = new JLabel[11];

    public LSE_GUI() {
        
        paintCabecalho();
        infoPanel();

        this.setModal(true);
		this.setBounds(0, 0, 1000, 600);
		this.setLocation(250, 50);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(contentPanel, BorderLayout.CENTER);
        this.setVisible(true);
    }

    private void paintCabecalho() {
        contentPanel.setBackground(new Color(191, 228, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(null);
        contentPanel.setBounds(0, 0, 1000, 600);
        contentPanel.setVisible(true);

        ImageIcon iconLSE = new ImageIcon("imagens/tasks2.png");
        iconLSE = scaleImage(iconLSE, 85, 85);
        
        JLabel l_icon = new JLabel();
        l_icon.setForeground(new Color(34, 38, 45));
		l_icon.setFont(new Font("Courier", Font.BOLD, 25));
        l_icon.setIcon(iconLSE);
        l_icon.setBounds(865, 485, 85, 70);
        l_icon.setVisible(true);
        this.getContentPane().add(l_icon);
        
        JLabel titulo = new JLabel("LISTA SIMPLESMENTE ENCADEADA");
        titulo.setForeground(new Color(34, 38, 45));
		titulo.setFont(new Font("Courier", Font.BOLD, 25));
        titulo.setBounds(30, 0, 700, 80);
        titulo.setVisible(true);
        this.getContentPane().add(titulo);

        ImageIcon lixeira = new ImageIcon("Projeto-Final---ED-master/imagens/garbage.png");
        lixeira = scaleImage(lixeira, 18, 18);

        JButton b_limpar = new JButton();
        b_limpar.setIcon(lixeira);
        b_limpar.setBounds(880, 30, 30, 30);
        b_limpar.setBackground(Color.WHITE);
        b_limpar.setAlignmentX(CENTER_ALIGNMENT);
        b_limpar.setAlignmentY(CENTER_ALIGNMENT);
        b_limpar.setFocusable(false);
        b_limpar.setVisible(true);
        this.getContentPane().add(b_limpar);
        b_limpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpar();
                atualizaInfoPanel();
            }
        });
        
        ImageIcon home = new ImageIcon("Projeto-Final---ED-master/imagens/home-page.png");
        home = scaleImage(home, 18, 18);
        
        JButton b_homepage = new JButton();
        b_homepage.setIcon(home);
        b_homepage.setBounds(920, 30, 30, 30);
        b_homepage.setBackground(Color.WHITE);
        b_homepage.setAlignmentX(CENTER_ALIGNMENT);
        b_homepage.setAlignmentY(CENTER_ALIGNMENT);
        b_homepage.setFocusable(false);
        b_homepage.setVisible(true);
        this.getContentPane().add(b_homepage);
        b_homepage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void infoPanel() {
        JLabel info_text =  new JLabel();
        info_text.setText("<html> <p>cabeça: </p> <p>tamanho: </p> </html>");
        info_text.setBounds(50, 80, 130, 60);
        info_text.setForeground(new Color(34, 38, 45));
        info_text.setFont(new Font("Courier", Font.PLAIN, 18));
        this.getContentPane().add(info_text);
        
        JLabel info = new JLabel();
        info.setBounds(30, 80, 200, 60);
        info.setBackground(Color.LIGHT_GRAY);
        info.setOpaque(true);
        this.getContentPane().add(info);

        paintOp();
    }

    private void atualizaInfoPanel() {
        JLabel infos = new JLabel("");

        if(lista.tamanho() == 0) {
            contentPanel.add(infos);
            infos.setBounds(170, 80, 60, 60);
            infos.setOpaque(true);
            infos.setBackground(Color.LIGHT_GRAY);
            infos.setVisible(true);
        } else {
            contentPanel.add(infos);
            infos.setText("<html> <p>" + lista.elemento(1) + "</p> <p>" + lista.tamanho() + "</p> </html>");
            infos.setBounds(170, 80, 30, 60);
            infos.setForeground(new Color(34, 38, 45));
            infos.setFont(new Font("Courier", Font.BOLD, 18));
            infos.setHorizontalAlignment(SwingConstants.RIGHT);
            infos.setOpaque(true);
            infos.setBackground(Color.LIGHT_GRAY);
            infos.setVisible(true);
        }
    }

    private void paintOp() {

        // INSERIR
        JButton b_inserir = new JButton("Inserir");
        b_inserir.setForeground(new Color(34, 38, 45));
        b_inserir.setBackground(Color.WHITE);
        b_inserir.setBounds(30, 170, 120, 30);
        b_inserir.setFont(new Font("Courier", Font.PLAIN, 18));
        b_inserir.setFocusable(false);
        this.getContentPane().add(b_inserir);
        
        JLabel l_inserir = new JLabel();
        l_inserir.setBounds(50, 210, 180, 60);
        l_inserir.setBorder(BorderFactory.createLoweredBevelBorder());
        l_inserir.setOpaque(false);
        this.getContentPane().add(l_inserir);
        
        JLabel t_inserir = new JLabel("<html> <p>Posição: </p> <p>Elemento: </p> </html>");
        t_inserir.setBounds(60, 210, 160, 60);
        t_inserir.setFont(new Font("Courier", Font.PLAIN, 18));
        t_inserir.setForeground(new Color(34, 38, 45));
        t_inserir.setHorizontalAlignment(SwingConstants.LEADING);
        t_inserir.setVerticalAlignment(SwingConstants.CENTER);
        this.getContentPane().add(t_inserir);
        
        JTextArea i_posicao = new JTextArea();
        i_posicao.setBounds(185, 220, 30, 18);
        i_posicao.setAlignmentX(CENTER_ALIGNMENT);
        this.getContentPane().add(i_posicao);
        
        JTextArea i_elemento = new JTextArea();
        i_elemento.setBounds(185, 245, 30, 18);
        i_elemento.setAlignmentX(CENTER_ALIGNMENT);
        this.getContentPane().add(i_elemento);

        b_inserir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String i_txtValor = i_elemento.getText();
                String i_txtPos = i_posicao.getText();
                try {
                    if(i_txtValor.equals("") || i_txtPos.equals("")) {
                        JOptionPane.showMessageDialog(null, "Preencha todos os campos", "[ERRO] CAMPO(S) VAZIO(S)", JOptionPane.WARNING_MESSAGE);
                    }
                    if(!i_txtValor.equals("") && !i_txtPos.equals("")) {
                        valor = Integer.parseInt(i_txtValor);
                        pos = Integer.parseInt(i_txtPos);
                        if(pos <= 0 || pos > (lista.tamanho() + 1)) {
                            JOptionPane.showMessageDialog(null, "Digite uma posição válida", "[ERRO] POSIÇÃO INVÁLIDA", JOptionPane.WARNING_MESSAGE);
                        } else if (pos > 12 || lista.tamanho() == 12) {
                            JOptionPane.showMessageDialog(null, "O limite máximo da lista foi atingido", "[ERRO] LISTA CHEIA", JOptionPane.WARNING_MESSAGE);
                        } else {
                            inserir(valor, pos);
                        }
                    }
                } catch(Exception e1) {
                    JOptionPane.showMessageDialog(null, "Digite um elemento válido", "[ERRO] ELEMENTO INVÁLIDO", JOptionPane.WARNING_MESSAGE);
                }
                i_elemento.setText("");
                i_posicao.setText("");
                atualizaInfoPanel();
            }
        });
        
        // REMOVER
        JButton b_remover = new JButton("Remover");
        b_remover.setForeground(new Color(34, 38, 45));
        b_remover.setBackground(Color.WHITE);
        b_remover.setBounds(30, 295, 120, 30);
        b_remover.setFont(new Font("Courier", Font.PLAIN, 18));
        b_remover.setFocusable(false);
        this.getContentPane().add(b_remover);
        
        JLabel l_remover = new JLabel();
        l_remover.setBounds(50, 335, 180, 35);
        l_remover.setBorder(BorderFactory.createLoweredBevelBorder());
        l_remover.setOpaque(false);
        this.getContentPane().add(l_remover);
        
        JLabel t_remover = new JLabel("<html> <p>Posição: </p> </html>");
        t_remover.setBounds(60, 335, 160, 30);
        t_remover.setFont(new Font("Courier", Font.PLAIN, 18));
        t_remover.setForeground(new Color(34, 38, 45));
        t_remover.setHorizontalAlignment(SwingConstants.LEADING);
        t_remover.setVerticalAlignment(SwingConstants.CENTER);
        this.getContentPane().add(t_remover);
        
        JTextArea r_posicao = new JTextArea();
        r_posicao.setBounds(185, 345, 30, 18);
        r_posicao.setAlignmentX(CENTER_ALIGNMENT);
        this.getContentPane().add(r_posicao);
    
        b_remover.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String r_txtPos = r_posicao.getText();
                try {
                    if(r_txtPos.equals("")) {
                        JOptionPane.showMessageDialog(null, "Preencha o campo Posição", "[ERRO] CAMPO VAZIO", JOptionPane.WARNING_MESSAGE);
                    }
                    if(!r_txtPos.equals("")) {
                        pos = Integer.parseInt(r_txtPos);
                        if(pos <= 0 || pos > lista.tamanho()) {
                            JOptionPane.showMessageDialog(null, "Digite uma posição válida", "[ERRO] POSIÇÃO INVÁLIDA", JOptionPane.WARNING_MESSAGE);
                        } else {
                            remover(valor, pos);
                        }
                    }
                } catch(Exception e1) {
                    JOptionPane.showMessageDialog(null, "ERRO", "", JOptionPane.WARNING_MESSAGE);
                    System.out.println("erro " + e1);
                }
                r_posicao.setText("");
                atualizaInfoPanel();
            }
        });
        
        // BUSCAR
        JButton b_buscar = new JButton("Buscar");
        b_buscar.setForeground(new Color(34, 38, 45));
        b_buscar.setBackground(Color.WHITE);
        b_buscar.setBounds(30, 395, 120, 30);
        b_buscar.setFont(new Font("Courier", Font.PLAIN, 18));
        b_buscar.setFocusable(false);
        this.getContentPane().add(b_buscar);
        
        JLabel l_buscar = new JLabel();
        l_buscar.setBounds(50, 435, 180, 60);
        l_buscar.setBorder(BorderFactory.createLoweredBevelBorder());
        l_buscar.setOpaque(false);
        this.getContentPane().add(l_buscar);
        
        JLabel t_buscar = new JLabel("<html> <p>Posição: </p> <p>Elemento: </p> </html>");
        t_buscar.setBounds(60, 435, 160, 60);
        t_buscar.setFont(new Font("Courier", Font.PLAIN, 18));
        t_buscar.setForeground(new Color(34, 38, 45));
        t_buscar.setHorizontalAlignment(SwingConstants.LEADING);
        t_buscar.setVerticalAlignment(SwingConstants.CENTER);
        this.getContentPane().add(t_buscar);
        
        JTextArea b_posicao = new JTextArea();
        b_posicao.setBounds(185, 445, 30, 18);
        b_posicao.setAlignmentX(CENTER_ALIGNMENT);
        this.getContentPane().add(b_posicao);
        
        JTextArea b_elemento = new JTextArea();
        b_elemento.setBounds(185, 470, 30, 18);
        b_elemento.setAlignmentX(CENTER_ALIGNMENT);
        this.getContentPane().add(b_elemento);
        
        b_buscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String b_txtValor = b_elemento.getText();
                String b_txtPos = b_posicao.getText();
                try {
                    if(b_txtValor.equals("") && b_txtPos.equals("")) {
                        JOptionPane.showMessageDialog(null, "Preencha um dos campos", "[ERRO] CAMPO VAZIO", JOptionPane.WARNING_MESSAGE);
                    }
                    if(!b_txtPos.equals("")) {
                        pos = Integer.parseInt(b_txtPos);
                        valor = -1;
                        if(pos <= 0 || pos > lista.tamanho()) {
                            JOptionPane.showMessageDialog(null, "Digite uma posição válida", "[ERRO] POSIÇÃO INVÁLIDA", JOptionPane.WARNING_MESSAGE);
                        } else {
                            buscar(valor, pos);
                        }
                    }
                    if(!b_txtValor.equals("")) {
                        valor = Integer.parseInt(b_txtValor);
                        pos = -1;
                        buscar(valor, pos);
                    }
                } catch(Exception e1) {
                    JOptionPane.showMessageDialog(null, "Digite um elemento válido", "[ERRO] ELEMENTO INVÁLIDO", JOptionPane.WARNING_MESSAGE);
                }
                b_elemento.setText("");
                b_posicao.setText("");
            }
        });
    }

    private void inserir(int valor, int pos) {
        lista.insere(pos, valor);
        if(pos == lista.tamanho() && pos == 1) {
            paintElem(pos, valor);
        } else if (pos == lista.tamanho() && pos > 1) {
            paintSeta(pos-1);
            paintElem(pos, valor);
        } else if (pos != lista.tamanho() && pos > 1) {
            paintElem(lista.tamanho(), valor);
            paintSeta(lista.tamanho() - 1);
            for(int i = lista.tamanho(); i > (pos-1); i--) {
                elementos[i-1].setText(elementos[i-2].getText());
            }
            elementos[pos-1].setText("" + valor);
        } else if (pos != lista.tamanho() && pos == 1) {
            paintElem(lista.tamanho(), valor);
            paintSeta(lista.tamanho() - 1);
            for(int i = lista.tamanho(); i > pos; i--) {
                elementos[i-1].setText(elementos[i-2].getText());
            }
            elementos[0].setText("" + valor);
        }
    }

    private void remover(int valor, int pos) {
        String removido = "";

        if(pos == lista.tamanho() && pos > 1) {
            removido = elementos[pos-1].getText();
            elementos[pos-1].setVisible(false);
            setas[pos-2].setVisible(false);
            contentPanel.remove(elementos[pos-1]);
        } else if (pos == lista.tamanho() && pos == 1) {
            removido = elementos[pos-1].getText();
            elementos[pos-1].setVisible(false);
            contentPanel.remove(elementos[pos-1]);
        } else if (pos != lista.tamanho() && pos >= 1) {
            removido = elementos[pos-1].getText();
            int tam = lista.tamanho();
            for(int i = pos; i < tam; i++) {
                elementos[i-1].setText(elementos[i].getText());
            }
            elementos[tam-1].setVisible(false);
            setas[tam-2].setVisible(false);
            contentPanel.remove(elementos[tam-1]);
        }
        
        JOptionPane.showMessageDialog(null, "Elemento removido: " + removido, "", JOptionPane.INFORMATION_MESSAGE);
        lista.remove(pos);
    }
    
    private void buscar(int valor, int pos) {
        int elemento = -1;
        int posicao = -1;

        if(pos == -1 && valor != -1) {
            posicao = lista.posicao(valor);
            if(posicao == -1) {
                JOptionPane.showMessageDialog(null, "Elemento não inserido na lista", "[ERRO] ELEMENTO INEXISTENTE", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Posição do elemento " + valor + " => " + posicao, "", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if(valor == -1 && pos != -1) {
            elemento = lista.elemento(pos);
            JOptionPane.showMessageDialog(null, "Elemento na posição " + pos + " => " + elemento, "", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void paintElem(int pos, int valor) {
        int lin = 1;
        int x = 0, y = 0;
        
        if((pos % 4) == 0) {
            lin = Math.floorDiv(pos, 4);
        } else {
            lin = Math.floorDiv(pos, 4) + 1;
        }
        
        if((lin % 2) != 0) {
            x = 320 + (160 * ((pos-(4*(lin-1)))-1));
        } else if ((lin % 2) == 0) {
            x = 800 - (160 * ((pos-(4*(lin-1)))-1));
        }
        y = 80 + (140 * (lin-1));
        
        JLabel elem =  new JLabel("" + valor);
        elementos[pos-1] = elem;
        contentPanel.add(elementos[pos-1]);
        elementos[pos-1].setBounds(x, y, 80, 60);
        elementos[pos-1].setFont(new Font("Courier", Font.BOLD, 25));
        elementos[pos-1].setForeground(new Color(34, 38, 45));
        elementos[pos-1].setBackground(Color.WHITE);
        elementos[0].setBackground(Color.LIGHT_GRAY);
        elementos[pos-1].setBorder(BorderFactory.createLineBorder(new Color(34, 38, 45)));
        elementos[pos-1].setHorizontalAlignment(SwingConstants.CENTER);
        elementos[pos-1].setOpaque(true);
        elementos[pos-1].setVisible(true);
    }
    
    private void paintSeta(int pos) {
        int lin = 1;
        int x = 0, y = 0;
        ImageIcon icon_seta = new ImageIcon();

        if((pos % 4) == 0) {
            lin = Math.floorDiv(pos, 4);
        } else {
            lin = Math.floorDiv(pos, 4) + 1;
        }
        
        if((lin % 2) != 0) {
            x = 415 + (160 * ((pos-(4*(lin-1)))-1));
            icon_seta = new ImageIcon("imagens/right-arrow.png");
        } else if ((lin % 2) == 0) {
            x = 735 - (160 * ((pos-(4*(lin-1)))-1));
            icon_seta = new ImageIcon("imagens/left-arrow.png");
        }
        y = 85 + (140 * (lin-1));
        
        if((pos % 4) == 0) {
            icon_seta = new ImageIcon("imagens/down-arrow.png");
            if(((pos/4) % 2) == 1) {
                x = 815;
                y = 155;
            } else if (((pos/4) % 2) == 0) {
                x = 335;
                y = 295;
            }
        }

        icon_seta = scaleImage(icon_seta, 50, 50);

        JLabel l_seta = new JLabel();
        setas[pos-1] = l_seta;
        contentPanel.add(setas[pos-1]);
        setas[pos-1].setIcon(icon_seta);
        setas[pos-1].setBounds(x, y, 50, 50);
        setas[pos-1].setVisible(true);
    }

    private void limpar() {
        if(lista.tamanho() == 0) {
            this.getContentPane().repaint();
        } else if (lista.tamanho() == 1) {
            elementos[0].setVisible(false);
            contentPanel.remove(elementos[0]);
            lista.remove(1);
            limpar();
        } else {
            for(int i = lista.tamanho(); i > 1; i--) {
                elementos[i-1].setVisible(false);
                setas[i-2].setVisible(false);
                contentPanel.remove(elementos[i-1]);
                lista.remove(i);
            }
            limpar();
        }
    }

    private ImageIcon scaleImage(ImageIcon icon, int w, int h) {
        int nw = icon.getIconWidth();
        int nh = icon.getIconHeight();

        if(icon.getIconWidth() > w) {
          nw = w;
          nh = (nw * icon.getIconHeight()) / icon.getIconWidth();
        }

        if(nh > h) {
          nh = h;
          nw = (icon.getIconWidth() * nh) / icon.getIconHeight();
        }

        return new ImageIcon(icon.getImage().getScaledInstance(nw, nh, Image.SCALE_DEFAULT));
    }

    public static void main(String[] args) {
        try {
			LSE_GUI LSE = new LSE_GUI();
			LSE.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			LSE.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
