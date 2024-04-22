use EUREKABANK;
go

select * from Cliente; 
go

select * from Cuenta;
go

update cuenta set dec_cuensaldo = ? ,
int_cuencontmov = ? where chr_cuencodigo = ?
go





select dec_cuensaldo, int_cuencontmov from Cuenta;
go

select * from Movimiento 
where chr_cuencodigo = '00100001';
go

select m.int_movinumero id, 
CONVERT(varchar(30),m.dtt_movifecha,105) fecha,
t.vch_tipodescripcion tipo, m.dec_moviimporte importe 
from Movimiento m
join TipoMovimiento t
on m.chr_tipocodigo = t.chr_tipocodigo
where m.chr_cuencodigo = '00100001'
order by 1
go


insert into Movimiento(chr_cuencodigo,int_movinumero,
dtt_movifecha,chr_emplcodigo,chr_tipocodigo,
dec_moviimporte) 
values(?,?,getdate(),?,'003',?)
go

select * from TipoMovimiento;
go


select * from Moneda;
go