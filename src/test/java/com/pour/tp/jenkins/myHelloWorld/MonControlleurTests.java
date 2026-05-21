import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc // Simule l'environnement web
class MonControleurTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testPageAccueil() throws Exception {
        this.mockMvc.perform(get("/")) // On simule une requête HTTP GET sur l'URL "/"
                .andExpect(status().isOk()) // On vérifie que le code de réponse est 200 (OK)
                .andExpect(content().string("<h1>Félicitations ! Votre application Java tourne sur le Web !</h1>")); // On vérifie le texte affiché
    }
}