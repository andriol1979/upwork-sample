package com.kbtool.repository;

import dev.morphia.Datastore;
import dev.morphia.query.FindOptions;
import dev.morphia.query.Query;
import dev.morphia.query.experimental.filters.Filters;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Scope("singleton")
public class MongoRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(MongoRepository.class);
    @Autowired
    private Datastore morphiaDatastore;

    public <T>T save(Object object) {
        return (T) morphiaDatastore.save(object);
    }
    public <T> T loadById(Class<?> clazz, String id) {
        return (T) morphiaDatastore.find(clazz).filter(Filters.eq("id", new ObjectId(id))).first();
    }

    public <T> T loadById(Class<?> clazz, ObjectId id) {
        return (T) morphiaDatastore.find(clazz).filter(Filters.eq("id", id)).first();
    }

    public <T> T loadByRecId(Class<?> clazz, long recId) {
        return (T) morphiaDatastore.find(clazz).filter(Filters.eq("recId", Long.valueOf(recId))).first();
    }

    public <T> T loadByProperty(Class<?> clazz, String filterKey, Object filterValue) {
        return (T) morphiaDatastore.find(clazz).filter(Filters.eq(filterKey, filterValue)).first();
    }

    public <T> T loadByProperties(Class<T> type, Map<String, Object> filterMap) {
        Query<T> q = morphiaDatastore.find(type);
        for (String key : filterMap.keySet()) {
            q.filter(Filters.eq(key, filterMap.get(key)));
        }
        return q.first();
    }

    @SuppressWarnings("unchecked")
    public List loadListByProperty(Class clazz, String filterKey, Object filterValue) {
        return morphiaDatastore.find(clazz)
            .filter(Filters.eq(filterKey, filterValue)).iterator()
            .toList();
    }

    public List loadListByProperties(Class clazz, Map<String, Object> filterMap) {
        Query q = morphiaDatastore.find(clazz);
        for (String key : filterMap.keySet()) {
            q.filter(Filters.eq(key, filterMap.get(key)));
        }
        return q.iterator().toList();
    }

    public List loadAll(Class clazz, FindOptions fo) {
        Query<Object> query = morphiaDatastore.find(clazz);
        return (fo != null) ? query.iterator(fo).toList() : query.iterator().toList();
    }

    public List loadAll(Class clazz) {
        Query<Object> query = morphiaDatastore.find(clazz);
        return query.iterator().toList();
    }

    public void delete(Object object) {
        morphiaDatastore.delete(object);
    }
}
