package br.com.alura.screematch_spring;

import br.com.alura.screematch_spring.model.DadosSerie;
import br.com.alura.screematch_spring.services.ConsumoApi;
import br.com.alura.screematch_spring.services.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreematchSpringApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreematchSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("http://www.omdbapi.com/?t=The+Originals&apikey=92dab9e4");
		System.out.println(json);
//		json = consumoApi.obterDados("https://coffee.alexflipnote.dev/random.json"); //Imagem de Café
//		System.out.println(json);
		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);

	}
}
