// classe que cuida da validacao do login
// separei aqui pra nao misturar com o codigo da tela
public class Autenticador {

    // deixei usuario e senha fixos porque eh so uma simulacao academica
    // num projeto real isso ficaria em banco de dados ou arquivo seguro
    private static final String USUARIO_VALIDO = "admin";
    private static final String SENHA_VALIDA = "1234";

    // metodo que compara o que o usuario digitou com os valores fixos
    // retorna true se bateu, false se nao bateu
    public static boolean validar(String usuario, String senha) {
        // uso .equals porque comparar String com == nao funciona direito
        return USUARIO_VALIDO.equals(usuario) && SENHA_VALIDA.equals(senha);
    }
}
