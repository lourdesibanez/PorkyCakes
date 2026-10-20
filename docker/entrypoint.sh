#!/bin/sh
set -e

mkdir -p /run/mysqld && chown mysql:mysql /run/mysqld
[ -d /var/lib/mysql/mysql ] || mariadb-install-db --user=mysql >/dev/null

# MariaDB con poca memoria: el plan gratis de Render tiene 512 MB para todo el contenedor.
# lower-case-table-names: el código consulta USUARIO, PEDIDO, etc. en mayúsculas (en Windows andaba igual)
mariadbd --user=mysql --bind-address=127.0.0.1 --skip-name-resolve \
  --performance-schema=OFF --innodb-buffer-pool-size=16M --innodb-log-file-size=8M \
  --key-buffer-size=1M --max-connections=20 \
  --lower-case-table-names=1 &

until mariadb-admin ping --silent; do sleep 1; done

mariadb <<SQL
CREATE DATABASE IF NOT EXISTS porkydb CHARACTER SET utf8mb4;
CREATE USER IF NOT EXISTS '$DB_USER'@'127.0.0.1' IDENTIFIED BY '$DB_PASS';
GRANT ALL ON porkydb.* TO '$DB_USER'@'127.0.0.1';
SQL
mariadb porkydb < porkydb.sql

exec java -Xmx200m -jar app.jar
