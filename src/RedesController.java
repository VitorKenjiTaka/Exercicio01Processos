import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	
	public String os(){
		String os = System.getProperty("os.name");
		return os;
		
	}
	
	public void ip(String os) {
		String ipconf = "IPCONFIG";
		String ifconf = "IFCONFIG";
		
		
		if (os.contains("Windows")) {
			
			try {
				
				Process p = Runtime.getRuntime().exec(ipconf);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				
				while(linha != null) {
					
					if (linha.contains("Ethernet")) {
						System.out.println(linha);
					}
						
					if (linha.contains("IPv4")) {
						System.out.println(linha);
						System.out.println(" ");
					}
					
					linha = buffer.readLine();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
			
		}else {
			
			try {
				
				Process p = Runtime.getRuntime().exec(ifconf);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				
				while(linha != null) {
					
					if (linha.contains("Ethernet")) {
						System.out.println(linha);
					}
						
					if (linha.contains("IPv4")) {
						System.out.println(linha);
						System.out.println(" ");
					}
					
					linha = buffer.readLine();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	public void ping(String os) {
		String pingWind = "PING -4 -n 10 www.google.com.br";
		String pingLin = "PING -4 -c 10 www.google.com.br"; 
		int total1 = 0;
		int cont = 0;
		
		if (os.contains("Windows")) {
			
			try {
				
				Process p = Runtime.getRuntime().exec(pingWind);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				
				while (linha != null) {
					
					if (linha.contains("tempo=")) {
						
						String[] vetFrase = linha.split("tempo=");
						for (String palavra : vetFrase) {
							
							if (palavra.contains("ms")) {
								
								String[] vetoFrase = palavra.split("");
								
								String num = vetoFrase[0] + vetoFrase[1];
								
								int n = Integer.parseInt(num);
								
								total1 = total1 + n;
								cont = cont + 1;
								int media = total1 / cont;
								System.out.println("média em tempo real é: " + media);
								
							}
							
							
						}
						
					}
					
					linha = buffer.readLine();
					
				}
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}else {
			
try {
				
				Process p = Runtime.getRuntime().exec(pingLin);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				
				while (linha != null) {
					
					if (linha.contains("tempo=")) {
						
						String[] vetFrase = linha.split("tempo=");
						for (String palavra : vetFrase) {
							
							if (palavra.contains("ms")) {
								
								String[] vetoFrase = palavra.split("");
								
								String num = vetoFrase[0] + vetoFrase[1];
								
								int n = Integer.parseInt(num);
								
								total1 = total1 + n;
								cont = cont + 1;
								int media = total1 / cont;
								System.out.println("média em tempo real é: " + media);
							}
						}
					}
					
					linha = buffer.readLine();
				}	
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
}
