import javax.swing.*;
import java.awt.*;
public class miniBanco {
  static double saldo = 1000.00;
  public static void main(String[] args ) {
   JFrame janela = new JFrame("MINI BANCO");
   janela.setSize(800, 600);
   janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   janela.setLocationRelativeTo(null);
   janela.setLayout(new BorderLayout());

   

   
   JPanel inicio = new JPanel(new FlowLayout());
   JLabel texto = new JLabel("OI SEJA BEM VINDO");
   JLabel mostraSaldo = new JLabel("SALDO R$ 1000.00");
   JButton botao = new JButton("DEPOSITA");
   JButton sacar = new JButton("SACAR");
   JTextField valores = new JTextField(10);
   JTextArea mostraExtrato = new JTextArea(5, 15);
   mostraExtrato.setEditable(false);

    mostraExtrato.setLineWrap(true);

    mostraExtrato.setWrapStyleWord(true);



   JScrollPane rolagem = new JScrollPane(mostraExtrato);

   rolagem.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);


   rolagem.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);


   
   

   janela.add(texto, BorderLayout.NORTH);
   janela.add(mostraSaldo, BorderLayout.CENTER);
   inicio.add(botao);
   inicio.add(valores);
   inicio.add(sacar);
   janela.add(inicio, BorderLayout.SOUTH);
   janela.add(rolagem, BorderLayout.WEST);
   

    



    // dentro //

    botao.addActionListener(e ->{
      JOptionPane.showMessageDialog(janela, "seja bem vindo ao banco");
        

       String texto1 = valores.getText();
       if (texto1.isEmpty()) {
        JOptionPane.showMessageDialog(janela, "Digite um valor!");
        

        return;
       }

      try {

        double valor = Double.parseDouble(texto1);


        if (valor > 0) {
           saldo += valor; 
          
           mostraSaldo.setText("SALDO: R$ " + saldo);
           mostraExtrato.append("DEPOSITO: R$ " + valor + "\n"

           );
           JOptionPane.showMessageDialog(janela, "DEPOSITO REALIZADO COM SUCESSO!");

           valores.setText("");
           


        } else {
           JOptionPane.showMessageDialog(janela, "DIGITE UM VALOR MAIOR QUE ZERO!");
        }


      } catch (NumberFormatException erro) {
          JOptionPane.showMessageDialog(janela, "DIGITE SOMENTE NUMEROS!");
      }

    });

     sacar.addActionListener(e ->{
      String texto1 = valores.getText();

      if (texto1.isEmpty()){
      JOptionPane.showMessageDialog(janela , "DIGITE VALOR UM VALOR!");
      return;
      }
      try {
        double valor = Double.parseDouble(texto1);

        if (valor > 0 && valor <= saldo) {
          saldo -= valor; 

          mostraSaldo.setText("SALDO: R& " + saldo);

          mostraExtrato.append("SAQUE: R$ " + valor + "\n"

          );

          JOptionPane.showMessageDialog(janela, "SAQUE REALIZADO COM SUCESSO!"

          );

          valores.setText("");
        } else {
          JOptionPane.showMessageDialog(janela, "VALOR INVALIDO OU SALDO INSUFICIENTE!");
        }


      } catch (NumberFormatException erro) {
         JOptionPane.showMessageDialog(janela, "DIGITE SOMENTE NUMEROS!");
      }

     });

     

  
    janela.setVisible(true);
  }
}