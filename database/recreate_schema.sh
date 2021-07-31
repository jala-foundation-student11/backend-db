#!/bin/bash
# Read Password
echo -n Password for database user:
read -s password
psql cn_database < ./scripts/recreate_schema.sql
export PGPASSWORD=$password
psql -h 127.0.0.1 -U cn_user -d cn_database < ./cn_database_create.sql
psql -h 127.0.0.1 -U cn_user -d cn_database < ./inserts/inserts.sql



