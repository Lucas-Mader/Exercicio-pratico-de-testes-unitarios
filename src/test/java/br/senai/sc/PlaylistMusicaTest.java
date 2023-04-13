package br.senai.sc;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class PlaylistMusicaTest {
    private PlaylistMusica playlistMusica;

    @BeforeEach
    public void setUp() {
        playlistMusica = new PlaylistMusica("Músicas de supermercado do interior");
    }

    @Test
    public void getNomeTest() {
        assertEquals("Músicas de supermercado do interior", playlistMusica.getNome());
    }

    @Test
    public void setNomeTest() {
        playlistMusica.setNome("Músicas");
        assertEquals("Músicas", playlistMusica.getNome());
    }

    @Test
    public void getMusicasTest() {
        List<Musica> musicas = playlistMusica.getMusicas();
        assertEquals(musicas, playlistMusica.getMusicas());
    }

    @Test
    public void adicionarMusicaTest() {
        playlistMusica.adicionarMusica(new Musica("Roger", "Amanda", 12));
        List<Musica> musicas = playlistMusica.getMusicas();
        assertEquals(musicas, playlistMusica.getMusicas());
    }

    @Test
    public void removerMusicaTest() {
        Musica musica = new Musica("Roger", "Amanda", 12);
        playlistMusica.adicionarMusica(musica);
        assertTrue(playlistMusica.removerMusica(musica));
    }

    @Test
    public void buscarMusicaPorTituloTest() {
        Musica musica = new Musica("Roger", "Amanda", 12);
        playlistMusica.adicionarMusica(musica);
        assertEquals(musica, playlistMusica.buscarMusicaPorTitulo("Roger"));
    }

    @Test
    public void buscarMusicasPorArtistaTest() {
        playlistMusica.adicionarMusica(new Musica("Roger", "Amanda", 12));
        playlistMusica.adicionarMusica(new Musica("Luana", "Amanda", 32));
        List<Musica> musicas = playlistMusica.buscarMusicasPorArtista("Amanda");
        assertEquals(musicas, playlistMusica.buscarMusicasPorArtista("Amanda"));
    }

    @Test
    public void ordenarPorTituloTest() {
        playlistMusica.adicionarMusica(new Musica("Roger", "Amanda", 12));
        playlistMusica.adicionarMusica(new Musica("Luana", "Amanda", 32));
        playlistMusica.ordenarPorTitulo();
        List<Musica> musicas = playlistMusica.getMusicas();
        assertEquals(musicas, playlistMusica.getMusicas());
    }

    @Test
    public void ordenarPorArtistaTest() {
        playlistMusica.adicionarMusica(new Musica("Roger", "Carlos", 12));
        playlistMusica.adicionarMusica(new Musica("Luana", "Amanda", 32));
        playlistMusica.ordenarPorArtista();
        List<Musica> musicas = playlistMusica.getMusicas();
        assertEquals(musicas, playlistMusica.getMusicas());
    }

    @Test
    public void getQuantidadeMusicas() {
        playlistMusica.adicionarMusica(new Musica("Roger", "Carlos", 12));
        playlistMusica.adicionarMusica(new Musica("Luana", "Amanda", 32));
        assertEquals(2, playlistMusica.getQuantidadeMusicas());
    }
}
