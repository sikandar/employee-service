#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL
    CREATE DATABASE postgres; 
    ALTER SYSTEM SET max_connections TO '1000';
    select pg_reload_conf();
EOSQL
