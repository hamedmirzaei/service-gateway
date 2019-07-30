-- CREATE SEQUENCE CONTEXT_SERVICE_MAPPING_SEQ START WITH 1 INCREMENT BY 1;
INSERT INTO SERVICE_STATUS(ID, STATUS_TYPE) VALUES (1, 'PUBLISHED');
INSERT INTO SERVICE_STATUS(ID, STATUS_TYPE) VALUES (2, 'TESTED');
INSERT INTO SERVICE_STATUS(ID, STATUS_TYPE) VALUES (3, 'INACTIVE');
INSERT INTO SUB_SYSTEM_CATEGORY(ID, CATEGORY_TYPE) VALUES (1, 'ARZI');
INSERT INTO SUB_SYSTEM_CATEGORY(ID, CATEGORY_TYPE) VALUES (2, 'CHANNEL_MANAGER');
INSERT INTO CONTEXT_SERVICE_MAPPING (ID, CONTEXT_PATH, EUREKA_SERVICE_NAME, SERVICE_STATUS_ID, SUB_SYSTEM_CATEGORY_ID, CREATED_AT, UPDATED_AT) VALUES (1, 'accounts', 'account-service', 1, 1, CURRENT_TIMESTAMP , CURRENT_TIMESTAMP );
INSERT INTO CONTEXT_SERVICE_MAPPING (ID, CONTEXT_PATH, EUREKA_SERVICE_NAME, SERVICE_STATUS_ID, SUB_SYSTEM_CATEGORY_ID, CREATED_AT, UPDATED_AT) VALUES (2, 'customers', 'customer-service', 1, 1, CURRENT_TIMESTAMP , CURRENT_TIMESTAMP );