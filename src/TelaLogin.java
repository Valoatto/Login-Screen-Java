import javax.swing.*;
import java.awt.*;

// janela com o formulario de login
public class TelaLogin extends JFrame {

    // campos que preciso acessar em mais de um metodo
    private JTextField campoUsuario;
    private JPasswordField campoSenha;

    // paleta de cores escolhida pra deixar o visual clean
    private final Color CORFUNDO = new Color(245, 245, 245);
    private final Color CORAZUL = new Color(74, 144, 226);
    private final Color CORTEXTO = new Color(50, 50, 50);
    private final Color CORTEXTOFRACO = new Color(120, 120, 120);
    private final Color CORBORDA = new Color(220, 220, 220);

    public TelaLogin() {
        configurarJanela();
        montarFormulario();
    }

    // configuracoes basicas da janela
    private void configurarJanela() {
        setTitle("Login");
        setSize(380, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // centraliza na tela
        setResizable(false);
        getContentPane().setBackground(CORFUNDO);
        setLayout(new BorderLayout());
    }

    // monta o formulario de login no centro da tela
    private void montarFormulario() {
        // uso BoxLayout vertical pra empilhar os componentes de cima pra baixo
        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
        painel.setBackground(CORFUNDO);
        painel.setBorder(BorderFactory.createEmptyBorder(50, 40, 40, 40));

        // titulo no topo
        JLabel titulo = new JLabel("Bem-vindo");
        titulo.setFont(new Font("SansSerif", Font.BOLD, 26));
        titulo.setForeground(CORTEXTO);
        titulo.setAlignmentX(Component.LEFT_ALIGNMENT);
        painel.add(titulo);

        // subtitulo logo embaixo do titulo
        JLabel subtitulo = new JLabel("Faca login para continuar");
        subtitulo.setFont(new Font("SansSerif", Font.PLAIN, 13));
        subtitulo.setForeground(CORTEXTOFRACO);
        subtitulo.setAlignmentX(Component.LEFT_ALIGNMENT);
        subtitulo.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
        painel.add(subtitulo);

        // espaco vertical antes dos campos
        painel.add(Box.createRigidArea(new Dimension(0, 30)));

        // label do campo usuario
        painel.add(criarLabel("Usuario"));
        painel.add(Box.createRigidArea(new Dimension(0, 5)));

        // campo de texto do usuario
        campoUsuario = new JTextField();
        estilizarCampo(campoUsuario);
        painel.add(campoUsuario);

        painel.add(Box.createRigidArea(new Dimension(0, 15)));

        // label do campo senha
        painel.add(criarLabel("Senha"));
        painel.add(Box.createRigidArea(new Dimension(0, 5)));

        // campo de senha (mostra asteriscos automaticamente)
        campoSenha = new JPasswordField();
        estilizarCampo(campoSenha);
        // permito fazer login apertando Enter no campo de senha
        campoSenha.addActionListener(e -> tentarLogin());
        painel.add(campoSenha);

        painel.add(Box.createRigidArea(new Dimension(0, 30)));

        // botao entrar
        JButton botaoEntrar = new JButton("Entrar");
        botaoEntrar.setFont(new Font("SansSerif", Font.BOLD, 14));
        botaoEntrar.setBackground(CORAZUL);
        botaoEntrar.setForeground(Color.WHITE);
        botaoEntrar.setFocusPainted(false);
        botaoEntrar.setBorderPainted(false);
        botaoEntrar.setOpaque(true);
        botaoEntrar.setBorder(BorderFactory.createEmptyBorder(12, 20, 12, 20));
        botaoEntrar.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));
        botaoEntrar.setAlignmentX(Component.LEFT_ALIGNMENT);
        botaoEntrar.addActionListener(e -> tentarLogin());
        painel.add(botaoEntrar);

        add(painel, BorderLayout.CENTER);
    }

    // metodo auxiliar pra criar os labels dos campos com o mesmo estilo
    private JLabel criarLabel(String texto) {
        JLabel label = new JLabel(texto);
        label.setFont(new Font("SansSerif", Font.PLAIN, 13));
        label.setForeground(CORTEXTO);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        return label;
    }

    // aplica o estilo nos campos de texto (usuario e senha)
    // fiz separado pra os dois ficarem com o mesmo visual
    private void estilizarCampo(JTextField campo) {
        campo.setFont(new Font("SansSerif", Font.PLAIN, 14));
        campo.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(CORBORDA, 1),
            BorderFactory.createEmptyBorder(8, 10, 8, 10)
        ));
        campo.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        campo.setAlignmentX(Component.LEFT_ALIGNMENT);
    }

    // metodo que eh chamado quando o usuario clica em entrar
    // ou aperta enter no campo de senha
    private void tentarLogin() {
        String usuario = campoUsuario.getText().trim();
        // o getPassword devolve um array de char por questao de seguranca
        // entao converto pra String pra comparar
        String senha = new String(campoSenha.getPassword());

        // primeiro verifico se algum campo esta vazio
        if (usuario.isEmpty() || senha.isEmpty()) {
            mostrarAviso("Por favor, preencha usuario e senha.");
            return;
        }

        // se os campos estao preenchidos, tento autenticar
        if (Autenticador.validar(usuario, senha)) {
            mostrarSucesso("Login realizado com sucesso.");
            abrirTelaInicial(usuario);
        } else {
            mostrarErro("Usuario ou senha invalidos.");
            // limpo so a senha pra usuario tentar de novo
            campoSenha.setText("");
        }
    }

    // abre a tela inicial e fecha a tela de login
    private void abrirTelaInicial(String usuario) {
        TelaInicial tela = new TelaInicial(usuario);
        tela.setVisible(true);
        this.dispose(); // fecha esta janela
    }

    // metodos pra mostrar mensagens na tela
    // uso JOptionPane que ja vem pronto com o swing
    private void mostrarAviso(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Atencao",
            JOptionPane.WARNING_MESSAGE);
    }

    private void mostrarErro(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Erro",
            JOptionPane.ERROR_MESSAGE);
    }

    private void mostrarSucesso(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Sucesso",
            JOptionPane.INFORMATION_MESSAGE);
    }
}
