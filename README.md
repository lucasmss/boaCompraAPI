# boaCompraAPI

Para usar a API você vai clonar esse repositorio;
1.Abrir na sua IDE (recomendo o STST);
2.Importar todas as dependencias para executar o Java;
3.Configurar o banco de dados;
4.Subir o serviço e verificar se esta tudo ok;

Para configuraro banco segue o exemplo:

Desenvolvido com Spring Boot a ferramenta usa o banco de dados Postgres como base,
porém você pode adicionar o banco de sua preferencia só precisa configurar o applicatio.properties;
Exemplo: 
spring.datasource.url=jdbc:postgresql://localhost:5432/boacompra_db //aqui você importa a biblioteca do banco que vai utilizar no spring;
spring.datasource.username=usuarioDoSeuBanco
spring.datasource.password=senhaDoSeuBanco
spring.jpa.generate-ddl=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.jdbc.time_zone = UTC
spring.jpa.show-sql=true
