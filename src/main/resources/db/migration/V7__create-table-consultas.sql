CREATE TABLE consultas(

    id Bigint NOT NULL auto_increment,
    medico_id bigint NOT NULL,
    paciente_id bigint NOT NULL,
    data datetime NOT NULL,

    PRIMARY KEY(id)

    constraint fk_consultas_medico_id Foreign Key (medico_id) REFERENCES medicos(id)
    constraint fk_consultas_paciente_id Foreign Key (paciente_id) REFERENCES pacientes(id)
)