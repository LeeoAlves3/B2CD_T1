package controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/endpoint")
public class UserController {

    // Método GET
    @GetMapping("/{par}")
    public String getUser(@PathVariable(value = "par") String par) {
        return "{ \"mensagem\": \"O parâmetro do GET foi: " + par + 
               ". GET é usado para recuperar dados e deve ser seguro e idempotente, não alterando o estado do servidor e podendo ser chamado várias vezes com o mesmo efeito. " +
               "O GET não requer um corpo porque está apenas recuperando, não modificando os dados.\" }";
    }

    // Método POST
    @PostMapping
    public String createUser(@RequestBody String par) {
        return "{ \"mensagem\": \"O conteúdo do POST foi: " + par + 
               ". POST é usado para criar um novo recurso e não é idempotente, o que significa que a mesma chamada repetida pode criar múltiplas instâncias. " +
               "O POST requer um corpo para fornecer os dados do novo recurso a ser criado.\" }";
    }

    // Método PUT
    @PutMapping("/{par}")
    public String updateUser(@PathVariable(value = "par") String par, @RequestBody String par2) {
        return "{ \"mensagem\": \"O parâmetro do PUT foi: " + par + " e o corpo é " + par2 + 
               ". PUT é usado para atualizar um recurso existente ou criar um novo se não existir e é idempotente, o que significa que múltiplas chamadas idênticas produzem o mesmo resultado. " +
               "O PUT precisa de um corpo para receber os dados atualizados ou novos.\" }";
    }

    // Método DELETE
    @DeleteMapping("/{par}")
    public String deleteUser(@PathVariable(value = "par") String par) {
        return "{ \"mensagem\": \"O parâmetro do DELETE foi: " + par + 
               ". DELETE é usado para remover um recurso e é idempotente, o que significa que chamadas repetidas têm o mesmo efeito, não importa quantas vezes é realizado. " +
               "O DELETE não requer um corpo pois está apenas removendo o recurso identificado pelo parâmetro, sem necessidade de dados adicionais.\" }";
    }
}
