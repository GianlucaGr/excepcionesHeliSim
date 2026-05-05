# 🚁 Enunciado: Simulador de Helicópteros

Se desea modelar un sistema de simulación para diferentes tipos de helicópteros. El objetivo es gestionar el vuelo de las aeronaves considerando su consumo de combustible, su rendimiento según el contexto y el registro de sus actividades.

## 1. El Helicóptero

Cada helicóptero en el sistema debe mantener la siguiente información:

- **Modo de Vuelo Configurado** El modo de vuelo, inicialmente todos tienen modo eficiente.
- **Combustible:** Cantidad de litros disponibles en el tanque (nunca puede ser negativo).
- **Kilometraje:** Total de kilómetros recorridos acumulados.
- **Capacidad del Tanque:** Capacidad máxima de combustible.
- **Reserva:** Se define automáticamente como el 10% de la capacidad del tanque.
- **Bitácora:** Un registro histórico de los sucesos relevantes del helicóptero (lista de mensajes).

> **Regla de Validación:** Un helicóptero no puede inicializarse con combustible negativo. De intentarse, el sistema debe informar un error de validación inmediato que interrumpa la ejecución.

---

## 2. Modos de Vuelo

El comportamiento de un helicóptero (especialmente su consumo y velocidad) varía según el modo de vuelo activo. El sistema debe permitir cambiar el modo de vuelo en tiempo de ejecución.

| Modo | Consumo (Rendimiento) | Velocidad Máxima |
| :--- | :---: | :---: |
| **Eficiente** | 14 km / litro | 180 km/h |
| **Normal** | 9 km / litro | 220 km/h |
| **Agresivo** | 6 km / litro | 280 km/h |

---

## 3. Dinámica del Vuelo

La acción de volar implica un proceso con pasos definidos que se repiten en todos los modelos, aunque algunos detalles específicos varían según el tipo de helicóptero.

### El proceso de vuelo:
1. **Validaciones iniciales:** Comprobar que el estado general sea apto para despegar.
2. **Preparación:** Tareas específicas según el tipo de helicóptero (ej. chequeo de pasajeros o sistemas).
3. **Ejecución:** Lógica base de cálculo de consumo, actualización de kilómetros y gestión de combustible.
4. **Finalización:** Tareas de cierre y registro en bitácora.

### Lógica de consumo y alcance:
- **Vuelo Exitoso:** Si hay combustible suficiente, se recorren todos los kilómetros y se descuenta el combustible proporcional. El método debe retornar el tiempo estimado de vuelo (distancia / velocidad).
- **Uso de Reserva:** Si para completar el trayecto el helicóptero debe utilizar combustible que está dentro del margen de la reserva (el último 10% del tanque), el vuelo se completa pero se debe notificar una alerta de "Uso de Reserva".
- **Combustible Insuficiente:** - Si se intenta realizar un vuelo y el combustible no alcanza (ni siquiera usando la reserva), el vuelo **no se realiza**, no se modifican los atributos del helicóptero y se debe informar el error.
  - **Excepción:** El sistema debe permitir una variante donde el piloto indique "volar hasta donde se pueda". En este caso, el helicóptero vuela hasta que el tanque queda en 0.0, recorre la distancia parcial proporcional y no informa errores de falta de combustible.

---

## 4. Modelos Específicos

### Helicóptero Civil
Está destinado al transporte de pasajeros. 
- **Antes de volar:** Debe registrar en su bitácora: *"Pasajeros y equipaje verificados. Listo para despegue."*
- **Al finalizar:** Debe registrar: *"Vuelo civil completado: [km] km. Pasajeros desembarcados."*

### Helicóptero Militar
Está destinado a misiones tácticas.
- **Antes de volar:** Debe registrar: *"Sistemas de armas y navegación activados."*
- **Restricción Crítica:** Si el modo de vuelo actual es **Agresivo** y el combustible disponible es **menor a 20 litros**, la misión debe abortarse por seguridad antes de realizar cualquier acción (incluyendo la bitácora).
- **Al finalizar:** Debe registrar: *"Misión completada: [km] km. Regresando a base."*

---

## 5. Gestión de Errores y Excepciones

El diseño debe contemplar diferentes estrategias para el manejo de fallos:

1. **Gestión Estricta:** Situaciones donde el programador que utiliza la clase está obligado a decidir qué hacer si el combustible es insuficiente o si se entra en reserva.
2. **Gestión Silenciosa:** Se debe proveer un mecanismo de "intento de vuelo" que gestione internamente los errores de combustible. Si el vuelo falla por falta de carga, simplemente debe informar el problema por consola y devolver 0 km recorridos, permitiendo que el resto del programa continúe sin interrupciones abruptas.

---

## 6. Requerimientos Técnicos Sugeridos

- Aplicar polimorfismo para los Modos de Vuelo.
- Utilizar una estructura que evite la duplicación de la lógica de vuelo en las subclases de Helicóptero.
- Diferenciar correctamente entre errores de validación de estado y errores de flujo de negocio.
- Validar el comportamiento mediante pruebas unitarias (Tests).