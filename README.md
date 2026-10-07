# Estruturas de Dados - Pilhas, Filas e Listas Ligadas

## Trabalho de Avaliação - Estruturas de Dados

**Aluno:** Ulisses Fernandes Guimarães\
**Curso:** Análise e Desenvolvimento de Sistemas (ADS)\
**Instituição:** ULBRA - Campus Torres\
**Disciplina:** Estrutura de Dados\
**Professor:** Juliano Ramos Matos

------------------------------------------------------------------------

## 1. Introdução

Este trabalho tem como objetivo aplicar, de forma prática, os conceitos
de estruturas de dados estudados na disciplina, utilizando
implementações próprias de pilhas, filas e listas ligadas. A
implementação manual é importante para compreender como os elementos são
armazenados e relacionados internamente, além de permitir observar como
as referências entre os nós são atualizadas durante as operações de
inserção e remoção. Dessa forma, o trabalho contribui para uma
compreensão mais clara do gerenciamento das estruturas e de seu
funcionamento, sem depender de classes prontas da linguagem.

------------------------------------------------------------------------

## 2. Implementação

O trabalho foi dividido em dois exercícios principais.

### 2.1 Exercício 1 - Pilha e Fila com Lista Simplesmente Ligada

O primeiro exercício consiste em um sistema de gerenciamento de pedidos
de uma cafeteria, utilizando duas estruturas implementadas manualmente:

-   **Fila de pedidos pendentes:** utiliza o conceito FIFO (First In,
    First Out), em que o primeiro pedido inserido é o primeiro a ser
    atendido ou removido.
-   **Pilha de pedidos cancelados:** utiliza o conceito LIFO (Last In,
    First Out), em que o último pedido inserido é o primeiro a ser
    retirado.

#### Estrutura do nó

Os pedidos são armazenados por meio de nós ligados entre si. Cada nó
contém os dados do pedido e uma referência para o próximo elemento.

#### Operações implementadas

-   Adicionar novo pedido;
-   Atender pedido;
-   Cancelar pedido;
-   Restaurar pedido;
-   Exibir pedidos pendentes;
-   Exibir pedidos cancelados.

No cancelamento, o pedido mais antigo é removido da fila e inserido no
topo da pilha de pedidos cancelados. Na restauração, o pedido mais
recente entre os cancelados é retirado da pilha e inserido novamente na
fila.

### 2.2 Exercício 2 - Lista Duplamente Ligada para Playlist

O segundo exercício consiste em um sistema de gerenciamento de uma
playlist utilizando uma lista duplamente ligada.

Cada nó da lista armazena:

-   Título da música;
-   Artista;
-   Álbum;
-   Duração.

A lista possui referências para o início e o fim e mantém a indicação da
música atual, permitindo a navegação nos dois sentidos.

#### Operações implementadas

-   Adicionar música;
-   Adicionar no início;
-   Adicionar no fim;
-   Adicionar em uma posição específica;
-   Remover música;
-   Listar músicas;
-   Avançar para a próxima música;
-   Voltar para a música anterior;
-   Exibir e tocar a música atual;
-   Ordenar a playlist por título;
-   Ordenar a playlist por artista.

------------------------------------------------------------------------

## 3. Implementação e casos críticos

Durante a implementação, foram considerados os casos em que a estrutura
está vazia, possui apenas um elemento ou quando a operação ocorre no
início ou no fim da estrutura.

### 3.1 Pilha

A pilha mantém uma referência para o elemento que está no topo. No
`push`, um novo nó é inserido no topo. No `pop`, o elemento do topo é
removido e a referência passa para o próximo nó.

Quando a pilha está vazia, a operação de remoção não tenta acessar um
elemento inexistente.

### 3.2 Fila

A fila mantém referências para o início e o fim. A inserção acontece no
final da fila e a remoção acontece no início.

Quando o último elemento é removido, a referência do fim também é
atualizada para indicar que a fila ficou vazia.

### 3.3 Lista duplamente ligada

Na lista duplamente ligada, cada nó possui referências para o próximo e
para o elemento anterior. Isso permite percorrer a lista nos dois
sentidos.

Nas operações de inserção e remoção, são atualizadas as referências dos
nós vizinhos e, quando necessário, as referências de início, fim e
música atual.

Os casos críticos considerados incluem:

