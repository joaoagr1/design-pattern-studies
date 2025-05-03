interface Transporte {
    void entregar();
}

class Caminhao implements Transporte {
    public void entregar() {
        System.out.println("Entrega feita por caminhão.");
    }
}

class Navio implements Transporte {
    public void entregar() {
        System.out.println("Entrega feita por navio.");
    }
}

abstract class Logistica {
    public abstract Transporte criarTransporte();
}

class LogisticaTerrestre extends Logistica {
    public Transporte criarTransporte() {
        return new Caminhao();
    }
}

class LogisticaMaritima extends Logistica {
    public Transporte criarTransporte() {
        return new Navio();
    }
}

public class Main {
    public static void main(String[] args) {
        Logistica logistica1 = new LogisticaTerrestre();
        Transporte transporte1 = logistica1.criarTransporte();
        transporte1.entregar();

        Logistica logistica2 = new LogisticaMaritima();
        Transporte transporte2 = logistica2.criarTransporte();
        transporte2.entregar();
    }
}
