public class Pila {
    private Nodo tope;

    public Pila() {
        this.tope = null;
    }

    // Insertar objeto en el tope de la pila
    public void push(Pizza pizza) {
        Nodo nuevo = new Nodo(pizza);
        nuevo.siguiente = tope;
        tope = nuevo;
    }

    // Retirar objeto del tope de la pila
    public Pizza pop() {
        if (isEmpty()) {
            return null;
        }
        Pizza pizza = tope.pizza;
        tope = tope.siguiente;
        return pizza;
    }

    // Visualizar elemento del tope sin retirarlo
    public Pizza peek() {
        if (isEmpty()) {
            return null;
        }
        return tope.pizza;
    }

    // Validar si la pila está vacía
    public boolean isEmpty() {
        return tope == null;
    }
}
