package com.todolist.todolist.BaseService;
import java.io.Serializable;
public interface Baseservice<Dresponse,Dresponselist,key extends Serializable,Tentity>{
    Dresponselist getalldata();
    Dresponse Create(Tentity model);
    String Update(key id,Tentity model);
    Dresponse Delete(key id,Tentity model);
}
