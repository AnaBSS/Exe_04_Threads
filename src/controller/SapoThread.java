package controller;

public class SapoThread extends Thread {
     
	String nome;
	int distCorrida = 0;
	int dist_totalCorrida;
	int pulo = 0;
	int qnt_pulo = 0;
	static int colocacao = 0;
	final static int pulo_max = 50;
	
	public SapoThread (String nome, int dist_totalCorrida) {
		super (nome);
		this.dist_totalCorrida = dist_totalCorrida;
		this.nome = nome;
	}
	
	public void SapoSituacao () {
		System.out.println("O " + nome + " pulou " + pulo + "m e já percorreu " + distCorrida + " m");
	}
	
	public void SapoPulando () {
		qnt_pulo++;
		pulo = (int) (Math.random() * pulo_max);
		distCorrida += pulo;
		if (distCorrida > dist_totalCorrida) {
			distCorrida = dist_totalCorrida;
		}
	}
	
	public void SapoDescanso () {
		try {
			sleep (1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void SapoColocacao () {
		colocacao ++;
		System.out.println(nome + " foi o " + colocacao + "º colocado com " + qnt_pulo + " pulos");
	}
	
	public void run () {
		while (distCorrida < dist_totalCorrida) {
			SapoPulando ();
			SapoSituacao ();
			SapoDescanso ();
		}
		SapoColocacao ();
	}
}
