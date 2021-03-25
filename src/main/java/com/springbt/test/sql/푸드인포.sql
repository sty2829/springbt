create table food_info(
fi_num number(7) not null primary key,
fi_name varchar2(100) not null,
fi_price number(6) default 0,
fi_type varchar2(30) not null,
fi_desc clob not null,
credat date default sysdate,
active char(1) default '1'
);

create sequence seq_fi_num nocache;



select * from food_info;


