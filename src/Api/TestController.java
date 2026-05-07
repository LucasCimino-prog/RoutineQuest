package Api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    // Quando o celular (ou navegador) acessar o caminho "/ping", ele cai aqui!
    @GetMapping("/ping")
    public String responderCelular() {
        return "Olá, Expo Go! O backend do Routine Quest está online e pronto!";
    }
}