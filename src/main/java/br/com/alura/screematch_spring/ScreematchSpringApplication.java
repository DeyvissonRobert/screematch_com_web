package br.com.alura.screematch_spring;

import br.com.alura.screematch_spring.model.DadosEpisodio;
import br.com.alura.screematch_spring.model.DadosSerie;
import br.com.alura.screematch_spring.model.DadosTemporada;
import br.com.alura.screematch_spring.services.ConsumoApi;
import br.com.alura.screematch_spring.services.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

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
		json = consumoApi.obterDados("http://www.omdbapi.com/?t=The+Originals&season=1&episode=2&apikey=92dab9e4");
		DadosEpisodio dadosEpisodio = conversor.obterDados(json, DadosEpisodio.class);
		System.out.println(dadosEpisodio);

		List<DadosTemporada> temporadas = new ArrayList<>();

		for (int i = 1; i<dados.totalTemporadas(); i++) {
			json = consumoApi.obterDados("http://www.omdbapi.com/?t=The+Originals&season=" + i + "&apikey=92dab9e4");
			DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
			temporadas.add(dadosTemporada);
		}
		temporadas.forEach(System.out::println);
	}
}
