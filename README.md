Este README serve como guia para a API de Avaliações, Descrição do Aplicativo de Avaliações e Web Scraping 
Visão Geral 
O aplicativo de Avaliações foi projetado para consolidar e analisar avaliações de 
produtos provenientes de diversos marketplaces. Utilizando técnicas de web scraping, 
a aplicação coleta automaticamente reclamações e avaliações sobre produtos, que 
são então armazenadas em um banco de dados centralizado. O objetivo é fornecer 
insights detalhados sobre produtos, permitindo a identificação de padrões de 
qualidade e defeitos, e, assim, apoiar a tomada de decisões para melhorar e alavancar 
vendas e desempenho de produtos. 
Funcionalidades 
Coleta de Dados 
Anteriormente, a inserção de dados no sistema era feita manualmente, o que envolvia 
a criação e atualização de avaliações por meio de endpoints testados via Postman. 
Agora, a aplicação utiliza um sistema de web scraping para automatizar esse processo. 
O web scraper coleta avaliações e reclamações diretamente de marketplaces e insere 
essas informações no banco de dados, eliminando a necessidade de inserção manual 
e garantindo que os dados sejam atualizados em tempo real. 
Interface do Usuário 
A entrega anterior usava Postman para testar endpoints da API e gerenciar avaliações. 
No novo sistema, a interface do usuário foi aprimorada utilizando Thymeleaf com o 
padrão MVC. A aplicação agora apresenta telas dinâmicas para a gestão de avaliações, 
produtos e clientes. Com o uso de Thymeleaf, a interação com a aplicação se tornou 
mais intuitiva e acessível, proporcionando uma experiência de usuário mais rica e 
interativa. 
Endpoints e Funcionalidades 
home
![image](https://github.com/user-attachments/assets/fa05db7c-d887-45f1-af26-0c8b8f99a4b8)

pag de clientes
![image](https://github.com/user-attachments/assets/4da31ce2-a617-4544-80ec-cb5221e470bc)

adicionado clientes
![image](https://github.com/user-attachments/assets/ad9d39a4-e954-425d-9e98-1d8ef247807a)

edicao de clientes
![image](https://github.com/user-attachments/assets/a480bfd5-a124-4d69-b05d-6f766bda5210)

Produtos
![image](https://github.com/user-attachments/assets/4b876f0d-a3f5-4af3-ace7-1213bd125e4c)

edicao de produtos
![image](https://github.com/user-attachments/assets/709dbfd9-8764-44fc-b68e-2050d3b251f1)

adicionar produto
![image](https://github.com/user-attachments/assets/08f8e4e6-da83-4d4e-8c81-7dcba1fb1206)

Lista de avaliacoes
![image](https://github.com/user-attachments/assets/ccdb9b23-90df-4362-a073-e413dd854e1b)


A aplicação mantém a funcionalidade básica de gerenciar avaliações, produtos e 
clientes, mas com melhorias significativas 
Melhorias Implementadas 
1. Automatização da Coleta de Dados: 
• A inserção de dados é agora automatizada por meio de web scraping, 
eliminando a necessidade de inserção manual e proporcionando dados 
mais atualizados e precisos. 
2. Interface Interativa com Thymeleaf e MVC: 
• Substituição dos testes de endpoints via Postman por uma interface de 
usuário dinâmica e intuitiva, facilitando a gestão e visualização das 
informações diretamente pela aplicação web. 
3. Otimização do Fluxo de Trabalho: 
• A nova arquitetura com Thymeleaf e MVC permite uma navegação mais 
fluida e uma melhor visualização dos dados, melhorando a experiência 
geral do usuário. 
4. Centralização dos Dados e Insights: 
• O sistema agora não apenas coleta e armazena dados, mas também gera 
insights sobre produtos com base em suas avaliações, identificando 
pontos fortes e áreas de melhoria. 
Com essas melhorias, o aplicativo se torna uma ferramenta poderosa para análise e 
gestão de avaliações, oferecendo uma experiência de usuário aprimorada e dados 
mais precisos e atualizados.

Integrantes da Equipe:
Rm 98660 - Leonardo Valentim de Souza: COMPLIANCE & QUALITY ASSURANCE 
RM 97714 - João Victor Leite Firmino :DISRUPTIVE ARCHITECTURES: IOT, IOB & GENERATIVE IA 
Rm 99618 - Gustavo dos Santos Correa :JAVA ADVANCED 
RM 551201 - Lucas Cazzaro :MASTERING RELATIONAL AND NON-RELATIONAL DATABASE E ADVANCED BUSINESS DEVELOPMENT WITH .NET 
RM 99219 - Ronaldo Riyudi :Noda MOBILE APP DEVELOPMENT 



