package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;



public class Bm {
	
	public static final int ALPHABET_SIZE = 256;
	private int[] bmBC;
	private int[] bmGs;
	public int comparisons;

// 2
	public void preBmBc(char[] x) {

		int m = x.length;
		bmBC = new int[ALPHABET_SIZE];

		Arrays.fill(bmBC, m);

		for (int i = 0; i < m - 1; i++) {
			bmBC[x[i]] = m - i - 1;
		}

	}

	public int[] suffixes(char[] x) {

		int m = x.length;
		int suff[] = new int[m];
		int g = m - 1;
		int f = m - 1;

		suff[m - 1] = m;

		for (int i = m - 2; i >= 0; --i) {
			if (i > g && (i + m - 1 - f) < m && suff[i + m - 1 - f] < i - g) {
				suff[i] = suff[i + m - 1 - f];
			} else {

				g = i;

				f = g;

				while (g >= 0 && x[g] == x[g + m - 1 - f]) {
					--g;
				}

				suff[i] = f - g;

			}
		}

		return suff;
	}

// 2
	public void preBmGs(char[] x) {

		int m = x.length;
		bmGs = new int[m];

		int suff[] = suffixes(x);

		Arrays.fill(bmGs, m);

		int j = 0;

		for (int i = m - 1; i >= -1; --i) {
			if (i == -1 || suff[i] == i + 1) {
				for (; j < m - 1 - i; ++j) {
					if (bmGs[j] == m) {
						bmGs[j] = m - 1 - i;
					}
				}
			}
		}

		for (int i = 0; i < m - 1; i++) {
			bmGs[m - 1 - suff[i]] = m - 1 - i;
		}

	}

// 1

	public List<Integer> search(String texto, String busqueda) {

//Convierte el texto original y el de busqueda en List diferentes
		char[] y = texto.toCharArray();
		char[] x = busqueda.toCharArray();
		int n = y.length; // tamaño del texto original
		int m = x.length; // tamaño del texto de busqueda
		List<Integer> resultado = new ArrayList<Integer>();// Array de los resultados

		int j = 0;
		int i = 0;
		comparisons = 0;

		// Se transforma y se asignan valores a la List de busqueda
		preBmBc(x);
		preBmGs(x);

		// Se realiza el proceso de busqueda del txt
		while (j <= n - m) {
			for (i = m - 1; i >= 0 && x[i] == y[i + j]; i--) {
				comparisons++;
			}

			if (i < 0) {
				resultado.add(j);
				j += bmGs[0];
			} else {
				j += Math.max(bmGs[i], bmBC[y[i + j]] - m + 1 + i);
			}

		}

		return resultado;
	}

}
