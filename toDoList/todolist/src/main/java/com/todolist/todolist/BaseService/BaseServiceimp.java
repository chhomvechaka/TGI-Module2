package com.todolist.todolist.BaseService;
import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
@Service
public abstract class BaseServiceimp<Dresponse,Dresponselist,Tkey extends Serializable,Tentity> implements Baseservice<Dresponse,Dresponselist,Tkey,Tentity>{
    protected abstract JpaRepository<Dresponse,Tkey> getrepository();


}
