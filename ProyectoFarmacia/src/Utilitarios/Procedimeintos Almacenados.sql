-- creacion de procediemientos
use bd_farmacia;
-- TABLA CATEGORIA
-- Listar
drop procedure if exists ListarCategoria;
delimiter @@
create procedure ListarCategoria()
begin
	select * from tb_categoria;
end @@
delimiter;
-- Buscar
drop procedure if exists BuscarCategoria;
delimiter @@
create procedure BuscarCategoria(xcod int)
begin
	select * from tb_categoria where COD_CAT=xcod;
end @@
delimiter;
-- Insertar
drop procedure if exists InsertarCategoria;
delimiter @@
create procedure InsertarCategoria(xcod int,xdesc varchar(45))
begin
	insert tb_categoria values(xcod,xdesc);
end @@
delimiter;
-- Modificar
drop procedure if exists ModificarCategoria;
delimiter @@
create procedure ModificarCategoria(xcod int ,xdescr varchar(45))
begin
	update tb_categoria set DESC_CAT=xdescr where COD_CAT=xcod;
end @@
delimiter;
-- Elimnar
drop procedure if exists EliminarCategoria;
delimiter @@
create procedure EliminarCategoria(xcod int)
begin
	delete from tb_categoria where COD_CAT=xcod;
end @@
delimiter;

-- ************************************************** 
-- TABLA CARGO
-- Listar
drop procedure if exists ListarCargo;
delimiter @@
create procedure ListarCargo()
begin
	select * from tb_cargo;
end @@
delimiter;
-- Buscar
drop procedure if exists BuscarCargo;
delimiter @@
create procedure BuscarCargo(xcod int)
begin
	select * from tb_cargo where COD_CARGO=xcod;
end @@
delimiter;
-- Insertar
drop procedure if exists InsertarCargo;
delimiter @@
create procedure InsertarCargo(xcod int,xdesc varchar(50))
begin
	insert tb_cargo values(xcod,xdesc);
end @@
delimiter;
-- Modificar
drop procedure if exists ModificarCargo;
delimiter @@
create procedure ModificarCargo(xcod int ,xdescr varchar(45))
begin
	update tb_cargo set DESC_CARGO=xdescr where COD_CARGO=xcod;
end @@
delimiter;
-- Elimnar
drop procedure if exists EliminarCargo;
delimiter @@
create procedure EliminarCargo(xcod int)
begin
	delete from tb_cargo where COD_CARGO=xcod;
end @@
delimiter;

-- ************************************************** 
-- TABLA LABORATORIO
-- Listar
drop procedure if exists ListarLaboratorio;
delimiter @@
create procedure ListarLaboratorio()
begin
	select * from tb_laboratorio;
end @@
delimiter;
-- Buscar
drop procedure if exists BuscarLaboratorio;
delimiter @@
create procedure BuscarLaboratorio(xcod int)
begin
	select * from tb_laboratorio where COD_LAB=xcod;
end @@
delimiter;
-- Insertar
drop procedure if exists InsertarLaboratorio;
delimiter @@
create procedure InsertarLaboratorio(xcod int,xdesc varchar(50))
begin
	insert tb_laboratorio values(xcod,xdesc);
end @@
delimiter;
-- Modificar
drop procedure if exists ModificarLaboratorio;
delimiter @@
create procedure ModificarLaboratorio(xcod int ,xdescr varchar(50))
begin
	update tb_laboratorio set DESC_LAB=xdescr where COD_LAB=xcod;
end @@
delimiter;
-- Elimnar
drop procedure if exists EliminarLaboratorio;
delimiter @@
create procedure EliminarLaboratorio(xcod int)
begin
	delete from tb_laboratorio where COD_LAB=xcod;
end @@
delimiter;

-- *************************************************
-- TABLA PRODUCTO
-- Listar descripcion de productos
drop procedure if exists ListarDescPro;
delimiter @@
create procedure ListarDescPro()
begin
	select p.DESC_PRO from tb_producto p;
end @@
delimiter;
-- Listar
drop procedure if exists ListarProducto;
delimiter @@
create procedure ListarProducto()
begin
	select p.COD_PRO,p.DESC_PRO,p.PRE_PRO,p.STK_ACT,p.STK_MIN,p.UNI_MED,p.FEC_VENC,l.DESC_LAB,c.DESC_CAT 
    from tb_producto p inner join tb_categoria c
    on p.COD_CAT=c.COD_CAT inner join tb_laboratorio l
    on p.COD_LAB=l.COD_LAB;
end @@
delimiter;
-- Buscar
drop procedure if exists BuscarProducto;
delimiter @@
create procedure BuscarProducto(xdes varchar(50))
begin
	select p.COD_PRO,p.DESC_PRO,p.PRE_PRO,p.STK_ACT,p.STK_MIN,p.UNI_MED,p.FEC_VENC,p.COD_LAB,p.COD_CAT
    from tb_producto p 
    where p.DESC_PRO=xdes;
end @@
delimiter;
-- Insertar
drop procedure if exists InsertarProducto;
delimiter @@
create procedure InsertarProducto(xcod char(5),xdesc varchar(70), precio decimal (10,2),
stokAct int, stokMin int, uniMed varchar(20), fecha date, codLab int,codCat int)
begin
	insert tb_producto values(xcod,xdesc,precio,stokAct,stokMin,uniMed,fecha,codLab,codCat);
