# Simulação de Processo Seletivo

Desafio do Bootcamp Santander 2024 - Backend com Java da [DIO](https://www.dio.me/en)

### Autora:
[Beatriz Miranda Aguiar](https://github.com/BeatrizMirandaAguiar)

## Estrutura do projeto

O projeto conta com uma classes e um pacote, onde:

- `candidatura`: pacote onde ProcessoSeletivo se encontra
- `ProcessoSeletivo`: classe principal que sustenta as operações requisitadas

Optei rodar o projeto com um array de candidatos pré-definido e com valores aleatórios de salários pretendidos com o intuito de prover uma maior rapidez de teste.

## Lógica do código

O projeto trabalha como uma IA de um processo seletivo, cujo filtro consiste no valor de salário pretendido, que pode ser de 1800 a 2200 reais, e o parâmetro de aprovação é o salário base, de 2000 reais. Se o salário pretendido for menor ou igual ao salário base, o candidato é selecionado. Caso contrário, é eliminado. O segundo e último filtro está ligado ao RH, que tenta contatar o candidato selecionado com a regra de negócio de fazer no máximo 3 tentativas de contato. Se o selecionado atender o chamado do RH, ele será contratado, mas se o candidato não atender, ele será excluído da lista dos selecionados.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
