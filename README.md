# Adivina el Número - Guess the Number

## Índice

* Introducción

* Resumen del Proyecto

* Objetivos de Aprendizaje

* Consideraciones Generales

* Consideraciones Técnicas

* Hitos del Proyecto
---

## 1. Preámbulo

En la actualidad, Java es uno de los lenguajes de programación más utilizados en
el mundo. A pesar de la diversidad de plataformas y herramientas disponibles, es
fundamental tener una base sólida en los conceptos fundamentales de Java y en la
programación orientada a objetos (OOP). El objetivo de este proyecto es
introducirte al mundo de Java a través de un juego simple y divertido.

![GUESS THE NUMBER](https://firebasestorage.googleapis.com/v0/b/laboratoria-945ea.appspot.com/o/guess-the-number.png?alt=media)

* INTRODUCCIÓN: 

Muy contenta de haber terminado este proyecto en Java, " adivina el Número ". Es un juego interactivo donde la jugadora y la computadora se turnan para adivinar el núnero objetivo entre 0 y 100. Fue un gran reto lleno de desafíos para mí, por que estaba en zeros en este lenguaje typado

## 2. Resumen del Proyecto

Es un juego interactivo que se desarrolla en el terminal, Mi lógica principal del juego la tengo en la clase GuessTheNumberGame. Esta clase maneja la generación del número aleatorio, la alternancia de turnos entre la jugadora y la computadora, y evalúa cada suposición realizada. El objetivo es adivinar el número objetivo lo más rápido posible.
Deben tener en cuenta la tentativa anterior, si está "cerca" o "lejos".

![GUESS THE NUMBER DEMO](https://firebasestorage.googleapis.com/v0/b/laboratoria-945ea.appspot.com/o/guess-the-number-demo.gif?alt=media)

## 3. Objetivos de Aprendizaje

En este proyecto comprendi datos primitivos y no primitivos en java. Aplicación de conceptos de OOP como manejo de clases, objetos, métodos, atributos, constructores, encapsulamiento, abstracción, modificadores de acceso( Public, private, protected y por defecto), manejo de cadenas, arrays, implementación de condicionales y bucles. Uso de JUnit y Mockito para realizar pruebas unitarias.

## 4. Consideraciones Generales

El proyecto se completó individualmente en un lapso de 1 a 2 sprints, enfocándome en adquirir conocimientos más que en simplemente finalizar el proyecto. A lo largo del proceso, mantuve la paciencia y la mentalidad de aprendizaje, consciente de que el progreso es clave.
  
  (se recomienda usar [IntelliJ Community Edition](https://www.jetbrains.com/idea/download/)).

* Consideraciones Técnicas 

El juego se implementó en Java, utilizando únicamente JUnit y Mockito como dependencias externas para pruebas unitarias. La interacción se realiza en el terminal, y se ha incorporado un número aleatorio entre 1 y 100 como el objetivo a adivinar.

* Hitos del proyecto

Hito 1- Configuración del entorno de trabajo En esta etapa, configuré mi entorno de trabajo descargando e instalando Java  y utilizando IntelliJ Community Edition como mi IDE. 

Hito 2 - Primeros pasos con el lenguaje Comencé creando la primera clase del proyecto con el método main que muestra "¡Hola mundo!" en la consola. Esto me permitió familiarizarme con conceptos básicos de Java y tipos de datos.

Hito 3 - Comprensión del Diagrama de Clases Dediqué tiempo a comprender el Diagrama de Clases proporcionado, estableciendo una base sólida para la estructura del juego.

### Diagrama de Clases

![Diagrama de Clases](https://firebasestorage.googleapis.com/v0/b/laboratoria-945ea.appspot.com/o/class-diagram.png?alt=media)

Hito 4 - Iniciando el juego Implementé la lógica para un solo jugador llamado player 1, creando la clase HumanPlayer, generando el número objetivo y evaluando las suposiciones, mostrando un mensaje si estaba cerca o lejos del número objetivo.

Hito 5 - Agregando más jugadoras, Se añadió la lógica para la segunda jugadora llamada player 2, la computadora. Desarrollé la alternancia de turnos y mostré información adicional al finalizar el juego y las suposiciones realizadas.

Hito 6 - Configuración para la construcción de pruebas unitarias Configuré JUnit5 y Mockito en mi IDE para facilitar la creación de pruebas unitarias. Esto aseguró la calidad y funcionalidad del código desarrollado.

6.7 Hito 7 - Creación de pruebas unitarias Desarrollé pruebas unitarias que cubren la lógica del juego, simulando diferentes escenarios como suposiciones cerca, lejos y correctas. Esto garantiza el buen funcionamiento del proyecto.

Hito 8 (Edición Hacker) - Creación de una "inteligencia" para jugar contra la computadora En este hito adicional, implementé una lógica más inteligente para la segunda jugadora cuando se juega contra la computadora. Implemente un nuevo atributo llamado limit el cual cambia conforme lee y razona la ultima respuesta del jugador player , para ver si esta cerca o lejos y cambiar el limite del numero aleatorio que genera. Esto agregó emoción al juego.


#### Contenidos que pueden ayudarte en los primeros pasos con Java

- [Learn the Basics of Java Programming](https://www.freecodecamp.org/news/learn-the-basics-of-java-programming/)
- [Programación Orientada a Objetos com Java](https://www.freecodecamp.org/news/object-oriented-programming-concepts-java/)
- [Java Basic Syntax](https://www.geeksforgeeks.org/java-basic-syntax/)
- [Java Data Types And Variables – Explained for Beginners](https://www.freecodecamp.org/news/java-data-types-and-variables/)
- [Learn Java](https://www.w3schools.com/java/default.asp)
- [Java Classes and Objects](https://www.w3schools.com/java/java_classes.asp)
- [Java Methods](https://www.w3schools.com/java/java_methods.asp)

#### Contenidos que pueden ayudarte en la comprensión del Diagrama de Clases

- [¿Qué son los Diagramas de Clase?](https://diagramasuml.com/diagrama-de-clases/)


#### Contenidos que pueden ayudarte a comenzar el juego

- [Java: Cómo leer y presentar datos con los comandos de entrada y salida](https://www.programarya.com/Cursos/Java/Entrada-de-datos)
- [Java Scanner](https://www.baeldung.com/java-scanner)
- [Scanner class in Java](https://www.geeksforgeeks.org/scanner-class-in-java/)
- [Java User Input](https://www.w3schools.com/java/java_user_input.asp)
- [Número Aleatorio](https://www.baeldung.com/java-17-random-number-generators)


Le recomendamos que utilice las bibliotecas presentes en el repositorio de Maven:

- org.junit.jupiter:junit-jupiter
- org.mockito:mockito-core

#### Contenidos que pueden ayudarte a agregar dependencias de pruebas

- [Agregar JUnit5 en IntelliJ](https://www.jetbrains.com/help/idea/junit.html#intellij)
- [Testing Java with VSCode](https://code.visualstudio.com/docs/java/java-testing)


- [Calidad y JUnit: Introducción a la automatización de pruebas unitarias en tu software Java en el día a día](https://www.tutorialspoint.com/junit/index.htm)
- [Tutorial de Mockito](https://www.digitalocean.com/community/tutorials/mockito-tutorial)


## 7. Recomendaciones Generales

Documentación de Java: La documentación oficial de Java fue una valiosa fuente de información. Diseño de la Estructura del Juego: Antes de codificar, diseñé la estructura del juego, permitiendo una implementación organizada. Separación de Responsabilidades: Siguiendo el diagrama de clases, logré una clara separación de la lógica del juego para mantener el código organizado. Bucles y Condiciones: Utilicé bucles y declaraciones condicionales para controlar los turnos y evaluar suposiciones. Manipulación de Números Aleatorios: Implementé la clase Random para generar números aleatorios, siguiendo las mejores prácticas. Pruebas Unitarias: Escribí pruebas unitarias para garantizar el correcto funcionamiento del juego en diferentes situaciones. ¡Fue una gran experiencia trabajar en este proyecto! Espero que disfruten jugando a "Adivina el Número". 

**_¡Diviértete construyendo tu juego de adivinanza de números! 🎲🎮_**
