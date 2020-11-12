-- 계정 추가 및 권한 부여

SELECT USER FROM dual;

CREATE USER hyejin IDENTIFIED BY rootroot;
GRANT CONNECT, resource, CREATE synonym, CREATE VIEW TO hyejin;

--확인

