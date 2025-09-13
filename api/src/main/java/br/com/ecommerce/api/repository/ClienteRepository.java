package br.com.ecommerce.api.repository;

import br.com.ecommerce.api.model.Cliente;
//import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
    //JpaRepository - CRUD

}
