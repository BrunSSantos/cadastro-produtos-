create database bdprojetoproduto;
use bdprojetoproduto;

CREATE TABLE tb_produto (
tb_produto_id integer primary key not null auto_increment,
tb_produto_cod varchar(32) not null,
tb_produto_statuss char(1) not null default 'I',
tb_produto_nome varchar(32) not null,
tb_produto_descricao varchar(258),
tb_produto_qtd_estoque int not null,
tb_produto_estoque_minimo int,
tb_produto_estoque_maximo int,
tb_produto_preco_compra DECIMAL(12,2) not null,
tb_produto_preco_venda DECIMAL(12,2) not null,
tb_produto_bar_code bigint null default null,
tb_produto_ncm int null default null,
tb_produto_fator DECIMAL(12,2) not null,
tb_produto_data_cadastro varchar(32) not null,
tb_produto_imagem VARCHAR(255) null default null);

create table tb_login(
tb_login_id integer primary key not null auto_increment,
tb_login_email varchar(32) not null,
tb_login_senha varchar(32) not null
);


insert into tb_login(
tb_login_email, tb_login_senha)
values ("bruno.123@gmail.com","12345");

select *from tb_login;

drop database bdprojetoproduto;
