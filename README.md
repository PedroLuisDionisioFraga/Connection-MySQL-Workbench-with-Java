# Conexão entre um projeto Java e MySQL Workbench

## Criando um projeto **Maven**
 * Abra a paleta de comandos do VS Code: ***CTRL SHIFT P***
 * Crie um novo projeto java: ***Java: Create Java Project***
 * Selecione a opção maven: ***Maven create from archetype***
 * Selecione o arquétipo: ***maven-archetype-quickstart: org.apache.maven.archetype***
 * Selecione a versão mais recente. ***Atualmente(13/04/2023) é a 1.4***
 * Entre o package que irá trabalhar, no caso seu id de grupo: ***com.example.your.group.id***
 * Entre com o nome do seu projeto: ***your_project_name***
 * Selecione o caminho pra salvar o projeto: ***C:\Users\your\relative\path***

### No **CMD** irá iniciar a construção do projeto no modo interativo
Até no dia de hoje é necessário apenas 2 entradas do usuário.
Ao aparecer **"Define value for property 'version' 1.0-SNAPSHOT: :"** entre com a versão que foi escolhida no penúltimo tópico da criação do projeto.
Ao aparecer **" Y: :"** entre com **"y"** se concordar com tudo e seu projeto será criado.

### Classe ConnectionDataBase

Nela faremos a conexão e desconexão do meu BD.
No próprio código temos

### Classe CRUD

Nela faremos as operações nas informação armazenada no BD.