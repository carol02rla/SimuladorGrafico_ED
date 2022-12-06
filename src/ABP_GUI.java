import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ABP_GUI extends JDialog {

    private JPanel contentPanel = new JPanel();
    private ABP abp = new ABP();

    private int valor;
    private int pos;

    private JLabel elementos[] = new JLabel[15];
    private JLabel linhas[] = new JLabel[14];

    public ABP_GUI() {
        paintCabecalho();
        infoPanel();

        // paintElem(1, 1);
        // paintLinha(1, 0);
        // paintLinha(1, 1);
        // paintElem(2, 2);
        // paintLinha(2, 0);
        // paintLinha(2, 1);
        // paintElem(3, 3);
        // paintLinha(3, 0);
        // paintLinha(3, 1);
        // paintElem(4, 4);
        // paintLinha(4, 0);
        // paintLinha(4, 1);
        // paintElem(5, 5);
        // paintLinha(5, 0);
        // paintLinha(5, 1);
        // paintElem(6, 6);
        // paintLinha(6, 0);
        // paintLinha(6, 1);
        // paintElem(7, 7);
        // paintLinha(7, 0);
        // paintLinha(7, 1);
        // paintElem(8, 8);
        // paintElem(9, 9);
        // paintElem(10, 10);
        // paintElem(11, 11);
        // paintElem(12, 12);
        // paintElem(13, 13);
        // paintElem(14, 14);
        // paintElem(15, 15);

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

        // ImageIcon iconABP = new ImageIcon("imagens/diagram2.png");
        // iconABP = scaleImage(iconABP, 85, 85);
        
        // JLabel l_icon = new JLabel();
        // l_icon.setForeground(new Color(34, 38, 45));
		// l_icon.setFont(new Font("Courier", Font.BOLD, 25));
        // l_icon.setIcon(iconABP);
        // // l_icon.setBounds(880, 475, 700, 80);
        // l_icon.setBounds(30, 55, 100, 80);
        // l_icon.setVisible(true);
        // this.getContentPane().add(l_icon);
        
        JLabel titulo = new JLabel("ÁRVORE BINÁRIA DE PESQUISA");
        titulo.setForeground(new Color(34, 38, 45));
		titulo.setFont(new Font("Courier", Font.BOLD, 25));
        titulo.setBounds(30, 0, 700, 80);
        titulo.setVisible(true);
        this.getContentPane().add(titulo);

        ImageIcon lixeira = new ImageIcon("imagens/garbage.png");
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
                // limpar();
                // atualizaInfoPanel();
            }
        });
        
        ImageIcon home = new ImageIcon("imagens/home-page.png");
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
        info_text.setText("<html> <p>pre-ordem: </p> <p>in-ordem: </p> <p>pos-ordem: </p> </html>");
        info_text.setBounds(50, 452, 130, 90);
        info_text.setForeground(new Color(34, 38, 45));
        info_text.setFont(new Font("Courier", Font.PLAIN, 18));
        this.getContentPane().add(info_text);
        
        JLabel info = new JLabel();
        info.setBounds(30, 452, 300, 90);
        info.setBackground(Color.LIGHT_GRAY);
        info.setOpaque(true);
        this.getContentPane().add(info);

        paintOp();
    }

    private void paintOp() {

        // INSERIR
        JButton b_inserir = new JButton("Inserir");
        b_inserir.setForeground(new Color(34, 38, 45));
        b_inserir.setBackground(Color.WHITE);
        b_inserir.setBounds(360, 460, 120, 30);
        b_inserir.setFont(new Font("Courier", Font.PLAIN, 18));
        b_inserir.setFocusable(false);
        this.getContentPane().add(b_inserir);
        
        JLabel l_inserir = new JLabel();
        l_inserir.setBounds(380, 500, 160, 35);
        l_inserir.setBorder(BorderFactory.createLoweredBevelBorder());
        l_inserir.setOpaque(false);
        this.getContentPane().add(l_inserir);
        
        JLabel t_inserir = new JLabel("<html> <p>Elemento: </p> </html>");
        t_inserir.setBounds(390, 500, 140, 35);
        t_inserir.setFont(new Font("Courier", Font.PLAIN, 18));
        t_inserir.setForeground(new Color(34, 38, 45));
        t_inserir.setHorizontalAlignment(SwingConstants.LEADING);
        t_inserir.setVerticalAlignment(SwingConstants.CENTER);
        this.getContentPane().add(t_inserir);
        
        JTextArea i_elemento = new JTextArea();
        i_elemento.setBounds(500, 509, 30, 18);
        i_elemento.setAlignmentX(CENTER_ALIGNMENT);
        this.getContentPane().add(i_elemento);

        b_inserir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String i_txtValor = i_elemento.getText();
                try {
                    valor = Integer.parseInt(i_txtValor);
                    if(i_txtValor.equals("")) {
                        JOptionPane.showMessageDialog(null, "Preencha o campo Elemento", "[ERRO] CAMPO VAZIO", JOptionPane.WARNING_MESSAGE);
                    } else if(abp.busca(valor) == null) {
                        inserir(valor);
                    } else if(abp.busca(valor) != null) {
                        System.out.println("Elem " + abp.busca(valor).getConteudo());
                        JOptionPane.showMessageDialog(null, "Valor " + i_txtValor + " já inserido na árvore", "[ERRO] INSERÇÃO INVÁLIDA", JOptionPane.WARNING_MESSAGE);
                    }
                } catch(Exception e1) {
                    JOptionPane.showMessageDialog(null, "Digite um elemento válido", "[ERRO] ELEMENTO INVÁLIDO", JOptionPane.WARNING_MESSAGE);
                }
                i_elemento.setText("");
                // atualizaInfoPanel();
            }
        });
        
        // REMOVER
        JButton b_remover = new JButton("Remover");
        b_remover.setForeground(new Color(34, 38, 45));
        b_remover.setBackground(Color.WHITE);
        b_remover.setBounds(560, 460, 120, 30);
        b_remover.setFont(new Font("Courier", Font.PLAIN, 18));
        b_remover.setFocusable(false);
        this.getContentPane().add(b_remover);
        
        JLabel l_remover = new JLabel();
        l_remover.setBounds(580, 500, 160, 35);
        l_remover.setBorder(BorderFactory.createLoweredBevelBorder());
        l_remover.setOpaque(false);
        this.getContentPane().add(l_remover);
        
        JLabel t_remover = new JLabel("<html> <p>Elemento: </p> </html>");
        t_remover.setBounds(590, 500, 140, 35);
        t_remover.setFont(new Font("Courier", Font.PLAIN, 18));
        t_remover.setForeground(new Color(34, 38, 45));
        t_remover.setHorizontalAlignment(SwingConstants.LEADING);
        t_remover.setVerticalAlignment(SwingConstants.CENTER);
        this.getContentPane().add(t_remover);
        
        JTextArea r_elemento = new JTextArea();
        r_elemento.setBounds(700, 509, 30, 18);
        r_elemento.setAlignmentX(CENTER_ALIGNMENT);
        this.getContentPane().add(r_elemento);
    
        b_remover.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String r_txtElem = r_elemento.getText();
                try {
                    if(r_txtElem.equals("")) {
                        JOptionPane.showMessageDialog(null, "Preencha o campo Elemento", "[ERRO] CAMPO VAZIO", JOptionPane.WARNING_MESSAGE);
                    }
                    if(!r_txtElem.equals("")) {
                        valor = Integer.parseInt(r_txtElem);
                        remover(valor);
                    }
                } catch(Exception e1) {
                    JOptionPane.showMessageDialog(null, "ERRO", "", JOptionPane.WARNING_MESSAGE);
                    System.out.println("erro " + e1);
                }
                r_elemento.setText("");
                // atualizaInfoPanel();
            }
        });
        
        // BUSCAR
        JButton b_buscar = new JButton("Buscar");
        b_buscar.setForeground(new Color(34, 38, 45));
        b_buscar.setBackground(Color.WHITE);
        b_buscar.setBounds(760, 460, 120, 30);
        b_buscar.setFont(new Font("Courier", Font.PLAIN, 18));
        b_buscar.setFocusable(false);
        this.getContentPane().add(b_buscar);
        
        JLabel l_buscar = new JLabel();
        l_buscar.setBounds(780, 500, 160, 35);
        l_buscar.setBorder(BorderFactory.createLoweredBevelBorder());
        l_buscar.setOpaque(false);
        this.getContentPane().add(l_buscar);
        
        JLabel t_buscar = new JLabel("<html> <p>Elemento: </p> </html>");
        t_buscar.setBounds(790, 500, 140, 35);
        t_buscar.setFont(new Font("Courier", Font.PLAIN, 18));
        t_buscar.setForeground(new Color(34, 38, 45));
        t_buscar.setHorizontalAlignment(SwingConstants.LEADING);
        t_buscar.setVerticalAlignment(SwingConstants.CENTER);
        this.getContentPane().add(t_buscar);
        
        JTextArea b_elemento = new JTextArea();
        b_elemento.setBounds(900, 509, 30, 18);
        b_elemento.setAlignmentX(CENTER_ALIGNMENT);
        this.getContentPane().add(b_elemento);
        
        b_buscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String r_txtElem = r_elemento.getText();
                try {
                    if(r_txtElem.equals("")) {
                        JOptionPane.showMessageDialog(null, "Preencha o campo Elemento", "[ERRO] CAMPO VAZIO", JOptionPane.WARNING_MESSAGE);
                    }
                    if(!r_txtElem.equals("")) {
                        valor = Integer.parseInt(r_txtElem);
                        remover(valor);
                    }
                } catch(Exception e1) {
                    JOptionPane.showMessageDialog(null, "ERRO", "", JOptionPane.WARNING_MESSAGE);
                    System.out.println("erro " + e1);
                }
                r_elemento.setText("");
            }
        });
    }
    
    private void inserir(int valor) {
        if(abp.vazia()) {
            pos = 1;
            paintElem(pos, valor);
        } else {
            pos += 1;
            paintLinha(pos-1, 0);
            paintLinha(pos-1, 1);
            paintElem(pos, valor);
        }
        
        abp.insere(valor);
    }

    private void remover(int valor) {
        pos -= 1;
    }
    
    private void buscar(int valor, int pos) {
        
    }

    private void paintElem(int pos, int valor) {
        // int lin = 1;
        int x = 0, y = 0;

        if(pos == 1) { x = 450; y = 70;  }
        if(pos == 2) { x = 220; y = 180; }
        if(pos == 3) { x = 680; y = 180; }
        if(pos == 4) { x = 105; y = 280; }
        if(pos == 5) { x = 335; y = 280; }
        if(pos == 6) { x = 565; y = 280; }
        if(pos == 7) { x = 795; y = 280; }
        if(pos == 8) { x = 30;  y = 370; }
        if(pos == 9) { x = 150; y = 370; }
        if(pos == 10) { x = 270; y = 370; }
        if(pos == 11) { x = 390; y = 370; }
        if(pos == 12) { x = 510; y = 370; }
        if(pos == 13) { x = 630; y = 370; }
        if(pos == 14) { x = 750; y = 370; }
        if(pos == 15) { x = 870; y = 370; }
        
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
    
    private void paintLinha(int pos, int filho) {
        // int lin = 1;
        int x = 0, y = 0;
        int w = 0, h = 0;
        String path = "";
        
        if(filho == 0) {
            if(pos == 1) { x = 260; y = 130; path = "imagens/Line1_esq.png"; w = 231; h = 51; }
            if(pos == 2) { x = 145; y = 240; path = "imagens/Line2_esq.png"; w = 116; h = 41; } 
            if(pos == 3) { x = 605; y = 240; path = "imagens/Line2_esq.png"; w = 116; h = 41; } 
            if(pos == 4) { x = 70; y = 340; path = "imagens/Line4_esq.png"; w = 76; h = 31; } 
            if(pos == 5) { x = 310; y = 340; path = "imagens/Line5_esq.png"; w = 66; h = 31; } 
            if(pos == 6) { x = 550; y = 340; path = "imagens/Line6_esq.png"; w = 56; h = 31; } 
            if(pos == 7) { x = 790; y = 340; path = "imagens/Line7_esq.png"; w = 47; h = 31; }
        } else if (filho == 1) {
            if(pos == 1) { x = 490; y = 130; path = "imagens/Line1_dir.png"; w = 231; h = 51; }
            if(pos == 2) { x = 260; y = 240; path = "imagens/Line2_dir.png"; w = 116; h = 41; } 
            if(pos == 3) { x = 720; y = 240; path = "imagens/Line2_dir.png"; w = 116; h = 41; } 
            if(pos == 4) { x = 145; y = 340; path = "imagens/Line4_dir.png"; w = 47; h = 31; } 
            if(pos == 5) { x = 375; y = 340; path = "imagens/Line5_dir.png"; w = 56; h = 31; } 
            if(pos == 6) { x = 605; y = 340; path = "imagens/Line6_dir.png"; w = 66; h = 31; } 
            if(pos == 7) { x = 835; y = 340; path = "imagens/Line7_dir.png"; w = 76; h = 31; }
        }
        
        ImageIcon icon_linha = new ImageIcon(path);
        JLabel l_linha = new JLabel();
        linhas[pos-1] = l_linha;
        contentPanel.add(linhas[pos-1]);
        linhas[pos-1].setIcon(icon_linha);
        linhas[pos-1].setBounds(x, y, w, h);
        linhas[pos-1].setVisible(true);
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
        new ABP_GUI();
    }
}
