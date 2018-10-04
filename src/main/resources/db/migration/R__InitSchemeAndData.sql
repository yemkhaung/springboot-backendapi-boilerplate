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
insert into data (data_id, title, description)
values (
    'D002',
    'Data 2nd',
    'The 2nd Data'
);
insert into data (data_id, title, description)
values (
    'D003',
    'Data 3rd',
    'The 3rd Data'
);
insert into data (data_id, title, description)
values (
    'D004',
    'Data 4th',
    'The 4th Data'
);
insert into data (data_id, title, description)
values (
    'D005',
    'Data 5th',
    'The 5th Data'
);