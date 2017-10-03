package main.service;

import main.dao.MyDao1;
import main.dao.MyDao2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author The Weather Company, An IBM Business
 */
@Service
public class MyService {
    private final MyDao1 myDao1;
    private final MyDao2 myDao2;

    @Autowired
    public MyService(MyDao1 myDao1, MyDao2 myDao2) {
        this.myDao1 = myDao1;
        this.myDao2 = myDao2;
    }

    @Transactional
    public void save(){
        myDao1.save();
        if(true)
            throw new RuntimeException();
        myDao2.save();
    }
}
