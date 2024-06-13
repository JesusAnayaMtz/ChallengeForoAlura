INSERT INTO perfiles (nombre) VALUES ('ROLE_USER');
SET @perfil_id = LAST_INSERT_ID();

INSERT INTO usuarios (nombre, email, password) VALUES ('jesus', 'jesus@foro.com', '$2y$10$XDUe29zxSoDK3R3G77W0EugfwEeDXB/.QOBTGtW8E9MZtSy7jExRO');
SET @usuario_id = LAST_INSERT_ID();

INSERT INTO user_profile (usuario_id, perfil_id) VALUES (@usuario_id, @perfil_id);