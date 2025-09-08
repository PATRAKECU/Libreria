# Librería Virtual

## Descripción del Proyecto
Plataforma e-Commerce desarrollada en Java para la venta de libros físicos, café artesanal, tazas, soportes y separadores de página.
El sistema simula el funcionamiento de una librería moderna, con gestión de usuarios, carrito de compras, inventario y lógica de negocio orientada a objetos.


## Tecnologías Utilizadas
- Java 24
- IDE: IntelliJ IDEA
- Control de versiones: Git + GitHub

## Implementación

1. **Paquetes:**
- modelo: Contiene la clase abstracta Producto y sus subclases (Libro, Cafe, Separadores, Soportes). Aquí se implementa la lógica de inventario, herencia y polimorfismo.
- usuario: Define la clase base Usuario y sus derivadas Cliente y Administrador, con métodos sobrescritos como mostrarPerfil().
- carrito: Maneja la clase Carrito, con métodos sobrecargados para agregar productos por objeto, ID o datos sueltos.
- app: Contiene el punto de entrada (main) y pruebas en consola para validar el comportamiento del sistema.

2. **Encapsulamiento en clases principales:** Se reforzó el encapsulamiento en las clases Producto, Usuario y Carrito:
   - Todos los atributos fueron declarados como private.
   - Se implementaron getters y setters públicos según necesidad.
   - Se añadieron validaciones en los setters para proteger la integridad del sistema:
   - Validación de formato de correo electrónico en Usuario.
   - Validación de precios positivos y stock no negativo en Producto.
   - Validación de precios en productos temporales en Carrito.
    Estas medidas aseguran que los datos sensibles no puedan ser modificados de forma arbitraria y que el sistema mantenga coherencia en tiempo de ejecución.

3. **Encapsulamiento en subclases de Uusario:** Se aplicó encapsulamiento y validación en las clases Cliente y Administrador:
   - Todos los atributos fueron declarados como private.
   - Se implementaron getters públicos para acceder a listas y objetos internos.
   - Se añadieron validaciones en métodos públicos:
   - En Cliente, se valida que las preferencias no estén vacías y que los IDs de pedidos sean positivos.
   - En Administrador, se valida que los productos no sean nulos, que las cantidades sean distintas de cero, y que los precios sean positivos.

4. **Encapsulamiento en subclases de Producto:** Se reforzó el encapsulamiento en las subclases Libro, Cafe, Separadores y Soportes:
   - Todos los atributos fueron declarados como private.
   - Se implementaron getters públicos para acceder a los datos.
   - Se añadieron setters con validaciones para asegurar:
   - Que los campos de texto no estén vacíos (autor, material, tipo, etc.).
   - Que algunos atributos puedan tener únicamente entradas específicas (estado: usado o nuevo, tipo: en grano, soluble o molido, material: yeso, metal o madera, etc.)
   - Que los valores numéricos como peso y dimensiones sean positivos.



## Desafíos y Resoluciones
- **Gestión de stock:** Se implementaron incrementarStock(int) y disminuirStock(int) en Producto, incluyendo validaciones y excepciones. También se creó una versión sobrecargada de disminuirStock() para reducir una sola unidad.
- **Importaciones innecesarias:** Se depuraron los paquetes eliminando clases importadas sin uso.
- **Encapsulamiento:** Se aplica el uso de getters sin setters en las sub clases para proteger la integridad del objeto.
- **Diseño orientado a objetos:** Se añadió el atributo carrito a la clase Cliente, permitiendo simular compras, calcular totales y mostrar productos en el perfil.


## Capturas de pantalla
![Carrito](docs/carrito.png)  
![Diagrama UML](docs/uml.jpg)
![Prueba de Visualización](docs/prueba1.png)
![Atributos de Cliente Ficticio](docs/pruebaCliente.png)
![Atributos de Productos Ficticios](docs/pruebaProductos.png)
---
