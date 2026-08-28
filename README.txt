🪙 Wallet API - Mi Billetera Virtual Backend

¡Hola! Este es el backend de una Billetera Virtual que desarrollé usando Java y Spring Boot. El objetivo principal de este proyecto fue poner en práctica la lógica de negocio detrás de un sistema financiero: creación de usuarios, manejo de cuentas bancarias y un motor transaccional seguro (depósitos, retiros y transferencias).

---

## 🚀 Tecnologías que usé

Lenguaje: Java 
Framework Backend: Spring Boot 3
Spring Data JPA: Para el mapeo ORM y consultas a la base de datos.
Spring Web: Para construir los endpoints RESTful.
Base de Datos: MySQL gestionado con phpMyAdmin.
Herramientas de Lógica y Errores:
  * Uso de `BigDecimal` para evitar problemas de precisión en los montos de dinero.
  * Manejo global de excepciones con `@RestControllerAdvice` para devolver errores limpios en formato JSON (`400 Bad Request`).
  * Patrón DTO para desacoplar las entidades de la base de datos de los JSON de entrada.

---

🛠️ ¿Cómo está estructurado el proyecto?

Organicé el código siguiendo una arquitectura en capas sencilla y clara:

* `controller/`: Expone las rutas de la API para recibir los JSON.
* `service/`: Tiene la lógica de negocio (validaciones de saldo, transferencias entre cuentas y reglas financieras).
* `repository/`: Consultas a la base de datos con JPA y JPQL custom.
* `model/`: Las entidades principales (`Usuario`, `Cuenta`, `Transaccion`).
* `dto/` y `exception/`: Clases para transferir datos de entrada y manejar respuestas de error globales.

---

⚙️ ¿Qué se puede hacer con la API?

1. Gestión de Usuarios y Cuentas: Registro de usuarios y asignación de cuentas bancarias con CBU único.
2. Depósitos: Sumar dinero a una cuenta indicando su CBU.
3. Retiros: Extracción de fondos (valida antes que haya saldo suficiente).
4. Transferencias: Operación atómica entre dos CBUs. Si la cuenta de origen no tiene saldo o es la misma cuenta, la operación se frena.
5. Historial: Consultar los movimientos (enviados y recibidos) de una cuenta específica por su ID.

---

📌 Endpoints de la API

| Método | Endpoint | Descripción | Body de ejemplo (JSON) |
| :--- | :--- | :--- | :--- |
| `POST` | `/api/transacciones/deposito` | Realiza un depósito | `{ "cbu": "...", "monto": 1000.00 }` |
| `POST` | `/api/transacciones/retiro` | Realiza un retiro | `{ "cbu": "...", "monto": 500.00 }` |
| `POST` | `/api/transacciones/transferencia` | Transfiere entre cuentas | `{ "cbuOrigen": "...", "cbuDestino": "...", "monto": 250.00 }` |
| `GET` | `/api/transacciones/historial/{idCuenta}` | Ver historial |

