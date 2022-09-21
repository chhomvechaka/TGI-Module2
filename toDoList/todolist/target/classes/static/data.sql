INSERT INTO privilege (privilege_id, name, description) VALUES (1, 'PRIVILEGE_ADMIN_READ', 'description for privilege admin read');
INSERT INTO privilege (privilege_id, name, description) VALUES (2, 'PRIVILEGE_USER_READ', 'description for privilege user read');
--getall and Read are work the same
INSERT INTO privilege (privilege_id, name, description) VALUES (8, 'PRIVILEGE_USER_Write', 'description for privilege user write');
INSERT INTO privilege (privilege_id, name, description) VALUES (3, 'PRIVILEGE_ADMIN_GETALL', 'description for privilege admin getall');
INSERT INTO privilege (privilege_id, name, description) VALUES (4, 'PRIVILEGE_ADMIN_UPDATE', 'description for privilege admin update');
INSERT INTO privilege (privilege_id, name, description) VALUES (5, 'PRIVILEGE_ADMIN_DELETE', 'description for privilege user delete');
INSERT INTO privilege (privilege_id, name, description) VALUES (6, 'PRIVILEGE_ADMIN_INSERT', 'description for privilege user insert');
INSERT INTO privilege (privilege_id, name, description) VALUES (7, 'PRIVILEGE_ADMIN_GETBYID', 'description for privilege user getbyid');
INSERT INTO role (role_id, name, description) VALUES (1, 'ROLE_ADMIN', 'description for role admin');
INSERT INTO role (role_id, name, description) VALUES (2, 'ROLE_USER', 'description for role user');
--password group4 for role admin
INSERT INTO user_account (id, enabled, username, password) VALUES (1, true, 'admin', '$2a$12$OHyePcJpt88u0jVIGxJ6EOMLlGRHAuGpr0yoKXzTjsEGuX6ZkRj4S');
--password user for role user
INSERT INTO user_account (id, enabled, username, password) VALUES (2, true, 'user', '$2a$10$6KDklkImZgGANWR8pDAwSexf6Bt4Z9I0nDiwdih9Q38HI4eAkWk0u');

INSERT INTO user_account_roles (user_account_id, roles_role_id) VALUES (1, 1);
INSERT INTO user_account_roles (user_account_id, roles_role_id) VALUES (2, 2);
--Connect between role and privilege admin can access all privilege
INSERT INTO role_privileges (role_role_id, privileges_privilege_id) VALUES (1, 1);
  INSERT INTO role_privileges (role_role_id, privileges_privilege_id) VALUES (1, 2);
    INSERT INTO role_privileges (role_role_id, privileges_privilege_id) VALUES (1, 4);
    INSERT INTO role_privileges (role_role_id, privileges_privilege_id) VALUES (1, 5);
  INSERT INTO role_privileges (role_role_id, privileges_privilege_id) VALUES (1, 6);
INSERT INTO role_privileges (role_role_id, privileges_privilege_id) VALUES (1, 7);
--Connect between role and privilege User can access only
INSERT INTO role_privileges (role_role_id, privileges_privilege_id) VALUES (2, 1);
INSERT INTO role_privileges (role_role_id, privileges_privilege_id) VALUES (2, 4);
INSERT INTO role_privileges (role_role_id, privileges_privilege_id) VALUES (2, 2);
INSERT INTO role_privileges (role_role_id, privileges_privilege_id) VALUES (2, 6);