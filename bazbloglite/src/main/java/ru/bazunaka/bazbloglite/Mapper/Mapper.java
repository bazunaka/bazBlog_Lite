package ru.bazunaka.bazbloglite.Mapper;

public interface Mapper<Dest, Source> {

    Dest map(Source source);
}
