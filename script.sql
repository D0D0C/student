-- création de la table student en BDD sur postgresSQL

CREATE TABLE IF NOT EXISTS Student(
	id SERIAL PRIMARY KEY,
	first_name VARCHAR(255),
	last_name VARCHAR(255),
	date_degree DATE
	class_number INT
	);