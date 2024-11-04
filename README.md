Este README serve como guia para a API de Avaliações, Descrição do Aplicativo de Avaliações e Web Scraping 
Visão Geral 
O aplicativo de Avaliações foi projetado para consolidar e analisar avaliações de 
produtos provenientes de diversos marketplaces. Utilizando técnicas de web scraping, 
a aplicação coleta automaticamente reclamações e avaliações sobre produtos, que 
são então armazenadas em um banco de dados centralizado. O objetivo é fornecer 
insights detalhados sobre produtos, permitindo a identificação de padrões de 
qualidade e defeitos, e, assim, apoiar a tomada de decisões para melhorar e alavancar 
vendas e desempenho de produtos. 
Durante esta última sprint, várias melhorias e novos recursos foram adicionados ao projeto,
trazendo mudanças significativas em relação à versão anterior:
1. Implementação de Autenticação e Segurança com Spring Security:
○ Adicionamos funcionalidades de autenticação utilizando Spring Security, com
gestão de perfis de segurança para diferenciar os acessos entre usuários
comuns e administradores.
○ Configuramos uma página de login personalizada e implementamos uma
lógica de logout, garantindo que o sistema esteja seguro e acessível apenas
para usuários autenticados.
2. Gestão de Perfis e Acesso:
○ Criamos perfis distintos de segurança: usuários comuns e administradores.
Apenas administradores têm acesso a rotas específicas, como a gestão
avançada de produtos e usuários.
3. Integração com Inteligência Artificial:
○ Implementamos um sistema de recomendação de produtos utilizando uma
API de Inteligência Artificial (OpenAI). Agora, ao visualizar um produto, o
sistema sugere automaticamente produtos semelhantes com base na
descrição e nos dados existentes, aprimorando a experiência do usuário.
○ Também adicionamos um botão em cada página de produto para que o
usuário possa consultar a IA diretamente, caso tenha dúvidas sobre qual
produto escolher.
4. Recursos de Internacionalização:
○ Implementamos recursos de internacionalização, permitindo que o sistema
suporte múltiplos idiomas, oferecendo uma experiência mais acessível para
usuários de diferentes regiões.
5. Configuração de Mensageria:
○ Adicionamos suporte a mensageria com a implementação de produtores e
consumidores, garantindo a comunicação assíncrona entre diferentes partes
do sistema, aumentando a eficiência e a escalabilidade.
6. Monitoramento com Spring Boot Actuator:
○ Utilizamos o Spring Boot Actuator para monitorar a aplicação, possibilitando
uma melhor observação dos endpoints, métricas e informações sobre o
estado da aplicação, auxiliando na manutenção e resolução de problemas.
7. Padronização dos Templates e Integração com Bootstrap:
○ Todos os templates da aplicação foram padronizados utilizando Bootstrap,
garantindo um design consistente e responsivo, proporcionando uma melhor
experiência visual e usabilidade aos usuários.
○ Adicionamos um botão "Dúvidas? Fale com o chat" em todos os templates,
redirecionando o usuário para a página de interação com a IA, facilitando a
navegação e promovendo o uso do sistema de recomendação inteligente.
Essas mudanças melhoraram a segurança, a experiência do usuário e a eficiência do
sistema, trazendo funcionalidades avançadas e modernas que aprimoram significativamente
a aplicação em comparação com a versão anterior
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

Duvidas e recomendacao com o chatgpt
![image](https://github.com/user-attachments/assets/3456cdd5-6301-4183-8d15-ca108836e66a)

![image](https://github.com/user-attachments/assets/f76c896f-1e18-43cc-80f6-3d007b5d2cf8)


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



