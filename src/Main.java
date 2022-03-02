import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		String a;
		RedesController redController = new RedesController();
		String os = redController.os();
		System.out.println("Sistema Operacional: " + os);
		System.out.println("");
		
		do {
			
			a = JOptionPane.showInputDialog("Se você deseja Executar o metodo ip digite: 1  \nCaso você deseje executar o metodo ping digite: 2\nCaso você deseje fechar o programa clique em cancelar");
			
			if (a.contains("1")) {
				redController.ip(os);
			}
			
			if (a.contains("2")) {
				redController.ping(os);
			}
			
		}while(a != null);

		
	}

}
