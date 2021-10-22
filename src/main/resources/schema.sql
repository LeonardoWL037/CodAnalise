create or replace function cria_mentor()
returns trigger as $$
BEGIN
if new.mentor then
insert into public.mentor(usuario_id,ativo) values (New.id,true);
return NULL;
else
return null;
end if;
END;
$$ language 'plpgsql';


	CREATE TRIGGER trg_cria_mentor
    AFTER INSERT OR UPDATE 
    ON public.usuario
    FOR EACH ROW
    EXECUTE FUNCTION public.cria_mentor();
	
	
	
	