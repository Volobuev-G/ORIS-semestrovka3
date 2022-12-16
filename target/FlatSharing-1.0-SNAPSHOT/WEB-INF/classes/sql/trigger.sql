/*Trigger for users*/
create function if_null_default() returns trigger
    language plpgsql
as
$$
BEGIN
    update users
    set image = 'defaultUser.jpg'
    where image IS NULL;
    return new;
end
$$;

create trigger if_null_default
    after insert on users
    for each row execute function if_null_default();

/*Trigger for flats*/
create function if_null_default_flat() returns trigger
    language plpgsql
as
$$
BEGIN
    update flat
    set image = 'defaultFlat.jpg'
    where image IS NULL;
    return new;
end
$$;

create trigger if_null_default_flat
    after insert on flat
    for each row execute function if_null_default_flat();
