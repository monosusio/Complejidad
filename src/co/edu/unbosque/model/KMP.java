package co.edu.unbosque.model;

class KMP {
	
	void KMP(String pat, String txt) {
		int longitudPalabra = pat.length();
		int longitudTexto = txt.length();
		int contador = 0;
		int j = 0;
		int i = 0;
		while ((longitudTexto - i) >= (longitudPalabra - j)) {

			if (pat.charAt(j) == txt.charAt(i)) {
				j++;
			}
			if (j == longitudPalabra) {
				System.out.println("Found pattern " + "at index " + (i - j + 1));
				contador++;
				j = 0;

			}
			i++;
		}
		System.out.println(contador);
	}

	public static void main(String args[]) {
		String txt = "eeeaea";
		String pat = "e";
		new KMP().KMP(pat, txt);
	}
	
}
