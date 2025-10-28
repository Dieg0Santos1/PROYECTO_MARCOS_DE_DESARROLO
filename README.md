# PROYECTO_MARCOS_DE_DESARROLO

# Sistema de Gestion de Estudiantes

## Mejoras Implementadas

### 1. Diseño Visual Mejorado
- Interfaz moderna con gradientes y diseño responsivo
- Bootstrap 5.3.3 para estilos consistentes
- Cards con sombras y bordes redondeados
- Navegacion consistente en todas las paginas

### 2. Sistema de Login con Validaciones
- Pagina de login con validaciones de frontend y backend
- Pagina de registro de usuarios
- Validaciones:
  - Usuario: minimo 3 caracteres, maximo 50
  - Contraseña: minimo 6 caracteres
  - Campos obligatorios
- Sistema de sesiones
- Proteccion de rutas (redireccion a login si no esta autenticado)
- Boton de cerrar sesion en todas las paginas

### 3. Funcionalidad de Editar
- Boton "Editar" en cada registro de:
  - Estudiantes
  - Cursos
- Formulario dinamico que cambia entre "Registrar" y "Editar"
- Confirmacion antes de eliminar registros

## Instrucciones de Uso

### 1. Configurar Base de Datos
1. Asegurate de que MySQL este corriendo
2. Verifica la configuracion en `src/main/resources/application.properties`
3. La base de datos `gestion_estudiantes` debe existir

### 2. Ejecutar la Aplicacion
```bash
mvn spring-boot:run
```

### 3. Crear Usuario de Prueba
Opcion A - Usar el registro:
1. Ve a http://localhost:8080
2. Haz clic en "Registrate"
3. Crea una cuenta nueva

Opcion B - Ejecutar el script SQL:
```bash
mysql -u tu_usuario -p gestion_estudiantes < usuario_prueba.sql
```
Usuario: admin
Contraseña: admin123

### 4. Acceder al Sistema
1. Abre http://localhost:8080
2. Inicia sesion con tus credenciales
3. Accede al panel de control

## Estructura del Proyecto

```
src/main/
├── java/com/example/demo/
│   ├── controller/
│   │   ├── AuthController.java (Login/Registro)
│   │   ├── EstudianteController.java (CRUD Estudiantes)
│   │   ├── CursoController.java (CRUD Cursos)
│   │   └── MatriculaController.java (CRUD Matriculas)
│   ├── model/
│   │   ├── Usuario.java (Modelo de Usuario)
│   │   ├── Estudiante.java
│   │   ├── Curso.java
│   │   └── Matricula.java
│   ├── repository/
│   │   └── (Repositorios JPA)
│   └── service/
│       └── (Servicios de negocio)
└── resources/
    └── templates/
        ├── login.html (Vista de login)
        ├── register.html (Vista de registro)
        ├── index.html (Dashboard)
        ├── estudiantes.html (CRUD con editar)
        ├── cursos.html (CRUD con editar)
        └── matriculas.html (CRUD)
```

## Tecnologias Utilizadas
- Spring Boot 3.5.6
- Spring Data JPA
- Thymeleaf
- MySQL 8.0
- Bootstrap 5.3.3
- Jakarta Validation
