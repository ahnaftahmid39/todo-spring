CREATE TABLE IF NOT EXISTS todos (
    id SERIAL PRIMARY KEY,
    starred BOOLEAN,
    completed BOOLEAN,
    description TEXT
);