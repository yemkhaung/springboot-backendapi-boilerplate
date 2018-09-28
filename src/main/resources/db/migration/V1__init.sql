-- Sample data table

create table data (
    id varchar(255) PRIMARY KEY AUTO_INCREMENT,
    data_id varchar(255),
    title varchar(255),
    description text,
    created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
);

insert into data (data_id, title, description)
values (
    'D001',
    'Data 1st',
    'The First Data'
);