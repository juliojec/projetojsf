# Projeto JSF - Sistema de Análise de Frases

Projeto JSF que analisa frases digitadas pelo usuário, contando palavras distintas e suas ocorrências.

## 🚀 O que faz

- Recebe uma frase do usuário
- Conta quantas palavras distintas existem
- Mostra quantas vezes cada palavra aparece
- Interface web responsiva com PrimeFaces

## 🛠️ Tecnologias

- **Java 8**
- **JSF**
- **PrimeFaces**
- **WildFly 10**

## 📁 Estrutura

```
src/
├── java/br/com/projetojsf/beans/
│   └── UsuarioBean.java          # Bean principal
└── webapp/
    ├── index.xhtml               # Página principal
    └── WEB-INF/
        ├── web.xml
        └── faces-config.xml
        ├── jboss-web.xml
        └── jboss-deployment-structure.xml
        └── beans.xml
```

## ⚙️ Como rodar

### 1. Preparar ambiente
- Instale Java 8
- Baixe e configure WildFly 10

### 3. Deploy no WildFly
```bash
# Inicie o WildFly
./standalone.sh

# Faça deploy (copie o WAR ou pasta do projeto para):
$WILDFLY_HOME/standalone/deployments/
```

### 4. Acessar aplicação
```
http://127.0.0.1:8080/projetojsf/index.xhtml
```

## 💻 Como usar

1. Digite uma frase no campo de texto
2. Clique em "Analisar Frase"
3. Veja o resultado:
   - Total de palavras distintas
   - Tabela com cada palavra e quantas vezes aparece


**Compatível com:** Java 8, WildFly 10, PrimeFaces 8
