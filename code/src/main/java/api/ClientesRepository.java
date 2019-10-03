package api;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import homebanking.Cliente;

@RepositoryRestResource(path = "cliente")
public interface ClientesRepository extends PagingAndSortingRepository<Cliente, String> {

}
