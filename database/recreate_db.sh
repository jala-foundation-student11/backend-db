#!/bin/bash
# Read Password
echo -n Password for cn_database user:
read -s password
psql postgres < ./scripts/recreate_db.sql
psql cn_database < ./scripts/recreate_user.sql
export PGPASSWORD=$password
psql -h 127.0.0.1 -U cn_user -d cn_database < ./cn_database_create.sql
psql -h 127.0.0.1 -U cn_user -d cn_database < ./inserts/inserts.sql