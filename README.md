# Relatório Técnico - Estruturas de Dados (Pilhas, Filas e Listas Ligadas)

## 1. Identificação
* **Curso:** Análise e Desenvolvimento de Sistemas
* **Disciplina:** Estrutura de Dados
* **Professor:** Juliano Ramos Matos
* **Aluno(a):** Ulisses "Kakaroto" Guimarães

---

## 2. Introdução
A implementação manual de estruturas de dados básicas, como listas simplesmente e duplamente encadeadas, pilhas e filas, é essencial para compreender o funcionamento do gerenciamento de memória e a manipulação explícita de ponteiros/referências. Sem o auxílio de abstrações prontas da linguagem Java (como `java.util.LinkedList`), compreende-se com clareza o custo computacional, o alocamento dinâmico e o controle fino de ponteiros.

---

## 3. Implementação

### Estruturas Utilizadas:
* **Pilha (`Exercicio1`)**: Implementada via lista simplesmente ligada com política LIFO (Last-In, First-Out).
* **Fila (`Exercicio1`)**: Implementada via lista simplesmente ligada com ponteiros de `inicio` e `fim` (FIFO - First-In, First-Out).
* **Lista Duplamente Ligada (`Exercicio2`)**: Implementada com ponteiros `proximo` e `anterior`, permitindo navegação bidirecional e ponteiro para a música atual (`atual`).

### Casos Críticos Tratados:
1. **Remoção em Estrutura Vazia**: Validação via métodos `estaVazia()` evitando erros `NullPointerException`.
2. **Atualização de Ponteiros Extremidades**: Ao inserir/remover elementos no início ou fim, os ponteiros `inicio` e `fim` são devidamente atualizados.
3. **Música Atual Eliminada**: Ao remover o nó apontado por `atual`, a referência do cursor avança automaticamente para o próximo nó disponível.
