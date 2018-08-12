package com.fabriciomagalhaes.cursomc.resources.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//classe auxiliar para tratar parametos vindos nas requisições
public class URL {
	
	//metodo para transformar a String que veio como parametro em uma lista de Integers
	public static List<Integer> decodeIntList(String s){
		
		return Arrays.asList(s.split(",")).stream().map(x -> Integer.parseInt(x)).collect(Collectors.toList());
		
	}
	
	//metodo para decodificar parametos recebidos
	public static String decodeParam(String s) {
		try {
			return URLDecoder.decode(s, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}

}
