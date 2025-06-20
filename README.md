# 🌄 A* no Vale do Itajaí

Este projeto em Java implementa uma versão simplificada do algoritmo **A*** (funcionando como **Busca de Custo Uniforme**, pois não utiliza heurística), para encontrar o caminho mais curto entre cidades da região do **Vale do Itajaí**, em Santa Catarina.

O grafo de cidades é representado por conexões com distâncias reais aproximadas, permitindo simulações de trajetos entre diversos municípios da região.

---

## 🧠 Algoritmo

Apesar de nomeado como A*, a implementação não utiliza heurística. Portanto, na prática, o projeto executa uma **Busca de Menor Custo** baseada apenas nas distâncias acumuladas (custo real do caminho até o nó).

---

## 🏙️ Cidades no Grafo

Algumas das cidades incluídas:

- Blumenau
- Itajaí
- Joinville
- Brusque
- Gaspar
- Indaial
- Jaraguá do Sul
- Balneário Camboriú
- Camboriú
- Navegantes
- Itapema
- Timbó
- Pomerode
- São Francisco do Sul
- Rio do Sul

E outras...

---

## 📁 Estrutura do Projeto

```
aestrela/
├── AEstrela.java         # Algoritmo principal de busca
├── Aresta.java           # Representa uma conexão entre duas cidades
├── ValeDoItajai.java     # Grafo com o mapa e métodos de manipulação
└── Main.java             # Interface de entrada no console
```

---

## ▶️ Como Executar

1. Compile todos os arquivos `.java` (por exemplo, com `javac *.java`).
2. Execute a classe `Main`:
   ```bash
   java aestrela.Main
   ```
3. Digite a **cidade de origem** e a **cidade de destino** quando solicitado.

---

## 🖥️ Exemplo de Uso

```
Digite a cidade de origem: Blumenau
Digite a cidade de destino: Camboriú

Melhor rota:
- Blumenau
- Gaspar
- Brusque
- Balneário Camboriú
- Camboriú
```

---

## 📌 Requisitos

- Java 8 ou superior
- Terminal ou IDE como NetBeans, Eclipse ou IntelliJ

---

## 🚀 Possíveis Melhorias Futuras

- Implementação de heurística (tornar o algoritmo A* real)
- Visualização gráfica do grafo e caminho encontrado
- Entrada de cidades e distâncias via arquivo JSON/CSV
- Interface com JavaFX

---

## 👨‍💻 Autor

Pedro Henrique Pereira de Oliveira  

---

## 📄 Licença

Este projeto é de uso educacional e livre para estudo e modificação.
