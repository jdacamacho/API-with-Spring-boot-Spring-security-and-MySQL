-- Roles
INSERT INTO roles (role_id, name, description) VALUES ('1', 'ROLE_Admin', 'Full access to the system');
INSERT INTO roles (role_id, name, description) VALUES ('2', 'ROLE_User', 'Limited access with basic user permissions');
INSERT INTO roles (role_id, name, description) VALUES ('3', 'ROLE_Guest', 'Read-only access to public information');
-- User Zero
INSERT INTO users_light(user_id, name) VALUES (10000, 'admin');
INSERT INTO users (user_id, username, password) VALUES(10000, 'admin', '$2a$10$nxrnPIeMznZxMRHQGIrgte4urL6cHp7raueicU1qfdI7Ibisdrkim');
INSERT INTO user_roles(user_id, role_id) VALUES (10000, 1);