end @@
delimiter;
-- Modificar
drop procedure if exists ModificarProducto;
delimiter @@
create procedure ModificarProducto(xcod char(5),xdesc varchar(70), precio decimal (10,2),
stokAct int, stokMin int, uniMed varchar(20), fecha date, codLab int,codCat int)
begin
	update tb_producto set DESC_PRO=xdesc,PRE_PRO=precio,STK_ACT=stokAct,STK_MIN=stokMin,
    UNI_MED=uniMed,FEC_VENC=fecha,COD_LAB=codLab,COD_CAT=codCat
    where COD_PRO=xcod;
end @@
delimiter;
-- Elimnar
drop procedure if exists EliminarProducto;
delimiter @@
create procedure EliminarProducto(xcod char(5))
begin
	delete from tb_producto where COD_PRO=xcod;
end @@
delimiter;

-- ************************************
-- TABLA EMPLEADO
-- Listar
drop procedure if exists ListarEmpleado;
delimiter @@
create procedure ListarEmpleado()
begin
	select * from tb_empleado;
end @@
delimiter;
-- Buscar
drop procedure if exists BuscarEmpleado;
delimiter @@
create procedure BuscarEmpleado(xcod char(5))
begin
	select * from tb_empleado where COD_EMP=xcod;
end @@
delimiter;
-- Insertar
drop procedure if exists InsertarEmpleado;
delimiter @@
create procedure InsertarEmpleado(xcodEmp char(5),nomEmp varchar(30), apePater varchar(30),
apeMater varchar(30), fecNac date, fecIngr date, userEmp varchar(45), pass varchar(45),codCargo int)
begin
	insert tb_empleado values(xcodEmp,nomEmp,apePater,apeMater,fecNac,fecIngr,userEmp,pass,codCargo);
end @@
delimiter;
-- Modificar
drop procedure if exists ModificarEmpleado;
delimiter @@
create procedure ModificarEmpleado(xcodEmp char(5),nomEmp varchar(30), apePater varchar(30),
apeMater varchar(30), fecNac date, fecIngr date, userEmp varchar(45), pass varchar(45),codCargo int)
begin
	update tb_empleado set NOM_EMP=nomEmp, APAT_EMP=apePater,AMAT_EMP=apeMater, FEC_NAC_EMP=fecNac,
    FEC_ING_EMP=fecIngr,USER_EMP=userEmp,PASS_EMP=pass,COD_CARGO=codCargo
    where COD_EMP=xcodEmp;
end @@
delimiter;
-- Elimnar
drop procedure if exists EliminarEmpleado;
delimiter @@
create procedure EliminarEmpleado(xcodEmp char(5))
begin
	delete from tb_empleado where COD_EMP=xcodEmp;
end @@
delimiter;

-- ***************************************************
-- TABLA CLIENTE
-- Listar
drop procedure if exists ListarCliente;
delimiter @@
create procedure ListarCliente()
begin
	select * from tb_cliente;
end @@
delimiter;
-- Buscar
drop procedure if exists BuscarCliente;
delimiter @@
create procedure BuscarCliente(xcodCli char(5))
begin
	select * from tb_cliente where COD_CLI=xcodCli;
end @@
delimiter;
-- Insertar
drop procedure if exists InsertarCliente;
delimiter @@
create procedure InsertarCliente(xcodCli char(5),nomCli varchar(30), apePater varchar(30),
apeMater varchar(30),fecRegCli date, tlf varchar(9))
begin
	insert tb_cliente values(xcodCli,nomCli,apePater,apeMater,fecRegCli,tlf);
end @@
delimiter;
-- Modificar
drop procedure if exists ModificarCliente;
delimiter @@
create procedure ModificarCliente(xcodCli char(5),nomCli varchar(30), apePater varchar(30),
apeMater varchar(30),fecRegCli date, tlf varchar(9))
begin
	update tb_cliente set NOM_CLI=nomCli,APAT_CLI=apePater,AMAT_CLI=apeMater,FEC_REG_CLI=fecRegCli,TLF_CLIENTE=tlf
    where COD_CLI=xcodCli;
end @@
delimiter;
-- Elimnar
drop procedure if exists EliminarCliente;
delimiter @@
create procedure EliminarCliente(xcodCli char(5))
begin
	delete from tb_cliente where COD_CLI=xcodCli;
end @@
delimiter;

-- ******************************************************************
-- TABLA PROVEEDOR
-- Listar
drop procedure if exists ListarProveedor;
delimiter @@
create procedure ListarProveedor()
begin
	select * from tb_proveedor;
end @@
delimiter;
-- Buscar
drop procedure if exists BuscarProveedor;
delimiter @@
create procedure BuscarProveedor(xcodPrv char(5))
begin
	select * from tb_proveedor where COD_PRV=xcodPrv;
end @@
delimiter;
-- Insertar
drop procedure if exists InsertarProveedor;
delimiter @@
create procedure InsertarProveedor(xcodPrv char(5),razSocPrv varchar(80), dircPrv varchar(100),tlfPrv varchar(45))
begin
	insert tb_proveedor values(xcodPrv,razSocPrv,dircPrv,tlfPrv);
end @@
delimiter;
-- Modificar
drop procedure if exists ModificarProveedor;
delimiter @@
create procedure ModificarProveedor(xcodPrv char(5),razSocPrv varchar(80), dircPrv varchar(100),tlfPrv varchar(45))
begin
	update tb_proveedor set RAZ_SOC_PRV=razSocPrv,DIR_PRV=dircPrv, TLF_PRV=tlfPrv
    where COD_PRV=xcodPrv;
end @@
delimiter;
-- Elimnar
drop procedure if exists EliminarProveedor;
delimiter @@
create procedure EliminarProveedor(xcodPrv char(5))
begin
	delete from tb_proveedor where COD_PRV=xcodPrv;
end @@
delimiter;


	












