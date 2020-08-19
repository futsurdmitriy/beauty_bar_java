/*
 * Class name :  ClientServiceImpl
 *
 * @author Dmitriy Futsur
 *
 * @version 1.0.0 17-Aug-2020
 *
 * Copyright (c) Dmitriy Futsur
 *
 * Description:
 */

package fuda.com.beauty_bar.service.client.impls;

import fuda.com.beauty_bar.model.Client;
import fuda.com.beauty_bar.repository.ClientRepository;
import fuda.com.beauty_bar.service.client.interfaces.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientServiceImpl implements IClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public Client create(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client get(String id) {
        return null;
    }

    @Override
    public Client update(Client client) {
        return null;
    }

    @Override
    public Client delete(String id) {
        return null;
    }

    @Override
    public List getAll() {
        return clientRepository.findAll();
    }
}
