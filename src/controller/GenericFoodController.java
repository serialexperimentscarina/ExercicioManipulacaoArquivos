package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class GenericFoodController implements IArquivosController{

	public GenericFoodController() {
		super();
	}

	@Override
	public void lerArquivo(String path, String arquivo) throws IOException {
		File csv = new File(path, arquivo);
		
		if(csv.exists() && csv.isFile()) {
			FileInputStream abreFluxo = new FileInputStream(csv);
			InputStreamReader leFluxo = new InputStreamReader(abreFluxo);
			BufferedReader buffer = new BufferedReader(leFluxo);
			String linha = buffer.readLine();
			
			while (linha != null) {
				String[] vetLinha = linha.split(",");
				if (vetLinha[0].equals("FOOD NAME") || vetLinha[2].toLowerCase().contains("fruit")) {
					System.out.printf("%-50s", vetLinha[0]);
					System.out.printf("%-50s", (vetLinha[1].equals("NULL") ? "---" : vetLinha[1]));
					System.out.printf("%-50s", vetLinha[3]);
					System.out.println("");
				}
				linha = buffer.readLine();
			}
			
			buffer.close();
			leFluxo.close();
			abreFluxo.close();
		} else {
			System.out.println("Path ou arquivo inválidos");
		}
		
	}

}
