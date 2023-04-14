package br.senai.sc;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class BibliotecaTest {
    private Biblioteca biblioteca;

    @BeforeEach
    public void setUp() {
        biblioteca = new Biblioteca("Biblioteca");
    }

    @Test
    public void getNomeTest() {
        assertEquals("Biblioteca", biblioteca.getNome());
    }

    @Test
    public void setNomeTest() {
        biblioteca.setNome("123");
        assertEquals("123", biblioteca.getNome());
    }

    @Test
    public void getLivrosTest() {
        List<Livro> livros = biblioteca.getLivros();
        assertEquals(livros, biblioteca.getLivros());
    }

    @Test
    public void adicionarLivroTest() {
        Livro livro = new Livro("HTGAWYM", "Cesar", "Romance", 1098);
        assertTrue(biblioteca.adicionarLivro(livro));
    }

    @Test
    public void removerLivroTest() {
        Livro livro = new Livro("HTGAWYM", "Cesar", "Romance", 1098);
        biblioteca.adicionarLivro(livro);
        assertTrue(biblioteca.removerLivro(livro));
    }

    @Test
    public void buscarLivrosPorAutorTest() {
        biblioteca.adicionarLivro(new Livro("HTGAWYM", "Cesar", "Romance", 1098));
        biblioteca.adicionarLivro(new Livro("HTGAWYM2", "Cesar", "Horror", 1100));
        List<Livro> livros = biblioteca.buscarLivrosPorAutor("Cesar");
        assertEquals(livros, biblioteca.buscarLivrosPorAutor("Cesar"));
    }

    @Test
    public void buscarLivroPorTituloTest() {
        biblioteca.adicionarLivro(new Livro("HTGAWYM", "Cesar", "Romance", 1098));
        Livro livro = biblioteca.buscarLivroPorTitulo("Cesar");
        assertEquals(livro, biblioteca.buscarLivroPorTitulo("Cesar"));
    }

    @Test
    public void buscarLivrosPorGeneroTest() {
        biblioteca.adicionarLivro(new Livro("HTGAWYM", "Cesar", "Romance", 1098));
        biblioteca.adicionarLivro(new Livro("HTGAW22", "Juliana", "Romance", 1234));
        List<Livro> livros = biblioteca.buscarLivrosPorGenero("Romance");
        assertEquals(livros, biblioteca.buscarLivrosPorGenero("Romance"));
    }

    @Test
    public void getQuantidadeLivrosTest() {
        biblioteca.adicionarLivro(new Livro("HTGAWYM", "Cesar", "Romance", 1098));
        biblioteca.adicionarLivro(new Livro("HTGAW22", "Juliana", "Romance", 1234));
        assertEquals(2, biblioteca.getQuantidadeLivros());
    }
}
