CREATE TABLE MEMBER (
    ID          BIGINT         NOT NULL,
    USERNAME    VARCHAR(10)    NOT NULL,
    PASSWORD    VARCHAR(32)    NOT NULL,
    PRIMARY KEY (ID)
);

CREATE TABLE MEMBER_ROLE (
    MEMBER_ID    BIGINT         NOT NULL,
    ROLE         VARCHAR(10)    NOT NULL,
    FOREIGN KEY (MEMBER_ID) REFERENCES MEMBER
);