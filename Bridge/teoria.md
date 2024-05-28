### Bridge

O padrão Bridge é semelhante ao padrão Adapter e é um padrão estrutural que tem a intenção de desacoplar uma abstração da sua implementação de modo que as duas possam variar e evoluir independentemente.

#### Componentes do Padrão Bridge

- **Abstração**: Código de alto nível que geralmente delega responsabilidade para a implementação (para outro objeto).
- **Implementação**: Código de baixo nível que efetivamente faz o trabalho.

![image](https://github.com/joaoagr1/design-pattern-studies/assets/125477822/4702adb6-4333-4ccd-b4d8-3ecbf5856acf)

#### Explicação do Problema

Temos uma classe abstrata chamada `ControleRemoto` que tem outras classes de marcas de controle que a estendem. No entanto, se quisermos criar um novo tipo de controle remoto com novas funções, mas as mesmas classes de marcas de controle remoto também possam ser do tipo desse novo controle, teremos duplicação desnecessária de código.

Ao usar o padrão Bridge, podemos resolver este problema separando a hierarquia de abstração (tipos de controle remoto) da hierarquia de implementação (marcas de controle remoto).

#### Solução

![image](https://github.com/joaoagr1/design-pattern-studies/assets/125477822/6abd268c-3822-430b-a266-4fe5205d6845)



### Exemplo

```java
// Implementação
interface ImplementacaoControle {
    void ligar();
    void desligar();
}

// Implementação Concreta A
class ControleSony implements ImplementacaoControle {
    @Override
    public void ligar() {
        System.out.println("Ligando Sony...");
    }

    @Override
    public void desligar() {
        System.out.println("Desligando Sony...");
    }
}

// Implementação Concreta B
class ControleLG implements ImplementacaoControle {
    @Override
    public void ligar() {
        System.out.println("Ligando LG...");
    }

    @Override
    public void desligar() {
        System.out.println("Desligando LG...");
    }
}

// Abstração
abstract class ControleRemoto {
    protected ImplementacaoControle implementacao;

    protected ControleRemoto(ImplementacaoControle implementacao) {
        this.implementacao = implementacao;
    }

    abstract void ligar();
    abstract void desligar();
}

// Abstração Refinada
class ControleRemotoSimples extends ControleRemoto {
    protected ControleRemotoSimples(ImplementacaoControle implementacao) {
        super(implementacao);
    }

    @Override
    void ligar() {
        implementacao.ligar();
    }

    @Override
    void desligar() {
        implementacao.desligar();
    }
}

// Novo tipo de controle remoto com funções adicionais
class ControleRemotoAvancado extends ControleRemoto {
    protected ControleRemotoAvancado(ImplementacaoControle implementacao) {
        super(implementacao);
    }

    @Override
    void ligar() {
        implementacao.ligar();
        System.out.println("Funções avançadas ativadas.");
    }

    @Override
    void desligar() {
        implementacao.desligar();
    }

    void mute() {
        System.out.println("Silenciando...");
    }
}

// Uso
public class Main {
    public static void main(String[] args) {
        ImplementacaoControle sony = new ControleSony();
        ImplementacaoControle lg = new ControleLG();

        ControleRemoto controleSony = new ControleRemotoSimples(sony);
        ControleRemoto controleLG = new ControleRemotoAvancado(lg);

        controleSony.ligar();
        controleSony.desligar();

        controleLG.ligar();
        controleLG.desligar();
        ((ControleRemotoAvancado) controleLG).mute();
    }
}
```

Neste exemplo, `ControleRemoto` é a abstração, `ControleRemotoSimples` e `ControleRemotoAvancado` são abstrações refinadas, e `ControleSony` e `ControleLG` são implementações concretas. Isso permite que as implementações e abstrações variem independentemente.
