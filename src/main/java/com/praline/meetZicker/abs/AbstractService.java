package com.praline.meetZicker.abs;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.Optional;

public abstract class AbstractService<T extends IGetId> {

    JpaRepository<T,Long> repository;
    @Autowired
    protected ModelMapper modelmapper;

    public AbstractService(JpaRepository<T, Long> repository) {
        this.repository = repository;
    }

    public List<T> getAll(){
        return repository.findAll();
    }

    public T getById(Long id){
        return  repository.findById(id).get();
    }

    public T save(T objPost){
        return  repository.save(objPost);
    }
    public T update(T objPost,Long id){
        if (objPost.getId() != id) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Inconsistent parameter");
        }

        Optional<T> ObjFrmSrv = repository.findById(objPost.getId());
        T entity = ObjFrmSrv.get();
        this.modelmapper.map(objPost, entity);

        return repository.save(entity);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

}

