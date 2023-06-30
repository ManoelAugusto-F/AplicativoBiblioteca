# Aplicativo de Cadastro de Livros para Biblioteca

Este é o projeto final da disciplina de Programação 3 do Instituto Federal de Goiás (IFG), que consiste em um aplicativo de cadastro de livros para biblioteca. O objetivo do projeto é desenvolver uma ferramenta que permita o controle e registro dos livros presentes na biblioteca, facilitando a organização e disponibilização desses recursos.

## Mig Layout

O aplicativo utiliza a biblioteca Java chamada Mig Layout para gerenciar o layout da interface gráfica. O Mig Layout é um poderoso sistema de posicionamento e layout para interfaces de usuário em Java. Ele permite criar interfaces flexíveis e responsivas, facilitando o desenvolvimento de aplicações desktop com uma disposição visual agradável.

Para obter mais informações sobre o Mig Layout, você pode visitar [este link](https://www.miglayout.com/) para acessar a documentação oficial.

## Tecnologias Utilizadas

O projeto foi desenvolvido utilizando as seguintes tecnologias e conceitos:

- Linguagem de programação: Java
- Framework GUI: Swing
- Biblioteca de layout: Mig Layout
- Banco de Dados: MySQL/MariaDB
- Padrão de Arquitetura: MVC (Model-View-Controller)
- Tratamento de Exceções
- Validação de entrada de dados

## Funcionalidades Principais

O aplicativo de cadastro de livros para biblioteca possui as seguintes funcionalidades principais:

- Cadastro de livros: os usuários podem registrar os livros presentes na biblioteca, informando título, autor, gênero, ano de publicação, entre outros atributos relevantes.
- Pesquisa de livros: é possível pesquisar livros pelo título, autor ou gênero, facilitando a localização dos recursos disponíveis.
- Gerenciamento de empréstimos: o sistema permite registrar empréstimos de livros para os usuários da biblioteca, controlando as datas de retirada e devolução.
- Visualização de relatórios: é possível gerar relatórios com base nos livros cadastrados e empréstimos realizados, fornecendo uma visão geral das atividades da biblioteca.

## Configuração do Ambiente de Desenvolvimento

Para executar o projeto em seu ambiente de desenvolvimento, siga as etapas abaixo:

1. Clone este repositório em sua máquina local.
2. Importe o projeto no NetBeans (ou outra IDE de sua preferência) como um projeto Java existente.
3. Certifique-se de ter o MariaDB instalado em seu sistema e crie um banco de dados vazio.
4. Configure as informações de conexão com o banco de dados no arquivo config.properties.
5. Execute o script SQL fornecido (schema.sql) para criar as tabelas e estruturas necessárias no banco de dados.
6. Compile e execute o projeto.

Certifique-se de que todas as dependências estejam corretamente configuradas e que o ambiente de desenvolvimento esteja devidamente configurado para executar um projeto Java com o framework Swing e a biblioteca Mig Layout.

## Contribuição

Contribuições são bem-vindas! Se você encontrar algum problema, bug ou tiver sugestões de melhoria, sinta-se à vontade para abrir uma issue neste repositório.

## Autores

- Manoel Augusto

## Licença

Este projeto está licenciado sob a Licença MIT.
