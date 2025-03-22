package biblioteca;

import model.Livro;

import java.util.*;
import java.util.stream.Collectors;

public class Biblioteca {
    private List<Livro> livros;

    public Biblioteca() {
        this.livros = new ArrayList<>();
    }

    // 1. Adicionar livros à biblioteca
    public void adicionarLivro(Livro livro) {
        livros.add(livro);
        System.out.println("Livro adicionado: " + livro.getTitulo());
    }

    // 2. Buscar livros por título
    public List<Livro> buscarPorTitulo(String titulo) {
        return livros.stream()
                .filter(livro -> livro.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
                .collect(Collectors.toList());
    }

    // 3. Listar os livros ordenados por ano de publicação (crescente)
    public List<Livro> listarLivrosPorAnoPublicacao() {
        List<Livro> livrosOrdenados = new ArrayList<>(livros);
        livrosOrdenados.sort(Comparator.comparingInt(Livro::getAnoPublicacao));
        return livrosOrdenados;
    }

    // 4. Exibir a contagem de livros por autor
    public Map<String, Integer> contarLivrosPorAutor() {
        Map<String, Integer> contagem = new HashMap<>();

        for (Livro livro : livros) {
            contagem.put(livro.getAutor(), contagem.getOrDefault(livro.getAutor(), 0) + 1);
        }

        return contagem;
    }

    // 5. Listar os livros únicos disponíveis (sem repetições)
    public Set<Livro> listarLivrosUnicos() {
        return new HashSet<>(livros);
    }

    // 6. Exibir os livros publicados antes de um determinado ano
    public List<Livro> listarLivrosAntesDoAno(int ano) {
        return livros.stream()
                .filter(livro -> livro.getAnoPublicacao() < ano)
                .collect(Collectors.toList());
    }

    // Método para obter a lista de livros (para teste)
    public List<Livro> getLivros() {
        return livros;
    }
}