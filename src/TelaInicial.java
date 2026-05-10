import javax.swing.*;
import java.awt.*;

// tela que aparece depois que o usuario faz login com sucesso
// fiz simples so pra mostrar que o fluxo funcionou
public class TelaInicial extends JFrame {

    private final Color CORFUNDO = new Color(245, 245, 245);
    private final Color CORTEXTO = new Color(50, 50, 50);
    private final Color CORTEXTOFRACO = new Color(120, 120, 120);
    private final Color CORVERMELHA = new Color(220, 100, 100);

    // recebo o nome do usuario pra personalizar a mensagem
    public TelaInicial(String nomeUsuario) {
        configurarJanela();
        montarConteudo(nomeUsuario);
    }

    private void configurarJanela() {
        setTitle("Inicio");
        setSize(380, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(CORFUNDO);
        setLayout(new BorderLayout());
    }

    private void montarConteudo(String nomeUsuario) {
        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
        painel.setBackground(CORFUNDO);
        painel.setBorder(BorderFactory.createEmptyBorder(50, 40, 40, 40));

        // titulo
        JLabel titulo = new JLabel("Login realizado");
        titulo.setFont(new Font("SansSerif", Font.BOLD, 24));
        titulo.setForeground(CORTEXTO);
        titulo.setAlignmentX(Component.LEFT_ALIGNMENT);
        painel.add(titulo);

        // mensagem com o nome do usuario que fez login
        JLabel mensagem = new JLabel("Ola, " + nomeUsuario + ".");
        mensagem.setFont(new Font("SansSerif", Font.PLAIN, 14));
        mensagem.setForeground(CORTEXTOFRACO);
        mensagem.setAlignmentX(Component.LEFT_ALIGNMENT);
        mensagem.setBorder(BorderFactory.createEmptyBorder(8, 0, 0, 0));
        painel.add(mensagem);

        JLabel mensagem2 = new JLabel("Voce acessou a area do sistema.");
        mensagem2.setFont(new Font("SansSerif", Font.PLAIN, 13));
        mensagem2.setForeground(CORTEXTOFRACO);
        mensagem2.setAlignmentX(Component.LEFT_ALIGNMENT);
        mensagem2.setBorder(BorderFactory.createEmptyBorder(4, 0, 0, 0));
        painel.add(mensagem2);

        // empurra o botao sair pra parte de baixo da tela
        painel.add(Box.createVerticalGlue());

        // botao sair, que volta pra tela de login
        JButton botaoSair = new JButton("Sair");
        botaoSair.setFont(new Font("SansSerif", Font.BOLD, 14));
        botaoSair.setBackground(CORVERMELHA);
        botaoSair.setForeground(Color.WHITE);
        botaoSair.setFocusPainted(false);
        botaoSair.setBorderPainted(false);
        botaoSair.setOpaque(true);
        botaoSair.setBorder(BorderFactory.createEmptyBorder(12, 20, 12, 20));
        botaoSair.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));
        botaoSair.setAlignmentX(Component.LEFT_ALIGNMENT);
        botaoSair.addActionListener(e -> sair());
        painel.add(botaoSair);

        add(painel, BorderLayout.CENTER);
    }

    // fecha esta tela e abre a tela de login de novo
    private void sair() {
        TelaLogin tela = new TelaLogin();
        tela.setVisible(true);
        this.dispose();
    }
}
