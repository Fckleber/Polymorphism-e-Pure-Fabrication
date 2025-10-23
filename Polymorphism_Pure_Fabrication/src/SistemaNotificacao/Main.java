package SistemaNotificacao;

public class Main {
	public static void main(String[] args) {
		// Objeto de Domínio
		Pedido pedido = new Pedido("P1234", "cliente@email.com", "5511987654321");
		// Pure Fabrication (o objeto "inventado")
		ServicoNotificacao notificador = new ServicoNotificacao();

		String mensagem = "Seu pedido " + pedido.getId() + " foi ATUALIZADO.";
		// --- cenario 1: notificação por whatsapp ---

		Notificacao Whatsapp = new NotificacaoWhatsApp();

		pedido.setStatus("INICIADO");
		notificador.notificar(pedido.getClienteTelefone(), mensagem + "Novo Status: " + pedido.getStatus(), Whatsapp);
		// --- Cenário 2: Notificação por Email ---

		// Objeto de Notificação (Implementação Específica)
		Notificacao email = new NotificacaoEmail();

		// O ServicoNotificacao recebe a implementação Email (Polimorfismo)
		pedido.setStatus("EM SEPARAÇÃO");
		notificador.notificar(pedido.getClienteEmail(), mensagem + " Novo Status: " + pedido.getStatus(), email);
		// --- Cenário 3: Notificação por SMS ---

		// Trocamos o objeto de Notificação. O código do ServicoNotificacao NÃO MUDOU.
		Notificacao sms = new NotificacaoSms();

		// O ServicoNotificacao recebe a implementação SMS (Polimorfismo)
		pedido.setStatus("ENTREGUE");
		notificador.notificar(pedido.getClienteTelefone(), mensagem + " Novo Status: " + pedido.getStatus(), sms);

		// Objeto de Domínio
		Pedido pedido2 = new Pedido("P6790", "cliente2@email.com", "5521999998888");
		String mensagem2 = "Seu pedido " + pedido2.getId() + " foi ATUALIZADO.";
		// Pure Fabrication (o objeto "inventado")
		// --- cenario 1: notificação por whatsapp ---

		Notificacao Whatsapp1 = new NotificacaoWhatsApp();

		pedido2.setStatus("INICIADO");
		notificador.notificar(pedido2.getClienteTelefone(), mensagem2 + "Novo Status: " + pedido2.getStatus(), Whatsapp1);

		// --- Cenário 2: Notificação por Email ---

		// Objeto de Notificação (Implementação Específica)
		Notificacao email2 = new NotificacaoEmail();

		// O ServicoNotificacao recebe a implementação Email (Polimorfismo)
		pedido2.setStatus("EM SEPARAÇÃO");
		notificador.notificar(pedido2.getClienteEmail(), mensagem2 + " Novo Status: " + pedido2.getStatus(), email2);
		// --- cenario 4: notificação por whatsapp ---

		Notificacao Whatsapp2 = new NotificacaoWhatsApp();
		pedido2.setStatus("CANCELADO");
		notificador.notificar(pedido2.getClienteTelefone(), mensagem2 + "Novo Status: " + pedido2.getStatus(),
				Whatsapp2);
	}
}
