package view;

import controller.SapoThread;

public class Principal5 {
	static int num_sapos = 5;
	static int dist = 100;
	
	public static void main(String[] args) {
		for (int i = 1; i <= num_sapos; i++) {
			new SapoThread("Sapo " + i, dist).start();
		}

	}
	
}
