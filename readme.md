**# Projeto MSDrivers

Este projeto é uma aplicação Java Spring Boot que gerencia operações relacionadas a criacao de condutores no sistema de controle de
estacionamento. Utiliza Gradle como ferramenta de build e gerenciamento de dependências e segue uma arquitetura limpa e
modular.

## Estrutura do Projeto

O projeto está organizado em diferentes camadas, refletindo a separação de responsabilidades:

1. **Application**: Contém classes e configurações para iniciar a aplicação, incluindo controladores REST.
2. **Domain**: O coração da aplicação com as regras de negócio, livre de dependências externas.
3. **Infrastructure**: Elementos para comunicação com o mundo exterior, como bancos de dados e clientes de serviços web.
4. **Repositories**: Interfaces para a camada de persistência.

## Executando o Projeto

1. Clone o repositório.
2. Navegue até o diretório do projeto.
3. Execute `./gradlew bootRun` para iniciar a aplicação.

### Importância do Cadastro Correto do Número de Telefone

- Para receber as notificações, é essencial que o número de telefone do condutor esteja corretamente cadastrado no
  sistema.
- O formato do número deve seguir o padrão DDD + número de telefone. Por exemplo: `119123456789`.
- Certificar-se de que o número está correto é crucial para o funcionamento efetivo das notificações.

Com essas funcionalidades de notificação, o MSParkingMeter busca oferecer um serviço mais conveniente e adaptado às
necessidades individuais dos usuários, garantindo que eles sejam devidamente informados sobre o status do
estacionamento.

## Documentação das APIs

As URLs das documentações Swagger das APIs envolvidas são:

| API             | URL Documentação Swagger                                    |
|-----------------|-------------------------------------------------------------|
| ms-drivers      | [index.html](http://localhost:8080/swagger-ui/index.html#/) |
| ms-payments     | [index.html](http://localhost:8081/swagger-ui/index.html#/) |
| ms-parkingmeter | [index.html](http://localhost:8082/swagger-ui/index.html#/) |

## Contribuindo

Pull requests são bem-vindos. Abra uma issue primeiro para discutir mudanças importantes. Atualize os testes conforme
necessário.

## Licença

[MIT](https://choosealicense.com/licenses/mit/)**
