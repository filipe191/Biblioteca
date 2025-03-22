
// Classe Principal para testar o sistema
package main;

import biblioteca.Biblioteca;
import model.Livro;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Criando a biblioteca
        Biblioteca biblioteca = new Biblioteca();

        // Adicionando livros
        biblioteca.adicionarLivro(new Livro("Dom Casmurro", "Machado de Assis", 1899));
        biblioteca.adicionarLivro(new Livro("O Cortiço", "Aluísio Azevedo", 1890));
        biblioteca.adicionarLivro(new Livro("Grande Sertão: Veredas", "João Guimarães Rosa", 1956));
        biblioteca.adicionarLivro(new Livro("Memórias Póstumas de Brás Cubas", "Machado de Assis", 1881));
        biblioteca.adicionarLivro(new Livro("Vidas Secas", "Graciliano Ramos", 1938));
        biblioteca.adicionarLivro(new Livro("Quincas Borba", "Machado de Assis", 1891));
        biblioteca.adicionarLivro(new Livro("Memórias Póstumas de Brás Cubas", "Machado de Assis", 1881)); // Livro duplicado para teste

        // Testando as funcionalidades

        // 1. Livros adicionados (já feito acima)
        System.out.println("\n=== Todos os livros ===");
        biblioteca.getLivros().forEach(System.out::println);

        // 2. Buscar livros por título
        System.out.println("\n=== Livros com 'memórias' no título ===");
        List<Livro> livrosBuscados = biblioteca.buscarPorTitulo("memórias");
        livrosBuscados.forEach(System.out::println);

        // 3. Listar os livros ordenados por ano de publicação (crescente)
        System.out.println("\n=== Livros ordenados por ano de publicação ===");
        List<Livro> livrosOrdenados = biblioteca.listarLivrosPorAnoPublicacao();
        livrosOrdenados.forEach(livro -> System.out.println(livro.getAnoPublicacao() + " - " + livro.getTitulo()));

        // 4. Exibir a contagem de livros por autor
        System.out.println("\n=== Contagem de livros por autor ===");
        Map<String, Integer> contagemPorAutor = biblioteca.contarLivrosPorAutor();
        contagemPorAutor.forEach((autor, contagem) ->
                System.out.println(autor + ": " + contagem + " livro(s)"));

        // 5. Listar os livros únicos disponíveis (sem repetições)
        System.out.println("\n=== Livros únicos ===");
        Set<Livro> livrosUnicos = biblioteca.listarLivrosUnicos();
        livrosUnicos.forEach(System.out::println);
        System.out.println("Total de livros na lista original: " + biblioteca.getLivros().size());
        System.out.println("Total de livros únicos: " + livrosUnicos.size());

        // 6. Exibir os livros publicados antes de um determinado ano
        int anoReferencia = 1900;
        System.out.println("\n=== Livros publicados antes de " + anoReferencia + " ===");
        List<Livro> livrosAntigos = biblioteca.listarLivrosAntesDoAno(anoReferencia);
        livrosAntigos.forEach(livro ->
                System.out.println(livro.getAnoPublicacao() + " - " + livro.getTitulo() + " (" + livro.getAutor() + ")"));
    }
}