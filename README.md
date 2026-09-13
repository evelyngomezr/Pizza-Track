# Proyecto Pizza-Track: Gestión de Pedidos con Pilas Manuales

##  Autor:
Evelyn Gomez Ramirez


##  Fundamentación Teórica y Definición de Pila (Stack)

### ¿Qué es una Pila?
En ciencias de la computación, una **Pila (Stack)** es una estructura de datos lineal que opera bajo el principio **LIFO (Last In, First Out)**, lo que significa que el *último elemento en entrar es el primero en salir*. 

En esta estructura, la adición de elementos (`push`) y la extracción de los mismos (`pop`) se realizan de manera exclusiva por un único extremo denominado **tope** o **cima**.

### Aplicación de las Pilas en la Lógica Undo / Redo (Deshacer / Rehacer)
Para implementar el mecanismo de **Deshacer (Undo)** y **Rehacer (Redo)** sin utilizar la librería estándar de Java (`java.util.Stack`), el sistema utiliza **dos pilas independientes** construidas mediante listas simplemente ligadas:

1. **Pila Principal (`pilaPrincipal`):** Almacena los pedidos activos en el sistema. Cada nuevo pedido registrado ingresa al tope de esta pila mediante una operación `push()`.
2. **Pila Secundaria (`pilaSecundaria`):** Almacena de forma temporal los pedidos que han sido deshechos.

#### Flujo de Operaciones:
- **Registrar Pedido:** El nuevo pedido se inserta en el tope de `pilaPrincipal`. Adicionalmente, la `pilaSecundaria` se reinicia (se vacía) para garantizar la coherencia lógica de la línea temporal.
- **Deshacer (Undo):** Se extrae el pedido del tope de `pilaPrincipal` con `pop()` y se inserta inmediatamente en el tope de `pilaSecundaria` mediante `push()`.
- **Rehacer (Redo):** Se saca el pedido deshecho del tope de `pilaSecundaria` con `pop()` y se reincorpora al tope de `pilaPrincipal` mediante `push()`.
- **Consultar Pedido Actual (Peek):** Retorna la pizza ubicada en el tope de `pilaPrincipal` mediante `peek()`, permitiendo inspeccionar cuál es el pedido en producción actual sin alterar el estado de la pila.

---

## 🛠️ Estructura del Código Fuente

El proyecto se encuentra organizado en cuatro clases en Java desarrolladas desde cero:

1. **`Pizza.java` (Modelo de Datos):** Representa la entidad individual de cada pedido. Contiene el nombre de la pizza y un arreglo unidimensional rígido de tamaño 3 para almacenar los ingredientes principales.
2. **`Nodo.java` (Elemento de Enlace):** Modela el nodo de la lista ligada. Contiene un objeto `Pizza` como carga útil y una referencia al nodo `siguiente`.
3. **`Pila.java` (Estructura de Datos Dinámica):** Implementación propia de la pila con métodos nativos:
   - `push(Pizza pizza)`: Inserta un nodo en el tope.
   - `pop()`: Desapila y devuelve la pizza en la cima.
   - `peek()`: Muestra el tope sin removerlo.
   - `isEmpty()`: Valida si la pila no contiene elementos.
4. **`GestionPedidos.java` (Controlador y Menú Consola):** Gestiona la interacción con el usuario mediante un menú por consola (`Scanner`) y coordina las transferencias entre la `pilaPrincipal` y la `pilaSecundaria`.

---

##  Evidencias de Ejecución en Consola

A continuación se muestra el correcto funcionamiento del menú interactivo, el registro de pedidos y la validación de las operaciones Undo y Redo:

<img width="1918" height="1016" alt="Captura de pantalla 1 2026-09-13 145516" src="https://github.com/user-attachments/assets/d6ed9bef-31c3-4804-8eeb-6d49b9cc970e" />

<img width="1917" height="1016" alt="Captura de pantalla 2 2026-09-13 145546" src="https://github.com/user-attachments/assets/1d26c037-0ade-4862-bbce-1b131bcec8b9" />



---

## Video de Sustentación Individual

- **Enlace al video de sustentación: 
