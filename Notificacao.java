package SistemaNotificacao;

public interface Notificacao {
	// Este é o método que será implementado de formas diferentes (Polimorfismo)
	void enviar(String destinatario, String mensagem);
}