-   lista vazia;
-   lista com apenas um elemento;
-   inserção no início;
-   inserção no fim;
-   remoção do primeiro elemento;
-   remoção do último elemento;
-   remoção de elemento no meio da lista.

------------------------------------------------------------------------

## 3.4 Evidências de Execução

As funcionalidades foram testadas por meio da execução dos programas no
terminal, verificando as principais operações de cada estrutura.

### Exercício 1 - Fila de pedidos

A primeira evidência apresenta a inserção e a exibição dos pedidos
pendentes na fila.

**Figura 1 - Inserção e exibição dos pedidos pendentes.**

![Figura 1 - Inserção e exibição dos pedidos
pendentes](./Figura1_Fila.png)

### Exercício 1 - Pilha de pedidos cancelados

A segunda evidência demonstra o cancelamento de pedidos e sua
transferência da fila para a pilha de pedidos cancelados.

**Figura 2 - Cancelamento e exibição dos pedidos cancelados.**

![Figura 2 - Cancelamento e exibição dos pedidos
cancelados](./Figura2_Pilha.png)

### Exercício 1 - Restauração

A terceira evidência apresenta a restauração de um pedido cancelado,
retirando-o da pilha e inserindo-o novamente na fila de pedidos
pendentes.

**Figura 3 - Restauração de pedido e resultado final.**

![Figura 3 - Restauração de pedido](./Figura3_Restauracao.png)

As execuções demonstram os comportamentos FIFO da fila e LIFO da pilha,
além da comunicação entre as duas estruturas durante as operações de
cancelamento e restauração.

### Exercício 2 - Playlist

A quarta evidência apresenta a playlist com as músicas cadastradas e sua
exibição na ordem atual.

**Figura 4 - Exibição das músicas da playlist.**

![Figura 4 - Exibição da playlist](./Figura4_Playlist.png)

### Exercício 2 - Navegação e reprodução

A quinta evidência demonstra a navegação entre os elementos da lista e a
reprodução da música atualmente selecionada.

**Figura 5 - Navegação e reprodução da música atual.**

![Figura 5 - Navegação e reprodução](./Figura5_Navegacao.png)

### Exercício 2 - Ordenação e remoção

A sexta evidência demonstra as operações de organização e alteração da
playlist, incluindo a ordenação e a remoção de músicas.

**Figura 6 - Ordenação e remoção de músicas.**

![Figura 6 - Ordenação e remoção](./Figura6_Ordenacao.png)

As evidências apresentadas comprovam a execução das principais
funcionalidades desenvolvidas nos dois exercícios e demonstram o
funcionamento das estruturas implementadas.

------------------------------------------------------------------------

## 4. Conclusão

Durante o desenvolvimento do trabalho, foi possível colocar em prática
os conceitos de pilhas, filas e listas ligadas. Uma das principais
dificuldades encontradas foi compreender como as referências entre os
nós deveriam ser atualizadas durante as operações de inserção e remoção,
principalmente nos casos em que a estrutura estava vazia ou possuía
apenas um elemento.

A implementação manual das estruturas ajudou a compreender melhor seu
funcionamento interno, sem utilizar classes prontas para realizar as
operações. No primeiro exercício, foi possível perceber na prática a
diferença entre o comportamento FIFO da fila e LIFO da pilha. No
segundo, a lista duplamente ligada permitiu compreender melhor a
utilização das referências para o elemento anterior e o próximo, além da
navegação, inserção, remoção e ordenação dos elementos.

Ao final do trabalho, foi possível reforçar os conhecimentos sobre
estruturas de dados e perceber a importância de tratar diferentes
situações durante a execução do programa, como estruturas vazias,
remoção do primeiro ou último elemento e atualização das referências. A
atividade também contribuiu para desenvolver maior segurança na
implementação dessas estruturas de forma manual.

------------------------------------------------------------------------

## 5. Organização do projeto

O código-fonte está organizado em exercícios separados:

-   `Exercicio1` - implementação da pilha e da fila para gerenciamento
    de pedidos;
-   `Exercicio2` - implementação da lista duplamente ligada para
    gerenciamento da playlist.

As imagens utilizadas como evidências estão armazenadas junto ao README
para que sejam exibidas corretamente no GitHub.

------------------------------------------------------------------------

## 6. Tecnologias utilizadas

-   Java
-   IntelliJ IDEA
-   Estruturas de dados implementadas manualmente
-   Git e GitHub
