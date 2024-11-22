package hvnh.delitask_serverapi.service;

import hvnh.delitask_serverapi.repository.OrderCRUD;
import hvnh.delitask_serverapi.repository.UsersCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderCRUD orderCRUD;
    @Autowired
    UsersCRUD usersCRUD;

    public int countOrder(String username){
        return orderCRUD.countByCustomerId(usersCRUD.findByUsername(username).getId());
    }
}
