use bd_farmacia;

drop procedure if exists AutentificarUsuario;

delimiter @@
CREATE procedure  AutentificarUsuario(xuser varchar(45), xpas varchar(45))
begin
	select * from tb_empleado where user_emp=xuser and pass_emp=xpas;
end @@
delimiter ;

-- Inserción tb_cargo
INSERT INTO `bd_farmacia`.`tb_cargo` (`DESC_CARGO`) VALUES ('Administrador');
INSERT INTO `bd_farmacia`.`tb_cargo` (`DESC_CARGO`) VALUES ('Vendedor');

--Inserción empleado
INSERT INTO `bd_farmacia`.`tb_empleado` (`COD_EMP`, `NOM_EMP`, `APAT_EMP`, `AMAT_EMP`, `FEC_NAC_EMP`, `FEC_ING_EMP`, `USER_EMP`, `PASS_EMP`, `COD_CARGO`) VALUES ('E0001', 'Empl01', 'pater01', 'mat01', '1982-03-15', '2017-07-03', 'user01', 'pas01', '1');
INSERT INTO `bd_farmacia`.`tb_empleado` (`COD_EMP`, `NOM_EMP`, `APAT_EMP`, `AMAT_EMP`, `FEC_NAC_EMP`, `FEC_ING_EMP`, `USER_EMP`, `PASS_EMP`, `COD_CARGO`) VALUES ('E0002', 'Empl02', 'par02', 'mat02', '1986-02-10', '2017-06-11', 'user02', 'pas02', '2');
