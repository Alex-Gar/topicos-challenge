CREATE TABLE
    topico (
        id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
        titulo VARCHAR(100) NOT NULL,
        mensaje VARCHAR(200) NOT NULL,
        fecha_creacion TIMESTAMP,
        status BOOLEAN NOT NULL DEFAULT TRUE,
        usuario_id BIGINT NOT NULL,
        curso_id BIGINT NOT NULL,
        FOREIGN KEY (usuario_id) REFERENCES usuario (id),
        FOREIGN KEY (curso_id) REFERENCES curso (id)
    );