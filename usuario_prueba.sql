-- Script para crear un usuario de prueba
-- Ejecutar este script en MySQL después de iniciar la aplicación por primera vez

USE gestion_estudiantes;

-- Insertar un usuario de prueba (usuario: admin, password: admin123)
INSERT INTO usuario (username, password, rol) 
VALUES ('admin', 'admin123', 'ADMIN')
ON DUPLICATE KEY UPDATE username = username;
