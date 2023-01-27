import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

//bug parte de remoção


public class ListaSeqGUI extends JFrame{
    private JPanel contentPane;
    private ListaSeq lista = new ListaSeq();
    private JButton[] pBtn = new JButton[10];
    /**
     * 
     */
    public static void main(String[] args){
        try{
            ListaSeqGUI dialog = new ListaSeqGUI();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public ListaSeqGUI(){
        this.setBounds(100, 100, 1000, 600);
        this.setLocation(250,50);
        this.setTitle("Lista Sequencial");
        this.setDefaultCloseOperation( DISPOSE_ON_CLOSE);
        this.setBackground(new Color(191, 228,255));
    
        contentPane = new JPanel();
        contentPane .setSize(800,500);
        contentPane.setBackground(new Color(191, 228,255));
        contentPane.setLayout(null);
        this.setVisible(true);
        this.setContentPane(contentPane);

        JLabel lblLS = new JLabel("Lista Sequencial");
        lblLS.setBounds(389,11,250,58);
        lblLS.setForeground(new Color(0,0,0));
        lblLS.setFont(new Font("Courier", Font.CENTER_BASELINE, 24));
        contentPane.add(lblLS);
        
        // ImageIcon lixeira = new ImageIcon("imagens/garbage.png");
        // lixeira = scaleImage(lixeira, 18, 18);

        // JButton b_limpar = new JButton();
        // b_limpar.setIcon(lixeira);
        // b_limpar.setBounds(880, 30, 30, 30);
        // b_limpar.setBackground(Color.WHITE);
        // b_limpar.setAlignmentX(CENTER_ALIGNMENT);
        // b_limpar.setAlignmentY(CENTER_ALIGNMENT);
        // b_limpar.setFocusable(false);
        // b_limpar.setVisible(true);
        // contentPane.add(b_limpar);
        // b_limpar.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e) {
        //         limpar();
                
        //     }
        // });

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
        contentPane.add(b_homepage);
        b_homepage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        JButton btnInserir = new JButton("Inserir");
        btnInserir.setFont(new Font("Courrier", Font.BOLD, 18));
        btnInserir.setForeground(new Color(255,255,255));
        btnInserir.setBackground(new Color(154,205,50));
        btnInserir.setBounds(75,75,120,50);
        btnInserir.setBorder(null);
        contentPane.add(btnInserir);
     

        JButton btnRemover = new JButton("Remover");
        btnRemover.setFont(new Font("Courrier", Font.BOLD, 18));
        btnRemover.setForeground(new Color(255,255,255));
        btnRemover.setBackground(new Color(255,69,0));
        btnRemover.setBounds(75,150,120,50);
        btnRemover.setBorder(null);
        contentPane.add(btnRemover);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setFont(new Font("Courrier", Font.BOLD, 18));
        btnBuscar.setForeground(new Color(255,255,255));
        btnBuscar.setBackground(new Color(65,105,225));
        btnBuscar.setBounds(75,225,120,50);
        btnBuscar.setBorder(null);
        contentPane.add(btnBuscar);
    
     
    
    
        btnInserir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JOptionPane input = new JOptionPane();
                String conteudo = input.showInputDialog("Novo Elemento");
                String indice = input.showInputDialog("Posição do novo elemento");
                int tamanho = lista.tamanhoAtual();
                 if(conteudo!=null && indice!= null){
                     try{
                        int posicao = Integer.parseInt(indice);
                        int valor = Integer.parseInt(conteudo);
                        if(lista.insere(posicao,valor)){
                            for(int i = tamanho; i >= posicao; i--){
                                String p = pBtn[i-1].getText();
                                pBtn[i].setText(p);
                            }
                            pBtn[posicao-1].setText(""+valor);
                            
                        }
                        else if(pBtn[9].isShowing()){
                            JOptionPane.showMessageDialog(null,"Operação Inválida","ERRO",JOptionPane.ERROR_MESSAGE);
                        }
                        else{
                            dispose();
                        }
                    }catch(Exception ex) {}
               }
                

            }

        });

