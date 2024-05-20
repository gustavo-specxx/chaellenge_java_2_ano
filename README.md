Este README serve como guia para a API de Avaliações, um aplicativo que permite que usuários avaliem produtos, serviços ou experiências e que essas avaliações sejam consultadas e gerenciadas

Integrantes da Equipe:
Rm 98660 - Leonardo Valentim de Souza: COMPLIANCE & QUALITY ASSURANCE 
RM 97714 - João Victor Leite Firmino :DISRUPTIVE ARCHITECTURES: IOT, IOB & GENERATIVE IA 
Rm 99618 - Gustavo dos Santos Correa :JAVA ADVANCED 
RM 551201 - Lucas Cazzaro :MASTERING RELATIONAL AND NON-RELATIONAL DATABASE E ADVANCED BUSINESS DEVELOPMENT WITH .NET 
RM 99219 - Ronaldo Riyudi :Noda MOBILE APP DEVELOPMENT 

Como Rodar a Aplicação:
Clone o repositório da API:
![image](https://github.com/gustavo-specxx/chaellenge_java_2_ano/assets/117688531/0ee78e8c-f549-42c8-87c9-a4c8843e547a)

Abra sua IDE de preferencia:
![image](https://github.com/gustavo-specxx/chaellenge_java_2_ano/assets/117688531/04d091fb-7f99-4a52-a443-3310341c277d)

Va ate a classe abaixo e execute a aplicacao:
![image](https://github.com/gustavo-specxx/chaellenge_java_2_ano/assets/117688531/6c65f15c-62cd-4726-84df-68c615b73161)
Acesse a API em http://localhost:8081
via postman:
localhost:8081/avaliacoes
![image](https://github.com/gustavo-specxx/chaellenge_java_2_ano/assets/117688531/e823d070-6b15-45f5-8dcf-a118d13cae3d)
Adiciona uma nova avaliacao.
EXEMPLO json:
 {
        "idAvaliacoes": 6,
        "idCliente": 6,
        "idProduto": 6,
        "idIa": 6,
        "comentario": "Funcionou muito bem.",
        "dataAvaliacao": "2024-04-11T16:00:00.000+00:00"
    }
  
   
   
   
   Lista todas avaliacoes
   localhost:8081/avaliacoes/Listar
    ![image](https://github.com/gustavo-specxx/chaellenge_java_2_ano/assets/117688531/a436816d-6942-4e67-bcb9-c172c829224c)

 
 
 lista todos usuarios
 localhost:8081/clientes
 ![image](https://github.com/gustavo-specxx/chaellenge_java_2_ano/assets/117688531/c8a18330-97a7-417d-b6df-b41854f782cd)


Lista todos produtos
localhost:8081/produtos
![image](https://github.com/gustavo-specxx/chaellenge_java_2_ano/assets/117688531/ef52967b-7125-46cc-8a9b-8e768031b56c)


Cria um novo usuario e verifica se ja esta na base de dados
Exemplo de json- 
    {
        "nome":  "Eduardo",
        "email": "Eduexp@exp.com",
        "data_nascimento": "2005-07-02",
        "genero": "Masculino"
    }   
localhost:8081/clientes
![image](https://github.com/gustavo-specxx/chaellenge_java_2_ano/assets/117688531/66e28c79-5f0b-4f13-ac54-e2fd415c9b40)

DELETE:localhost:8081/clientes/ 4
![image](https://github.com/gustavo-specxx/chaellenge_java_2_ano/assets/117688531/21474e93-d554-4feb-afae-ce3e0b732854)

Exclui com base no id
GET:localhost:8081/clientes/ 4
![image](https://github.com/gustavo-specxx/chaellenge_java_2_ano/assets/117688531/5d3493d9-a70f-4869-a676-b7ef0d4ab408)

Localiza com base no id
Finaliza o cadastro do usuario adicionando sua senha na tabela de autenticacao
![image](https://github.com/gustavo-specxx/chaellenge_java_2_ano/assets/117688531/590d5ee7-106d-42d2-90e9-ddfca8879187)


POST: localhost:8081/usuarios/cadastro
exemplo json: {
  "email_cliente": "exemplo1@email.com",
  "senha_cliente": "senhaa"
}

apos o usuario se cadastrar ele nao duplica os dados pela autenticacao implementada
![image](https://github.com/gustavo-specxx/chaellenge_java_2_ano/assets/117688531/38b5e0f9-835d-469c-86ec-cbef7e0e823a)

Apos cadastrar o email e senha do usuario pode se realizar o login POST:localhost:8081/usuarios/login
![image](https://github.com/gustavo-specxx/chaellenge_java_2_ano/assets/117688531/b9b352e1-598b-4d78-929a-cd373aefab14)

