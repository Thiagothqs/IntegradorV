package com.projetov.model;

import java.util.ArrayList;
import java.util.InputMismatchException;

import com.projetov.service.ClienteService;

public class ValidadorCPF {
	
	public static boolean isCPF(String CPF) {

		String CPF_FORMATADO = CPF.replaceAll("[.-]", "");// Tira a mascara do cpf para vereficar

		if (vereficaCPF_Cadastrado(CPF) == true) {
			System.out.println("CPF J� CADASTRADO");
			return false;
		}

		// considera-se erro CPF's formados por uma sequencia de numeros iguais
		if (CPF_FORMATADO.equals("00000000000") || CPF_FORMATADO.equals("11111111111")
				|| CPF_FORMATADO.equals("22222222222") || CPF_FORMATADO.equals("33333333333")
				|| CPF_FORMATADO.equals("44444444444") || CPF_FORMATADO.equals("55555555555")
				|| CPF_FORMATADO.equals("66666666666") || CPF_FORMATADO.equals("77777777777")
				|| CPF_FORMATADO.equals("88888888888") || CPF_FORMATADO.equals("99999999999")
				|| (CPF_FORMATADO.length() != 11))
			return (false);

		char dig10, dig11;
		int sm, i, r, num, peso;

		try {
			// Calculo do 1o. Digito Verificador
			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {
				// converte o i-esimo caractere do CPF em um numero:
				// por exemplo, transforma o caractere '0' no inteiro 0
				// (48 eh a posicao de '0' na tabela ASCII)
				num = (int) (CPF_FORMATADO.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 = (char) (r + 48); // converte no respectivo caractere numerico

			// Calculo do 2o. Digito Verificador
			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (CPF_FORMATADO.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char) (r + 48);

			// Verifica se os digitos calculados conferem com os digitos informados.
			if ((dig10 == CPF_FORMATADO.charAt(9)) && (dig11 == CPF_FORMATADO.charAt(10)))
				return (true);
			else
				return (false);
		} catch (InputMismatchException erro) {
			return (false);
		}
	}

	public static String imprimeCPF(String CPF_FORMATADO) {
		return (CPF_FORMATADO.substring(0, 3) + "." + CPF_FORMATADO.substring(3, 6) + "."
				+ CPF_FORMATADO.substring(6, 9) + "-" + CPF_FORMATADO.substring(9, 11));
	}
		    	  
	public static boolean vereficaCPF_Cadastrado(String CPF) {
		ClienteService jogadorService = new ClienteService();
		ArrayList<Cliente> listJogador = (ArrayList<Cliente>) jogadorService.listarClientes();

		for (int i = 0; i < listJogador.size(); i++) {
			if (listJogador.get(i).getCpf().equals(CPF)) {
				return true;
			}
		}
		return false;
	}
}


