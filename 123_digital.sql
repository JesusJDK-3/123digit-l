CREATE DATABASE BD_123Digital;

-- Tabla Clientes
CREATE TABLE Clientes (
    id_cliente SERIAL PRIMARY KEY,
    nombre_completo VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    telefono VARCHAR(20),
    tipo_cliente VARCHAR(20) NOT NULL CHECK (tipo_cliente IN ('Empresa', 'Persona Natural')),
    CONSTRAINT email_formato CHECK (email ~* '^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$')
);

-- Tabla Solicitudes
CREATE TABLE Solicitudes (
    id_solicitud SERIAL PRIMARY KEY,
    id_cliente INT NOT NULL,
    tipo_solicitud VARCHAR(50) NOT NULL CHECK (tipo_solicitud IN ('Error de software', 'Capacitación', 'Requerimiento de software')),
    detalle TEXT NOT NULL,
    estado_solicitud VARCHAR(20) NOT NULL CHECK (estado_solicitud IN ('Pendiente', 'En Proceso', 'Concluida')),
    fecha_registro DATE DEFAULT CURRENT_DATE,
    FOREIGN KEY (id_cliente) REFERENCES Clientes(id_cliente) ON DELETE CASCADE
);

-- Tabla Colaboradores
CREATE TABLE Colaborador (
    id_colaborador SERIAL PRIMARY KEY,
    nom_colaborador VARCHAR(100) NOT NULL,
    espe_colaborador VARCHAR(50) NOT NULL,
    tipo_colaborador VARCHAR(50) NOT NULL CHECK (tipo_colaborador IN ('Analista', 'Diseñador', 'Programador', 'Coordinador'))
);

-- Tabla Asignaciones
CREATE TABLE Asignaciones (
    id_asignacion SERIAL PRIMARY KEY,
    id_solicitud INT NOT NULL,
    id_colaborador INT NOT NULL,
    rol_solicitud VARCHAR(50) NOT NULL CHECK (rol_solicitud IN ('Colaborador', 'Coordinador')),
    fecha_asignacion DATE DEFAULT CURRENT_DATE,
    FOREIGN KEY (id_solicitud) REFERENCES Solicitudes(id_solicitud) ON DELETE CASCADE,
    FOREIGN KEY (id_colaborador) REFERENCES Colaborador(id_colaborador) ON DELETE CASCADE
);

-- Tabla Actividades
CREATE TABLE Actividades (
    id_actividad SERIAL PRIMARY KEY,
    id_solicitud INT NOT NULL,
    id_colaborador INT NOT NULL,
    descrip_actividad TEXT,
    tiempo_empleado DECIMAL(5, 2) CHECK (tiempo_empleado > 0),
    fecha_actividad DATE DEFAULT CURRENT_DATE,
    FOREIGN KEY (id_solicitud) REFERENCES Solicitudes(id_solicitud) ON DELETE CASCADE,
    FOREIGN KEY (id_colaborador) REFERENCES Colaborador(id_colaborador) ON DELETE CASCADE
);




-- Restricciones adicionales con ALTER TABLE

-- Restringir solicitudes a solo un coordinador por solicitud
ALTER TABLE Asignaciones ADD CONSTRAINT unico_coordinador UNIQUE (id_solicitud, rol_solicitud)
    WHERE rol_solicitud = 'Coordinador';

-- Restringir que cada colaborador no pueda asignarse más de una vez a la misma solicitud
ALTER TABLE Asignaciones ADD CONSTRAINT unico_colaborador_solicitud UNIQUE (id_solicitud, id_colaborador);

-- Asegurar que las actividades están registradas correctamente en Solicitudes existentes
ALTER TABLE Actividades ADD CONSTRAINT actividad_solicitud_fk FOREIGN KEY (id_solicitud)
    REFERENCES Solicitudes(id_solicitud) ON DELETE CASCADE;

-- Asegurar que las actividades están registradas por colaboradores existentes
ALTER TABLE Actividades ADD CONSTRAINT actividad_colaborador_fk FOREIGN KEY (id_colaborador)
    REFERENCES Colaborador(id_colaborador) ON DELETE CASCADE;

-- Restringir que los emails de clientes sean únicos y con formato válido
ALTER TABLE Clientes ADD CONSTRAINT email_valido UNIQUE (email);
ALTER TABLE Clientes ADD COLUMN password VARCHAR(100) NOT NULL;
ALTER TABLE Colaborador 
ADD COLUMN email VARCHAR(100) NOT NULL UNIQUE,
ADD COLUMN password VARCHAR(100) NOT NULL;



-- Cliente tipo Empresa
INSERT INTO Clientes (nombre_completo, email, telefono, tipo_cliente, password)
VALUES ('Tech Solutions S.A.', 'contacto@techsolutions.com', '987654321', 'RUC20240253', 'password123');

-- Cliente tipo Persona Natural
INSERT INTO Clientes (nombre_completo, email, telefono, tipo_cliente, password)
VALUES ('Juan Pérez', 'juan.perez@example.com', '912345678', '75768721', 'securepassword456');