        btnRemover.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    if(!lista.vazia()){
                        JOptionPane input = new JOptionPane();
                        String conteudo = input.showInputDialog("Remover elemento na posição:");
                        int posicao = Integer.parseInt(conteudo);
                        int rem = lista.remove(posicao);
                        int tamanho = lista.tamanhoAtual();
                       boolean vazia = lista.vazia();

                        if(rem == -1){
                            JOptionPane.showMessageDialog(null,"Posição inválida!","Erro", JOptionPane.WARNING_MESSAGE);
                        }
                        else{
                            for(int i = (posicao-1); i < tamanho; i++){
                                String r = pBtn[i+1].getText();
                                pBtn[i].setText(r);
                                pBtn[i+1].setText("");
                            }
                            JOptionPane.showMessageDialog(null,"Elemento removido com sucesso","Sucesso",JOptionPane.INFORMATION_MESSAGE );
                        }

                    }else{
                        JOptionPane.showMessageDialog(null,"A Lista Sequencial está vazia","Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }catch(Exception ex){}
            }
        });
        btnBuscar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(!lista.vazia()){
                    JOptionPane input = new JOptionPane();
                        String conteudo = input.showInputDialog("Buscar elemento:");
                        int elBuscado = Integer.parseInt(conteudo);
                        int res = lista.posicao(elBuscado);
                    if(res != -1){
                        JOptionPane.showMessageDialog(null,"Elemento está na posição: "+ res,"Resultado",JOptionPane.INFORMATION_MESSAGE );
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Elemento não encontrado ","Atenção",JOptionPane.WARNING_MESSAGE );
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"A Lista Sequencial está vazia","Erro", JOptionPane.ERROR_MESSAGE);
                }


            }
        });


        pBtn[0] = new JButton("");
        pBtn[0].setBackground(Color.WHITE);
        pBtn[0].setBounds(117,300,73,72);
        contentPane.add(pBtn[0]);
        
        pBtn[1] = new JButton("");
        pBtn[1].setBackground(Color.WHITE);
        pBtn[1].setBounds(192,300,73,72);
        contentPane.add(pBtn[1]);
        
        pBtn[2] = new JButton("");
        pBtn[2].setBackground(Color.WHITE);
        pBtn[2].setBounds(263,300,73,72);
        contentPane.add(pBtn[2]);
        
        pBtn[3] = new JButton("");
        pBtn[3].setBackground(Color.WHITE);
        pBtn[3].setBounds(336,300,73,72);
        contentPane.add(pBtn[3]);
        
        pBtn[4] = new JButton("");
        pBtn[4].setBackground(Color.WHITE);
        pBtn[4].setBounds(409,300,73,72);
        contentPane.add(pBtn[4]);
        
        pBtn[5] = new JButton("");
        pBtn[5].setBackground(Color.WHITE);
        pBtn[5].setBounds(482,300,73,72);
        contentPane.add(pBtn[5]);
        
        pBtn[6] = new JButton("");
        pBtn[6].setBackground(Color.WHITE);
        pBtn[6].setBounds(555,300,73,72);
        contentPane.add(pBtn[6]);
        
        pBtn[7] = new JButton("");
        pBtn[7].setBackground(Color.WHITE);
        pBtn[7].setBounds(628,300,73,72);
        contentPane.add(pBtn[7]);
        
        pBtn[8] = new JButton("");
        pBtn[8].setBackground(Color.WHITE);
        pBtn[8].setBounds(701,300,73,72);
        contentPane.add(pBtn[8]);
        
        pBtn[9] = new JButton("");
        pBtn[9].setBackground(Color.WHITE);
        pBtn[9].setBounds(774,300,73,72);
        contentPane.add(pBtn[9]);
    
    }

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
