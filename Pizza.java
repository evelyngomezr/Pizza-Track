public class Pizza {
    private String nombre;
    private String[] ingredientes; // Arreglo fijo de 3 elementos[cite: 1]

    public Pizza(String nombre, String ing1, String ing2, String ing3) {
        this.nombre = nombre;
        this.ingredientes = new String[]{ing1, ing2, ing3};
    }

    public String getNombre() {
        return nombre;
    }

    public String[] getIngredientes() {
        return ingredientes;
    }

    @Override
    public String toString() {
        return "Pizza: " + nombre + " | Ingredientes: [" + 
               ingredientes[0] + ", " + ingredientes[1] + ", " + ingredientes[2] + "]";
    }
}