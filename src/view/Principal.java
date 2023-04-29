package view;

import java.io.IOException;

import controller.GenericFoodController;
import controller.IArquivosController;

public class Principal {

	public static void main(String[] args) {
		IArquivosController genFoodCont = new GenericFoodController();
		String path = "C:\\TEMP", arquivo = "generic_food.csv";
		
		try {
			genFoodCont.lerArquivo(path, arquivo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
